package Game;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

public class WaitingOpponent {
    private GraphicsContext gc;
    private Status status;
    private Group root;
    private Image backgroundImg, waitingOpponent, rockImg, paperImg, scissorImg, loading, circle, yourPoints;
    private static double w = 1500, h = 900;
    private int choice, points;

    // [Construtor]
    public WaitingOpponent(GraphicsContext gc, Status status, Group root) {
        this.gc = gc;
        this.status = status;
        this.root = root;
        //this.choice = -1;
        // this.points = 0;
        images();
    }

    // [Carrega imagens]
    private void images() {
        backgroundImg = new Image("/Resources/rays.jpg");
        waitingOpponent = new Image("/Resources/waitingOpponent.png");
        rockImg = new Image("/Resources/rock.png");
        paperImg = new Image("/Resources/paper.png");
        scissorImg = new Image("/Resources/scissor.png");
        loading = new Image("/Resources/loadingTransparent.gif");
    }

    // [Desenha tela WaintingOpponent]
    public void drawing(KeyEvent key, Group root, TCPClient client, RoundResult roundResult) {
        gc.drawImage(backgroundImg, 0, 0, w, h);
        gc.drawImage(waitingOpponent, 330, 20, 800, 200);
        gc.drawImage(loading, 550, 300, 400, 300);

        // [Exibe carta jogada pelo cliente]
        if(client.getJogada() == 1){
            gc.drawImage(rockImg, 250, 270);
        } else if(client.getJogada() == 2){
            gc.drawImage(paperImg, 250, 270);
        }else if(client.getJogada() == 3){
            gc.drawImage(scissorImg, 250, 270);
        }

//        System.out.println("valor de jogada: " + client.getJogada());
//        System.out.println("valor de jogada servidor: " + client.getJogadaServidor());

        // [Se os 2 jogadores ja tiverem jogado, manda para atela RoundResult]
        if(client.getJogada() > 0 && client.getJogadaServidor() > 0){
            Main.setStatus(Status.ROUNDRESULT);
        }
    }
}
