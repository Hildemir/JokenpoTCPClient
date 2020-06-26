package Game;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class WaitingOpponent {
    private GraphicsContext gc;
    private Status status;
    private Group root;
    private Image backgroundImg, waitingOpponent, rockImg, paperImg, scissorImg, loading, circle, yourPoints;
    private static double w = 1500, h = 900;
    private MenuItem rock, paper, scissor;
    private int choice, points;


    public WaitingOpponent(GraphicsContext gc, Status status, Group root) {
        this.gc = gc;
        this.status = status;
        this.root = root;
        this.choice = -1;
        // this.points = 0;
        images();
//        this.rock = new MenuItem(rockImg, 200, 270, gc, root);     // x1= 200 x2= 200 + 300
//        rock.removeFromView(root);
//        this.paper = new MenuItem(paperImg, 600, 270, gc, root);   // x1= 600 x2= 600 + 300
//        paper.removeFromView(root);
//        this.scissor = new MenuItem(scissorImg, 1000, 270, gc, root);   // x1= 1000 x2= 1000 + 300
//        scissor.removeFromView(root);
    }


    private void images() {
        backgroundImg = new Image("/Resources/rays.jpg");
        waitingOpponent = new Image("/Resources/waitingOpponent.png");
        rockImg = new Image("/Resources/rock.png");
        paperImg = new Image("/Resources/paper.png");
        scissorImg = new Image("/Resources/scissor.png");
        loading = new Image("/Resources/loadingTransparent.gif");
        //  circle = new Image("/Resources/circle.png");
        //yourPoints = new Image("/Resources/yourPoints.png");
        //arrow = new Image("/Resources/arrowF.png");
        //play = new Image("/Resources/play.png");
    }

    public void drawing(KeyEvent key, Group root, int choice) {
        gc.drawImage(backgroundImg, 0, 0, w, h);
        gc.drawImage(waitingOpponent, 330, 20, 800, 200);
        gc.drawImage(loading, 550, 300, 400, 300);
        if(choice == 0){
            gc.drawImage(rockImg, 250, 270);
        } else if(choice == 1){
            gc.drawImage(paperImg, 250, 270);
        }else {
            gc.drawImage(scissorImg, 250, 270);
        }
        // gc.drawImage(perg, 150,-100,1200,1100);
//        gc.drawImage(yourPoints, 0, 700, 250, 100);
//        if (points != 0) {
//            if (points == 1) {
//                gc.drawImage(circle, 50, 770, 80, 80);
//            } else {
//                gc.drawImage(circle, 50, 770, 80, 80);
//                gc.drawImage(circle, 160, 770, 80, 80);
//            }
//
//        }
        //playButton.addToView(root);

    }
}
