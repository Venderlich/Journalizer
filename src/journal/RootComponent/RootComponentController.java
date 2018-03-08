/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package journal.RootComponent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import FXRouter.FXRouter;
import com.google.inject.Inject;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import journal.Routes;

/**
 * FXML Controller class
 *
 * @author Tristan
 */
public class RootComponentController implements Initializable {

    @FXML
    private Pane routingNode;

    @FXML
    private BorderPane mainBorderPane;

    @Inject
    FXMLLoader loader;

    @FXML
    private void goToInsertFiliere(ActionEvent event) throws Exception {
        try {
            FXRouter.getInstance().bindRoutingNode(routingNode);
            FXRouter.getInstance().goTo(Routes.INSERT_FILIERE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goToInsertMatiere(ActionEvent event) throws Exception {
        try {
            FXRouter.getInstance().bindRoutingNode(routingNode);
            FXRouter.getInstance().goTo(Routes.INSERT_MATIERE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goToReadMatiere(ActionEvent event) throws Exception {
        try {
            FXRouter.getInstance().bindRoutingNode(routingNode);
            FXRouter.getInstance().goTo(Routes.READ_MATIERE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goToReadFiliere(ActionEvent event) throws Exception {
        try {
            FXRouter.getInstance().bindRoutingNode(routingNode);
            FXRouter.getInstance().goTo(Routes.READ_FILIERE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goToInsertTypeDeCour(ActionEvent event) throws Exception {
        try {
            FXRouter.getInstance().bindRoutingNode(routingNode);
            FXRouter.getInstance().goTo(Routes.INSERT_TYPEDECOUR);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML

    private void goToReadTypeDeCour(ActionEvent event) throws Exception {
        try {
            FXRouter.getInstance().bindRoutingNode(routingNode);
            FXRouter.getInstance().goTo(Routes.READ_TYPEDECOUR);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML

    private void goToInsertParametre(ActionEvent event) throws Exception {
        try {
            FXRouter.getInstance().bindRoutingNode(routingNode);
            FXRouter.getInstance().goTo(Routes.INSERT_PARAMETRE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goToInsertCour(ActionEvent event) throws Exception {
        try {
            FXRouter.getInstance().bindRoutingNode(routingNode);
            FXRouter.getInstance().goTo(Routes.INSERT_COUR);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void logOut(ActionEvent event) throws Exception {
        try {
            FXRouter.getInstance().goTo(Routes.LOGIN);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Initializes the controller class.
     */


    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // FXRouter.getInstance().bindRoutingNode(routingNode);
    }


}
