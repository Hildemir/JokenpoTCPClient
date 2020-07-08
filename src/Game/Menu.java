package Game;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;

public class Menu implements Drawable{
    private GraphicsContext gc;
    private Status status;
    private Image backgroundImg, gatoSorte,titleMenu, playButton, perg, instructionsButton;
    private static double w = 1500, h = 900;
    private List<MenuItem> items;
    private Group root;

    // [Construtor]
    public Menu(GraphicsContext gc, Status status, Group root) {
        this.gc = gc;
        this.status = status;
        this.root = root;
        items = new ArrayList<>();
        buttons();
        menuItems();
        images();
    }

    // [Carrega imagens]
    private void images() {
        backgroundImg = new Image("/Resources/rays.jpg");
        gatoSorte = new Image("/Resources/gatoDaFortuna.gif");
        titleMenu = new Image ("/Resources/jokenpoTitle.png");
    }

    // [Carrega imagens dos botoes]
    private void buttons() {
        playButton = new Image("/Resources/jogar.png");
        instructionsButton = new Image("/Resources/instrucoes.png");
        perg = new Image("/Resources/sair.png");

    }

    // [Desenha tela Menu]
    @Override
    public void drawing(MouseEvent mouse, KeyEvent key, Group root ){
        gc.drawImage(backgroundImg, 0,0,w,h);
        gc.drawImage(gatoSorte, 100,100,500,800);
        gc.drawImage(titleMenu, 490, 120, 900, 300);
    }

    // [Cria botoes]
    private void menuItems() {
        items.add(new MenuItem(playButton,710,393, gc, root));
        items.add(new MenuItem(instructionsButton,710,535, gc, root));
        items.add(new MenuItem(perg,710,675, gc, root));

        items.get(0).setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                root.getChildren().remove(1, root.getChildren().size());
                Main.setStatus(Status.WAITTOPLAY);
            }
        });

        items.get(1).setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                root.getChildren().remove(1, root.getChildren().size());
                Main.setStatus(Status.INSTRUCTIONS);
            }
        });

        items.get(2).setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Main.setStatus(Status.CLOSE);
            }
        });
    }

    // [Getters e setters]
    public List<MenuItem> getItems() {
        return items;
    }
}
