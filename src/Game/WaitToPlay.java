package Game;

import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

import java.io.IOException;

public class WaitToPlay {
    private GraphicsContext gc;
    private Status status;
    private Group root;
    private Image backgroundImg,searchingPlayerImg, loading, reminder;
    private static double w = 1500, h = 900;
    private MenuItem backButton, playButton;
    private TCPClient client;


    public WaitToPlay(GraphicsContext gc, Status status, Group root) throws IOException {
        this.gc = gc;
        this.status = status;
        this.root = root;
        images();
        //this.client = new TCPClient();

//        this.backButton = new MenuItem(arrow, 50,50,gc,root);
//        backButton.removeFromView(root);
//        this.playButton = new MenuItem(play, 500,570,gc,root);
//        playButton.removeFromView(root);
    }


    private void images() {
        backgroundImg = new Image("/Resources/rays.jpg");
        searchingPlayerImg = new Image("/Resources/searchingPlayer.png");
        reminder = new Image("/Resources/reminder.png");
        loading = new Image("/Resources/loadingTransparent.gif");
        //arrow = new Image("/Resources/arrowF.png");
        //play = new Image("/Resources/play.png");
    }

    public void drawing(KeyEvent key, Group root ){
        gc.drawImage(backgroundImg, 0,0,w,h);
        gc.drawImage(searchingPlayerImg, 330, 20, 800, 200);
        gc.drawImage(loading, 550, 300, 400, 300);
        gc.drawImage(reminder, 475, 100, 500, 150);
        // Se encontrar um jogador troca para a tela de jogo
//        if(client.enviarJogada(1) >= 0){
//            Main.setStatus(Status.GAME);
//        } else{
//            System.out.println("Nenhum jogador encontrado.");
//        }
        // gc.drawImage(perg, 150,-100,1200,1100);
        //backButton.addToView(root);
        //playButton.addToView(root);

//        backButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                //remove botao de voltar
//                root.getChildren().remove(1, root.getChildren().size());
//                // adiciona botoes do menu
//                for (MenuItem item: Main.menu.getItems()) {
//                    item.addToView(root);
//                }
//                Main.setStatus(Status.MENU);
//
//            }
//        });
//
//        playButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                //remove botao de voltar
//                root.getChildren().remove(1, root.getChildren().size());
//                Main.setStatus(Status.GAME);
//
//            }
//        });

        //text.drawing(mouse, key, root);

        //gc.drawImage(titleMenu, 490, 120, 900, 300,);
    }

//    public TCPClient getClient() {
//        return client;
//    }
}
