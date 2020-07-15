package Game;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class MenuItem extends Element{
    private String item;
    private Color color;
    private TextAlignment alignment = TextAlignment.CENTER;
    private Font fontName;
    private Text text;
    private double textSize;
    private Image buttonImage;
    private ImageView buttonImageV;

    // [Construtor]
    public MenuItem (Image buttonImage, double posX, double posY, GraphicsContext gc, Group root) {
        super(posX, posY, gc);
        this.buttonImage = buttonImage;
        setX0(getPosX() - buttonImage.getRequestedWidth()/2);
        setX1(getPosX() + buttonImage.getRequestedWidth()/2);
        setY0(getPosY() - buttonImage.getRequestedHeight()/2);
        setY1(getPosY() + buttonImage.getRequestedHeight()/2);
        buttonImageV = new ImageView(buttonImage);
        buttonImageV.setX(getPosX() );
        buttonImageV.setY(getPosY() );
        addToView(root);
    }

    // [Desenha menuItem]
    public void drawing(MouseEvent mouse, KeyEvent key, Group root) {
        event(mouse,key);
        getGc().setTextAlign(alignment);
        getGc().setFont(fontName);
        getGc().setFill(color);
        getGc().fillText(item,getPosX(), getPosY());
        getGc().strokeText(item, getPosX(), getPosY());
    }

    public void setOnMouseClicked(EventHandler<MouseEvent> event){
        super.setOnMouseClicked(event);
        if (buttonImage != null) {
            buttonImageV.setOnMouseClicked(event);
        }
    }

    public void addToView(Group root) {
        root.getChildren().add(buttonImageV);
    }

    public void removeFromView(Group root) {
        root.getChildren().remove(buttonImageV);
    }
}
