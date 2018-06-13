import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by simao on 2018/6/5.
 */
public class PuzzlePanel extends JPanel {
    GameWindow gameWin;
    int row,column;
    private Cell[][] cells;
    private Image[][] cellImages;
    BufferedImage image;

    public ArrayList<Image> getImageList() {
        return imageList;
    }

    public void setImageList(ArrayList<Image> imageList) {
        this.imageList = imageList;
    }

    private ArrayList<Image> imageList;

    public PuzzlePanel(GameWindow gameWin){
        this.gameWin = gameWin;
        setLayout(null);
    }

    public void initPanel() {
        removeAll();
        image = gameWin.getImage();
        row = gameWin.getRow();
        column = gameWin.getColumn();
        setSize(new Dimension(Cell.WIDTH * column,Cell.HEIGHT*row));


        cells = new Cell[row][column];
        SplitImage split = new SplitImage();
        cellImages = split.getImages(image,row,column);


        imageList = new ArrayList<Image>();
        for(int i=0;i<row;i++) {
            for (int j = 0; j < column; j++) {
                imageList.add(cellImages[i][j]);
            }
        }
        imageList.remove(row*column -1);

        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                cells[i][j] = new Cell(cellImages[i][j],new Point(i,j));
                cells[i][j].setBorder(null);
                this.add(cells[i][j]);
                cells[i][j].setLocation(j*Cell.WIDTH,i*Cell.HEIGHT);

            }
        }


    }

    public Cell[][] getCells() {
        return cells;
    }
}
