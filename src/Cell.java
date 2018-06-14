import javax.swing.*;
import java.awt.*;

/**
 * Created by simao on 2018/6/5.
 */
public class Cell extends JButton{
    public static final int WIDTH = 200;
    public static final int HEIGHT = 200;
    private Point buttonPoint;
    private Image buttonImage;

    public Cell(Image image,Point point){
        this(image);
        buttonPoint = point;
    }

    public Cell(Image image){
        buttonImage = image;
        setSize(WIDTH,HEIGHT);
        repaint();
    }


    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(buttonImage,0,0,WIDTH,HEIGHT,this);

    }

    public Point getButtonPoint() {
        return buttonPoint;
    }

    public void setButtonPoint(Point buttonPoint) {
        this.buttonPoint = buttonPoint;
    }

    public Image getButtonImage() {
        return buttonImage;
    }

    public void setButtonImage(Image buttonImage) {
        this.buttonImage = buttonImage;
    }

    public boolean isNeighborNullCell(Cell nullCell) {
        Point currentCellPoint = this.getButtonPoint();
        Point nullCellPoint = nullCell.getButtonPoint();
        boolean c1 = Math.abs(currentCellPoint.getX() - nullCellPoint.getX()) == 1
                && (currentCellPoint.getY() == nullCellPoint.getY());
        boolean c2 = Math.abs(currentCellPoint.getY() - nullCellPoint.getY()) == 1
                && (currentCellPoint.getX() == nullCellPoint.getX());
        return (c1 || c2);
    }
}
