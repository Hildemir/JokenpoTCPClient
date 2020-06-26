package Game;

import javafx.scene.Group;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public interface Drawable {
    void drawing(MouseEvent mouse, KeyEvent key,Group group);
}
