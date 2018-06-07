import javax.swing.*;
import java.awt.*;

/**
 * Created by simao on 2018/6/5.
 */
public class PuzzlePanel extends JPanel {
    GameWindow gameWin;
    int row,column;

    public PuzzlePanel(GameWindow gameWin){
        this.gameWin = gameWin;
        setLayout(null);
    }

    public void initPanel() {
        setSize(new Dimension(Cell.WIDTH * column,Cell.HEIGHT*row));
    }
}
