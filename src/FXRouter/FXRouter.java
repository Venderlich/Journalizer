package FXRouter;

/*
 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.
 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.
 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
import java.io.IOException;
import java.util.AbstractMap;
import java.util.HashMap;

import javafx.fxml.FXMLLoader;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;


/**
 * FXRouter allows to manage scenes switching on JavaFX Application with an easy API
 * Inspired by Angular JS $routeProvider
 * @author Marco Trombino
 * @version 1.0.0
 */
public final class FXRouter {
    public static FXRouter getInstance() {
        if (instance == null) {
            instance = new FXRouter();
        }
        return instance;
    }
    private static FXRouter instance;

    private FXMLLoader loader;

    // FXRouter Main Class reference to get main package
    private Object mainRef;
    private Stage window;

    private AbstractMap<String, SceneConfiguration> routes = new HashMap<>();

    private SceneConfiguration currentScene;
    private Object data;

    /**
     * FXRouter constructor kept private to apply Singleton pattern
     */
    private FXRouter() {}

    public FXRouter bind(Object application, Stage win) {
        checkInstances(application, win);
        currentScene = new SceneConfiguration("", "", win.getWidth(), win.getHeight());
        return this;
    }

    public FXRouter bind(Object application, Stage win, String winTitle) {
        checkInstances(application, win);
        currentScene = new SceneConfiguration("", winTitle, win.getWidth(), win.getHeight());
        return this;
    }

    public FXRouter bind(Object application, Stage win, double winWidth, double winHeight) {
        checkInstances(application, win);
        currentScene = new SceneConfiguration("", "", winWidth, winHeight);
        return this;
    }

    /** FXRouter binder with Application Stage and main package
     * @param application: Main Class reference
     * @param win: Application Stage
     * @param winTitle: Application Stage title
     * @param winWidth: Application Stage width
     * @param winHeight: Application Stage height
     */
    public FXRouter bind(Object application, Stage win, String winTitle, double winWidth, double winHeight) {
        checkInstances(application, win);
        currentScene = new SceneConfiguration("", winTitle, winWidth, winHeight);
        return this;
    }

    /**
     * Bind a custom loader to use for the router
     * @param loader FXMLLoader to be used by the router
     */
    public FXRouter bindLoader(FXMLLoader loader) {
        this.loader = loader;
        return this;
    }

    /** set FXRouter references only if they are not set yet
     * @param ref: Main Class reference
     * @param win: Application Stage
     */
    private void checkInstances(Object ref, Stage win) {
        if(mainRef == null)
            mainRef = ref;
        if(window == null)
            window = win;
        if(loader == null)
            loader = new FXMLLoader();
    }

    public FXRouter when(String routeLabel, String scenePath) {
        SceneConfiguration scene = new SceneConfiguration(scenePath, currentScene.getWindowTitle(), currentScene.getWindowWidth(), currentScene.getWindowHeight());
        routes.put(routeLabel, scene);
        return this;
    }

    public FXRouter when(String routeLabel, String scenePath, String winTitle) {
        SceneConfiguration scene = new SceneConfiguration(scenePath, winTitle, currentScene.getWindowWidth(), currentScene.getWindowHeight());
        routes.put(routeLabel, scene);
        return this;
    }

    public FXRouter when(String routeLabel, String scenePath, double sceneWidth, double sceneHeight) {
        SceneConfiguration scene = new SceneConfiguration(scenePath, currentScene.getWindowTitle(), sceneWidth, sceneHeight);
        routes.put(routeLabel, scene);
        return this;
    }

    /** Define a FXRouter route
     * @param routeLabel: Route label identifier
     * @param scenePath: .FXML scene file
     * @param winTitle: Scene (Stage) title
     * @param sceneWidth: Scene Width
     * @param sceneHeight: Scene Height
     */
    public FXRouter when(String routeLabel, String scenePath, String winTitle, double sceneWidth, double sceneHeight) {
        SceneConfiguration scene = new SceneConfiguration(scenePath, winTitle, sceneWidth, sceneHeight);
        routes.put(routeLabel, scene);
        return this;
    }

    public void goTo(String routeLabel) throws IOException {
        SceneConfiguration scene = routes.get(routeLabel);
        loadNewScene(scene);
    }

    /** Switch between FXRouter route and show corresponding scenes
     * @param routeLabel: Route label identifier
     * @param data: Data passed to route
     * @throws Exception: throw FXMLLoader exception if file is not loaded correctly
     */
    public void goTo(String routeLabel, Object data) throws IOException {
        SceneConfiguration route = routes.get(routeLabel);
        this.data = data;
        loadNewScene(route);
    }

    /** Helper method of goTo() which load and show new scene
     * @throws Exception: throw FXMLLoader exception if file is not loaded correctly
     */
    private void loadNewScene(SceneConfiguration scene) throws IOException {
        // get Main Class package name to get correct files path
        String pathRef = mainRef.getClass().getPackage().getName();
        // create correct file path.  "/" doesn't affect any OS
        String scenePath = "/" + pathRef + "/" + scene.getScenePath();

        // load .fxml resource
        Parent resource = loader.load(new Object() { }.getClass().getResource(scenePath), loader.getResources(), loader.getBuilderFactory(), loader.getControllerFactory());

        if (routingNode != null) {
            loadInNode(resource);
        } else {
            loadInWindow(scene, resource);
        }
        
        Animator.animate(resource);

        currentScene = scene;
    }

    private void loadInNode(Parent resource) {
        routingNode.getChildren().clear();
        routingNode.getChildren().add(resource);
    }

    private void loadInWindow(SceneConfiguration scene, Parent resource) {
        window.setTitle(scene.getWindowTitle());
        window.setScene(new Scene(resource, scene.getWindowWidth(), scene.getWindowHeight()));
        window.show();
    }

    /**
     * Get current route data
     */
    public Object getData() {
        return data;
    }

    private Pane routingNode;
    public void bindRoutingNode(Pane node){
        this.routingNode = node;
    }
}