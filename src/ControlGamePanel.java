import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by simao on 2018/6/5.
 */
public class ControlGamePanel extends JPanel implements ActionListener{
    JButton buttonStart,buttonPreview,buttonSave,buttonDraw,buttonExit;
    int row,column;
    ArrayList<Image> imageList;
    Cell[][] cells;
    Cell lastCell,noImageCell;
    PuzzlePanel puzzlePanel;
    GameWindow gameWin;
    private JPanel imagePanel;

    public ControlGamePanel(GameWindow gameWin){
        this.gameWin = gameWin;

        buttonStart = new JButton("开始新游戏");
        buttonPreview = new JButton("预览全图");
        buttonSave = new JButton("保存游戏");
        buttonDraw = new JButton("提取游戏");
        buttonExit = new JButton("结束当前游戏");

        add(buttonStart);
        add(buttonPreview);
        add(buttonSave);
        add(buttonDraw);
        add(buttonExit);
        buttonStart.addActionListener(this);
        buttonPreview.addActionListener(this);
        buttonSave.addActionListener(this);
        buttonDraw.addActionListener(this);
        buttonExit.addActionListener(this);


    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == buttonStart){
            row = gameWin.getRow();
            column = gameWin.getColumn();
            puzzlePanel = gameWin.getPuzzlePanel();
            imageList = puzzlePanel.getImageList();
            cells = puzzlePanel.getCells();
            noImageCell = cells[row -1][column -1];
            Image cellImagePanel = noImageCell.getButtonImage();
            imagePanel = gameWin.getImagePanel();
            lastCell = new Cell(cellImagePanel);
            lastCell.setPreferredSize(new Dimension(Cell.WIDTH,Cell.HEIGHT));
            imagePanel.add(lastCell);
            imagePanel.validate();

            noImageCell.setButtonImage(null);
            noImageCell.updateUI();
            MoveListener l = new MoveListener();
            Collections.shuffle(imageList);
            int k=0;

            for(int i=0;i<row;i++) {
                for (int j = 0; j < column; j++) {
                    if(i == row -1 && j== column -1){
                        break;
                    }
                    cells[i][j].setButtonImage(imageList.get(k));
                    cells[i][j].repaint();
                    cells[i][j].updateUI();
                    cells[i][j].addMouseListener(l);
                    k++;
                }
            }

            noImageCell.addMouseListener(l);
            puzzlePanel.validate();


        }else if(e.getSource() == buttonPreview){

        }
    }

    private class MoveListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            Cell currentCell = (Cell)e.getSource();
            if(currentCell.isNeighborNullCell(noImageCell)){
                Image img = currentCell.getButtonImage();
                noImageCell.setButtonImage(img);
                noImageCell.requestFocus();
                noImageCell = currentCell;
                noImageCell.setButtonImage(null);
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if(puzzlePanel.isFinished()){
                cells[row -1][column-1].setButtonImage(lastCell.getButtonImage());
//                puzzlePanel.requestFocus();
                JOptionPane.showMessageDialog(null,"过关");
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
