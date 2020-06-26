package Game;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class Menu implements Drawable{
    private GraphicsContext gc;
    private Status status;
    private Image backgroundImg, gatoSorte, pacMan, titleMenu, orange1, orange2, orange3, orange4, orange5, orange6, playButton, perg, instructionsButton;
    private static double w = 1500, h = 900;
    private List<MenuItem> items;
    private Group root;
    private Rectangle [] rectangles;
    private String sound = "/home/hildemir/IdeaProjects/PacMath/src/resources/PacManThemeREMIX.mp3";             //pacmanbeginning.mp3
   // private ColRect rect;
    private boolean play = true;
    private boolean arrowBlink = true;


    public Menu(GraphicsContext gc, Status status, Group root) {
        this.gc = gc;
        this.status = status;
        this.root = root;
        items = new ArrayList<>();
        buttons();
        menuItems();
        images();

        //tocarMusica();                ja eh chamada no drawing
        //this.numMenu = new MenuItem[5];
//        for(int i = 0; i < 5; i++) {
//            if (i == 0){
//                this.numMenu[0] = new MenuItem("4", Color.DEEPPINK, gc, "emulogic.ttf", 465, 545, 78, root);
//            } else if (i == 1){
//                this.numMenu[1] = new MenuItem("7", Color.DEEPPINK, gc, "emulogic.ttf", 158, 282, 78, root);
//            } else if (i == 2){
//                this.numMenu[2] = new MenuItem("5", Color.DEEPPINK, gc, "emulogic.ttf", 161, 797, 78, root);
//            } else if (i == 3){
//                this.numMenu[3] = new MenuItem("2", Color.DEEPPINK, gc, "emulogic.ttf", 1758, 290, 78, root);
//            } else{
//                this.numMenu[4] = new MenuItem("3", Color.DEEPPINK, gc, "emulogic.ttf", 1432, 873, 78, root);
//            }
       // }
        //this.rect = new ColRect(420,455,80,138); // retangulo q esconde dots atras do numero 4

    }


   // private void tocarMusica() {
     //   Main.musicaMenu(sound);
    //}

    private void images() {
        backgroundImg = new Image("/Resources/rays.jpg");
       // rays  = new Image("/Resources/rays.jpg");
        gatoSorte = new Image("/Resources/gatoDaFortuna.gif");
        titleMenu = new Image ("/Resources/jokenpoTitle.png");
    }

    private void buttons() {
        playButton = new Image("/Resources/jogar.png");
        instructionsButton = new Image("/Resources/instrucoes.png");
        perg = new Image("/Resources/sair.png");

    }

    @Override
    public void drawing(MouseEvent mouse, KeyEvent key, Group root ){
        gc.drawImage(backgroundImg, 0,0,w,h);
        gc.drawImage(gatoSorte, 100,100,500,800);
        gc.drawImage(titleMenu, 490, 120, 900, 300);
       // items.get(0).drawing(mouse, root);

        //gc.drawImage(pacMan, 870, 280, (pacMan.getWidth()*1.2), (pacMan.getHeight()*1.2));
//        int num = 0;
//        for(MenuItem name : items) {
//            if(num < 5) {
//                name.drawing(mouse, root);
//
//            } else {
//                name.drawing(mouse, key, root);
//            }
//            num++;
//        }
       // rect.drawTunnel(gc);
        //for (int i =0; i < 5; i++){                 //desenha numeros no menu
          //  numMenu[i].drawing(mouse,key,root);
        //}

        //if(play){
          //  tocarMusica();
           // setPlay(false);
        //}

    }

    public List<MenuItem> getItems() {
        return items;
    }

    private void menuItems() {
        items.add(new MenuItem(playButton,710,393, gc, root));
//        items.add(new MenuItem(orange1,710,458, gc, root));
        items.add(new MenuItem(instructionsButton,710,535, gc, root));
//        items.add(new MenuItem(orange2,710,558, gc, root));
//        items.add(new MenuItem(orange3,710,658, gc, root));
        items.add(new MenuItem(perg,710,675, gc, root));
//        items.add(new MenuItem(orange6,710,758, gc, root));             //sound off
//        items.add(new MenuItem(orange4,710,758, gc, root));             //sound on
//        items.add(new MenuItem(orange5,710,858, gc, root));


        items.get(0).setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                root.getChildren().remove(1, root.getChildren().size());
                Main.setStatus(Status.WAITTOPLAY);
                //Main.getPlayer().stop();
                setPlay(true);
                setArrowBlink(true);


            }
        });

        items.get(1).setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                root.getChildren().remove(1, root.getChildren().size());
                Main.setStatus(Status.INSTRUCTIONS);
                //Main.getPlayer().stop();
                setPlay(true);
                setArrowBlink(true);

            }
        });

//        items.get(3).setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                if (Main.getPlayer().isMute() == false){
//                    Main.getPlayer().setMute(true);
//                } else{
//                    Main.getPlayer().setMute(false);
//                    items.get(4).addToView(root);
//                }
//            }
//        });

        items.get(2).setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Main.setStatus(Status.CLOSE);
            }
        });
    }

    public boolean isPlay() {
        return play;
    }

    public void setPlay(boolean play) {
        this.play = play;
    }

    public boolean isArrowBlink() {
        return arrowBlink;
    }

    public void setArrowBlink(boolean arrowBlink) {
        this.arrowBlink = arrowBlink;
    }
}
