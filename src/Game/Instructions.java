package Game;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class Instructions {
    private GraphicsContext gc;
    private Status status;
    private Group root;
    private Image backgroundImg, perg, arrow, play;
    private static double w = 1500, h = 900;
    private MenuItem backButton, playButton;
    private boolean buttonsOn;

    // [Construtor]
    public Instructions(GraphicsContext gc, Status status, Group root) {
        this.gc = gc;
        this.status = status;
        this.root = root;
        images();
        this.backButton = new MenuItem(arrow, 50,50,gc,root);
        backButton.removeFromView(root);
        this.playButton = new MenuItem(play, 500,570,gc,root);
        playButton.removeFromView(root);
        this.buttonsOn = false;
    }

    // [Carrega images]
    private void images() {
        backgroundImg = new Image("/Resources/raysInstruction.jpg");
        perg = new Image("/Resources/pergaminhoInstrucoesTeste.png");
        arrow = new Image("/Resources/arrowF.png");
        play = new Image("/Resources/play.png");
    }

    // [Desenha tela Instructions]
    public void drawing( KeyEvent key, Group root ){
        gc.drawImage(backgroundImg, 0,0,w,h);
        gc.drawImage(perg, 150,-100,1200,1100);
        if(!buttonsOn) {
            backButton.addToView(root);
            playButton.addToView(root);
            setButtonsOn(true);
        }
        backButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //remove botao de voltar
                root.getChildren().remove(1, root.getChildren().size());
                // adiciona botoes do menu
                for (MenuItem item: Main.menu.getItems()) {
                    item.addToView(root);
                }
                // [Reinicia estado dos botoes]
                setButtonsOn(false);
                Main.setStatus(Status.MENU);

            }
        });

        playButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //remove botao de voltar
                root.getChildren().remove(1, root.getChildren().size());
                // [Reinicia estado dos botoes]
                setButtonsOn(false);
                Main.setStatus(Status.WAITTOPLAY);

            }
        });
    }

    public void setButtonsOn(boolean buttonsOn) {
        this.buttonsOn = buttonsOn;
    }
}
