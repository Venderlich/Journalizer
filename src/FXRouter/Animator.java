package FXRouter;

import javafx.animation.FadeTransition;
import javafx.scene.Parent;
import javafx.util.Duration;

class Animator {
    private static final Double FADE_ANIMATION_DURATION = 800.0;
    // routes switching animation
    private static String animationType;
    private static Double animationDuration;

    /** set FXRouter switching animation
     * @param anType: Animation type
     */
    public static void setAnimationType(String anType) {
        animationType = anType;
    }

    /** set FXRouter switching animation
     * @param anType: Animation type
     * @param anDuration: Animation duration
     */
    public static void setAnimationType(String anType, double anDuration) {
        animationType = anType;
        animationDuration = anDuration;
    }

    /** Animate routes switching based on animation type
     * @param node: .FXML scene file to animate
     */
    public static void animate(Parent node) {
        String anType = animationType != null ? animationType.toLowerCase() : "";
        switch(anType) {
            case "fade":
                Double fd = animationDuration != null ? animationDuration : FADE_ANIMATION_DURATION;
                FadeTransition ftCurrent = new FadeTransition(Duration.millis(fd), node);
                ftCurrent.setFromValue(0.0);
                ftCurrent.setToValue(1.0);
                ftCurrent.play();
                break;
            default:
                break;
        }
    }
}
