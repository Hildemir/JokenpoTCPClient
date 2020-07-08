package Game;


import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public abstract class Element implements Drawable{
    private double x0,x1,y0,y1 , x , y;
    private EventHandler<MouseEvent> onMouseClicked;
    private GraphicsContext gc;
    private boolean inside = false;

    // [Construtor]
    public Element(double x, double y, GraphicsContext gc) {
        this.x = x;
        this.y = y;
        this.gc = gc;
    }

    // [On mouse event]
    public void setOnMouseClicked (EventHandler <MouseEvent> onMouseClicked) {
        this.onMouseClicked = onMouseClicked;
    }

    // [Verifica evento no mouse]
    public void event(MouseEvent mouse, KeyEvent key) {
        if(mouse == null) {
            return;
        }
        if(inside(mouse)) {
            if (onMouseClicked != null && mouse.getEventType().getName().equals("MOUSE_CLICKED")) {
                System.out.println(mouse.getClickCount());
                onMouseClicked.handle(mouse);
            }
        }
    }

    // [Verifica se o mouse esta dentro de determinada area]
    private boolean inside(MouseEvent mouse, double x0, double x1, double y0, double y1) {
        if(mouse != null) {
            return (mouse.getX() > x0 && mouse.getX() < x1 && mouse.getY() > y0 && mouse.getY() < y1);
        } else {
            return false;
        }
    }

    private boolean inside(MouseEvent event) {
        return inside(event, x0, x1, y0, y1);
    }


    // [Getters e setters]
    public GraphicsContext getGc() {
        return gc;
    }

    public void setGc(GraphicsContext gc) {
        this.gc = gc;
    }

    public double getPosX() {
        return x;
    }
    public void setPosX(double posX) {
        this.x = posX;
    }
    public double getPosY() {
        return y;
    }
    public void setPosY(double posY) {
        this.y = posY;
    }

    public double getX0() {
        return x0;
    }

    public void setX0(double x0) {
        this.x0 = x0;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getY0() {
        return y0;
    }

    public void setY0(double y0) {
        this.y0 = y0;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

}
