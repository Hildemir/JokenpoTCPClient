package Game;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

public class RoundResult {
    private GraphicsContext gc;
    private Status status;
    private Group root;
    private Image backgroundImg, title, rockImg, paperImg, scissorImg, winnerRightArrow, winnerLeftArrow, deadlock, result, youLose, youWin, deadlockMessage;
    private static double w = 1500, h = 900;
    private int  points, serverPoints, jogada, jogadaServidor;
    private boolean contaPonto;

    // [Construtor]
    public RoundResult(GraphicsContext gc, Status status, Group root) {
        this.gc = gc;
        this.status = status;
        this.root = root;
        images();
        this.points = 0;
        this.serverPoints = 0;
        this.contaPonto = true;
    }

    // [Carrega imagens]
    private void images() {
        backgroundImg = new Image("/Resources/rays.jpg");
        rockImg = new Image("/Resources/rock.png");
        paperImg = new Image("/Resources/paper.png");
        scissorImg = new Image("/Resources/scissor.png");
        winnerRightArrow = new Image("/Resources/winnerRightArrow.png");
        winnerLeftArrow = new Image("/Resources/winnerLeftArrow.png");
        deadlock = new Image("/Resources/deadlock.png");
        youLose = new Image("/Resources/youLose.png");
        youWin = new Image("/Resources/youWin.png");
        deadlockMessage = new Image("/Resources/deadlockMessage.png");
    }

    // [Desenha tela RoundResult]
    public void drawing(KeyEvent key, Group root, Game gameScreen, TCPClient client, GameOver gameOver) {

        this.jogada = client.getJogada();
        this.jogadaServidor = client.getJogadaServidor();

        // [Caso algum jogador nao tenha jogado]
        if(client.getJogadaServidor() == 0 || client.getJogada() == 0 ){
            Main.setStatus(Status.GAME);
            gameScreen.setButtonsOn(false);
        } else {
            // [Caso tenham jogado]
            // [Calcula resultado por partida]
            if (jogada == jogadaServidor) {
                title = deadlockMessage;
                result = deadlock;
            } else if (jogada == 1 && jogadaServidor == 2) {
                title = youLose;
                result = winnerLeftArrow;
            } else if (jogada == 1 && jogadaServidor == 3) {
                title = youWin;
                result = winnerRightArrow;
            } else if (jogada == 2 && jogadaServidor == 1) {
                title = youWin;
                result = winnerRightArrow;
            } else if (jogada == 2 && jogadaServidor == 3) {
                title = youLose;
                result = winnerLeftArrow;
            } else if (jogada == 3 && jogadaServidor == 1) {
                title = youLose;
                result = winnerLeftArrow;
            } else if (jogada == 3 && jogadaServidor == 2) {
                title = youWin;
                result = winnerRightArrow;
            }

            if(title == youWin && contaPonto){
                points++;
                contaPonto = false;
            } else if(title == youLose && contaPonto){
                serverPoints++;
                contaPonto = false;
            }

            // [Verifica se houve ganhador]
            if(points == 3 || serverPoints == 3){
                if(points == 3){
                    gameOver.setGanhou(true);
                }
                Main.setStatus(Status.GAMEOVER);
            }

            // [Exibe background]
            gc.drawImage(backgroundImg, 0, 0, w, h);
            // [Exibe carta jogada pelo cliente]
            if (jogada == 1) {
                gc.drawImage(rockImg, 250, 270);
            } else if (jogada == 2) {
                gc.drawImage(paperImg, 250, 270);
            } else if (jogada == 3) {
                gc.drawImage(scissorImg, 250, 270);
            }

            // [Exibe carta jogada pelo servidor]
            if (jogadaServidor == 1) {
                gc.drawImage(rockImg, 920, 270);
            } else if (jogadaServidor == 2) {
                gc.drawImage(paperImg, 920, 270);
            } else if (jogadaServidor == 3) {
                gc.drawImage(scissorImg, 920, 270);
            }

            // [Exibe titulo]
            gc.drawImage(title, 330, 20, 800, 200);

            // [Exibe resultado]
            gc.drawImage(result, 650, 300);
        }
    }

    public int getPoints() {
        return points;
    }

    public int getServerPoints() {
        return serverPoints;
    }

    public void setContaPonto(boolean contaPonto) {
        this.contaPonto = contaPonto;
    }
}
