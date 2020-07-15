package Game;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class Game {
    private GraphicsContext gc;
    private Status status;
    private Group root;
    private Image backgroundImg, yourTurn, rockImg, paperImg, scissorImg, circle, yourPoints, opponentPoints;
    private static double w = 1500, h = 900;
    private MenuItem rock, paper, scissor;
    private int choice, points, serverPoints;
    boolean buttonsOn;

    // [Construtor]
    public Game(GraphicsContext gc, Status status, Group root) {
        this.gc = gc;
        this.status = status;
        this.root = root;
        this.choice = 0;
        this.points = 0;
        this.serverPoints = 0;
        images();
        this.rock = new MenuItem(rockImg, 200,270,gc,root);     // x1= 200 x2= 200 + 300
        rock.removeFromView(root);
        this.paper = new MenuItem(paperImg, 600,270,gc,root);   // x1= 600 x2= 600 + 300
        paper.removeFromView(root);
        this.scissor = new MenuItem(scissorImg, 1000,270,gc,root);   // x1= 1000 x2= 1000 + 300
        scissor.removeFromView(root);
        this.buttonsOn = false;
    }

    // [Carrega imagens]
    private void images() {
        backgroundImg = new Image("/Resources/rays.jpg");
        yourTurn = new Image("/Resources/yourTurnImg.png");
        rockImg = new Image("/Resources/rock.png");
        paperImg = new Image("/Resources/paper.png");
        scissorImg = new Image("/Resources/scissor.png");
        circle = new Image("/Resources/circle.png");
        yourPoints = new Image("/Resources/yourPoints.png");
        opponentPoints = new Image("/Resources/opponentPoints.png");
    }

    // [Desenha tela Game]
    public void drawing(KeyEvent key, Group root, TCPClient client, RoundResult roundResult){
        gc.drawImage(backgroundImg, 0,0,w,h);
        gc.drawImage(yourTurn, 330, 20, 800, 200);

        // [Adiciona cartas]
        if(!buttonsOn) {
            rock.addToView(root);
            paper.addToView(root);
            scissor.addToView(root);
            setButtonsOn(true);
        }

        gc.drawImage(yourPoints, 0, 700, 250, 100);
        gc.drawImage(opponentPoints, 1250, 700, 250, 100);

        // [Adiciona pontos do cliente]
        this.setPoints(roundResult.getPoints());
        if(points != 0){
            if(points == 1){
                gc.drawImage(circle, 50,770,50,50);
            } else if(points == 2){
                gc.drawImage(circle, 50,770,50,50);
                gc.drawImage(circle, 110,770,50,50);
            } else if(points == 3){
                gc.drawImage(circle, 50,770,50,50);
                gc.drawImage(circle, 110,770,50,50);
                gc.drawImage(circle, 170,770,50,50);
            }

        }

        // [Adiciona pontosdo cliente]
        this.setServerPoints(roundResult.getServerPoints());
        if(serverPoints != 0){
            if(serverPoints == 1){
                gc.drawImage(circle, 1300,770,50,50);
            } else if(serverPoints == 2){
                gc.drawImage(circle, 1300,770,50,50);
                gc.drawImage(circle, 1360,770,50,50);
            } else if(serverPoints == 3){
                gc.drawImage(circle, 1300,770,50,50);
                gc.drawImage(circle, 1360,770,50,50);
                gc.drawImage(circle, 1420,770,50,50);
            }
        }

        rock.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // [Remove carta apos ser clicada]
                root.getChildren().remove(1, root.getChildren().size());
                setChoice(1);
                client.setJogada(choice);

                try {
                    client.getOutObject().writeInt(choice);
                    client.getOutObject().flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Main.setStatus(Status.WAITINGOPPONENT);
                // [Libera o conta ponto na tela de RoundResult]
                roundResult.setContaPonto(true);


            }
        });

        paper.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // [Remove carta apos ser clicada]
                root.getChildren().remove(1, root.getChildren().size());
                setChoice(2);
                client.setJogada(choice);

                try {
                    client.getOutObject().writeInt(choice);
                    client.getOutObject().flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Main.setStatus(Status.WAITINGOPPONENT);
                // [Libera o conta ponto na tela de RoundResult]
                roundResult.setContaPonto(true);
            }
        });

        scissor.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // [Remove carta apos ser clicada]
                root.getChildren().remove(1, root.getChildren().size());
                setChoice(3);
                client.setJogada(choice);

                try {
                    client.getOutObject().writeInt(choice);
                    client.getOutObject().flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Main.setStatus(Status.WAITINGOPPONENT);
                // [Libera o conta ponto na tela de RoundResult]
                roundResult.setContaPonto(true);
            }
        });

    }

    // [Getters and setters]
    public void setChoice(int choice) {
        this.choice = choice;
    }

    public boolean getButtonsOn() {
        return buttonsOn;
    }

    public void setButtonsOn(boolean buttonsOn) {
        this.buttonsOn = buttonsOn;
    }

    public int getPoints() {
        return points;
    }

    public int getServerPoints() {
        return serverPoints;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setServerPoints(int serverPoints) {
        this.serverPoints = serverPoints;
    }
}
