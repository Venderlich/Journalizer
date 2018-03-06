package FXRouter;

/**
 * FXRouter Inner Class used into routes map
 */
class SceneConfiguration {
    // route .fxml Scene path
    private String scenePath;

    // Scene (Stage) title
    private String windowTitle;
    private double sceneHeight;
    private double sceneWidth;

    /** Route scene constructor
     * @param scenePath: .FXML scene file
     * @param windowTitle: Scene (Stage) title
     * @param sceneWidth: Scene Width
     * @param sceneHeight: Scene Height
     */
    SceneConfiguration(String scenePath, String windowTitle, double sceneWidth, double sceneHeight) {
        this.windowTitle = windowTitle;
        this.sceneHeight = sceneHeight;
        this.sceneWidth = sceneWidth;
        this.scenePath = scenePath;
    }

    public String getWindowTitle() {
        return windowTitle;
    }

    public double getWindowWidth() {
        return sceneWidth;
    }

    public double getWindowHeight() {
        return sceneHeight;
    }

    public String getScenePath() {
        return scenePath;
    }
}