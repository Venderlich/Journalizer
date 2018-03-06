/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package journal.DI;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;
import javafx.fxml.FXMLLoader;

/**
 * @author tc820073
 */
public class FXMLLoaderProvider implements Provider<FXMLLoader> {

    @Inject
    private Injector injector;

    @Override
    public FXMLLoader get() {
        FXMLLoader loader = new FXMLLoader();
        loader.setControllerFactory(injector::getInstance);
        return loader;
    }
}
