package Game;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.List;

public class Instructions {
    private GraphicsContext gc;
    private Status status;
    private Group root;
    private Image backgroundImg, perg, arrow, play;
    private static double w = 1500, h = 900;
    private MenuItem backButton, playButton;


    public Instructions(GraphicsContext gc, Status status, Group root) {
        this.gc = gc;
        this.status = status;
        this.root = root;
        images();
        this.backButton = new MenuItem(arrow, 50,50,gc,root);
        backButton.removeFromView(root);
        this.playButton = new MenuItem(play, 500,570,gc,root);
        playButton.removeFromView(root);
    }


    private void images() {
        backgroundImg = new Image("/Resources/raysInstruction.jpg");
        perg = new Image("/Resources/pergaminhoInstrucoesTeste.png");
        arrow = new Image("/Resources/arrowF.png");
        play = new Image("/Resources/play.png");
    }

    public void drawing( KeyEvent key, Group root ){
        gc.drawImage(backgroundImg, 0,0,w,h);
        gc.drawImage(perg, 150,-100,1200,1100);
        backButton.addToView(root);
        playButton.addToView(root);

        backButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //remove botao de voltar
                root.getChildren().remove(1, root.getChildren().size());
                // adiciona botoes do menu
                for (MenuItem item: Main.menu.getItems()) {
                    item.addToView(root);
                }
                Main.setStatus(Status.MENU);

            }
        });

        playButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //remove botao de voltar
                root.getChildren().remove(1, root.getChildren().size());
                Main.setStatus(Status.WAITTOPLAY);

            }
        });

        //text.drawing(mouse, key, root);

        //gc.drawImage(titleMenu, 490, 120, 900, 300,);
    }

//    MIAAAU,
//    Jokenpo é uma brincadeira japonesa, onde dois jogadores escolhem um dentre três possíveis itens: Pedra, Papel ou Tesoura.
//* Pedra empata com Pedra e ganha de Tesoura
//* Tesoura empata com Tesoura e ganha de Papel
//* Papel empata com Papel e ganha de Pedra
//    Então, mãos e patas aquecidas, VAMOS LÁ!!
}
