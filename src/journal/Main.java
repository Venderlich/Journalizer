/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package journal;

import FXRouter.FXRouter;
import journal.DI.AppModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

import javafx.fxml.JavaFXBuilderFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.util.Callback;
import javafx.stage.Stage;

/**
 * @author Tristan
 */
public class Main extends Application {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {
        // Creation of the dependencies injector
        final Injector injector = Guice.createInjector(new AppModule());
        final Callback<Class<?>, Object> guiceFactory = injector::getInstance;


        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("RootComponent/RootComponent.fxml"),
                null,
                new JavaFXBuilderFactory(),
                guiceFactory
        );

        FXRouter.getInstance()
                .bindLoader(loader)
                .bind(this, primaryStage, "Journalizer")
                .when(Routes.LOGIN, "Login/Login.fxml")
                .when(Routes.ROOT_COMPONENT, "RootComponent/RootComponent.fxml")
                .when(Routes.INSERT_FILIERE, "Filiere/GUI/CreateFiliere.fxml")
                .when(Routes.INSERT_MATIERE, "Matiere/GUI/CreateMatiere.fxml")
                .when(Routes.INSERT_TYPEDECOUR, "TypeDeCour/GUI/CreateTypeDeCour.fxml")
                .when(Routes.INSERT_PARAMETRE, "Parametre/GUI/CreateParametre.fxml")
                .when(Routes.INSERT_COUR, "Cour/GUI/CreateCour.fxml")
                .when(Routes.READ_MATIERE, "Matiere/GUI/ReadMatiere.fxml")
                .when(Routes.READ_FILIERE, "Filiere/GUI/ReadFiliere.fxml")
                .when(Routes.READ_TYPEDECOUR, "TypeDeCour/GUI/ReadTypeDeCour.fxml")
                .goTo(Routes.LOGIN);
    }
}
