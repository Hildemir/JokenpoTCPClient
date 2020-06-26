package Game;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

public class RoundResult {
    private GraphicsContext gc;
    private Status status;
    private Group root;
    private Image backgroundImg, waitingOpponent, rockImg, paperImg, scissorImg, loading, circle, yourPoints;
    private static double w = 1500, h = 900;
    private MenuItem rock, paper, scissor;
    private int choice, points;


    public RoundResult(GraphicsContext gc, Status status, Group root) {
        this.gc = gc;
        this.status = status;
        this.root = root;
        images();
    }

    private void images() {
        backgroundImg = new Image("/Resources/rays.jpg");
    }


    public void drawing(KeyEvent key, Group root) {
         gc.drawImage(backgroundImg, 0, 0, w, h);
    }

}
