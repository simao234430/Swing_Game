import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URI;
import javax.imageio.ImageIO;
/**
 * Created by simao on 2018/6/5.
 */
public class GameWindow extends JFrame{
    public JPanel getImagePanel() {
        return imagePanel;
    }

    public void setImagePanel(JPanel imagePanel) {
        this.imagePanel = imagePanel;
    }

    private JPanel imagePanel;
    //    private static final long ser
    JPanel messagePanel;
    JMenuBar bar;
    JMenu menuGame,menuHelp;
    JMenu menuImage;
    JMenuItem qqImage, flowerImage, catImage, loadOtherImage;
    ControlGamePanel controlPanel;
//
    private File gradeFile;
    private BufferedImage image;
    private PuzzlePanel puzzlePanel;
    private int row=3,column=3;
    private JLabel playerName,userStep;
    private JMenuItem oneGradeItem,twoGradeItem;
    private JMenuItem musicItem;
    private JMenu menuResult;
    private JMenuItem oneGradeResult,twoGradeResult;
    private JMenuItem exitItem;
    private JMenuItem gameDescription;


    public GameWindow(){
        setTitle("拼图小游戏");
        //setSize(400,300);
        setLayout(new BorderLayout());
        creatMenu();
        setJMenuBar(bar);

        //加载默认图片
        try{
            URI uri = GameWindow.class.getClassLoader().getResource("image/qq.jpg").toURI();
            File file = new File(uri);
            image = ImageIO.read(file);
        }catch (Exception e){
            e.printStackTrace();

        }

        controlPanel = new ControlGamePanel(this);
        controlPanel.setBackground(Color.blue);
        creatMessagePanel();
        puzzlePanel = new PuzzlePanel(this);
        puzzlePanel.initPanel();
//        puzzlePanel.setBackground(Color.green);
        imagePanel = new JPanel();
//        imagePanel.setBackground(Color.CYAN);
        imagePanel.setBorder(new EtchedBorder());
        imagePanel.setPreferredSize(new Dimension(240,120));
        add(controlPanel,BorderLayout.SOUTH);
        add(messagePanel,BorderLayout.NORTH);
        add(puzzlePanel,BorderLayout.CENTER);
        add(imagePanel,BorderLayout.EAST);



        //setSize(new Dimension(400,200));
        setSize(new Dimension(Cell.WIDTH * column + 240,Cell.HEIGHT*row + 100));
        setVisible(true);
        setResizable(true);
        validate();
    }

    private void creatMessagePanel(){
        messagePanel = new JPanel();
        playerName = new JLabel("你完成走过的步数");
        messagePanel.add(playerName);
        playerName.setBackground(Color.yellow);
    }


    private void creatMenu(){
        bar = new JMenuBar();
        menuGame = new JMenu("游戏");
        menuHelp = new JMenu("帮助");
        bar.add(menuGame);
        bar.add(menuHelp);
        menuImage = new JMenu("选择图像");
        this.qqImage = new JRadioButtonMenuItem("QQ图片",true);
        this.flowerImage = new JRadioButtonMenuItem("花图片");
        this.catImage = new JRadioButtonMenuItem("猫图片");
        this.loadOtherImage = new JRadioButtonMenuItem("从本地选择图片");
        ButtonGroup group1 = new ButtonGroup();
        group1.add(qqImage);
        group1.add(flowerImage);
        group1.add(catImage);
        group1.add(loadOtherImage);

        menuImage.add(qqImage);
        menuImage.add(flowerImage);
        menuImage.add(catImage);
        menuImage.add(loadOtherImage);

        oneGradeItem = new JRadioButtonMenuItem("普通级别3x3", true);
        twoGradeItem = new JRadioButtonMenuItem("高级级别4x4", false);
        ButtonGroup group2 = new ButtonGroup();
        group2.add(oneGradeItem);
        group2.add(twoGradeItem);

        musicItem = new JMenuItem("背景音乐播放控制");

        menuResult = new JMenu("查看排行榜");
        this.oneGradeResult = new JMenuItem("普通级别排行");
        this.twoGradeResult = new JMenuItem("高级级别排行");
        menuResult.add(oneGradeResult);
        menuResult.add(twoGradeResult);

        exitItem = new JMenuItem("退出");



        menuGame.add(menuImage);
        menuGame.addSeparator();
        menuGame.add(oneGradeItem);
        menuGame.add(twoGradeItem);
        menuGame.addSeparator();
        menuGame.add(musicItem);
        menuGame.addSeparator();
        menuGame.add(menuResult);
        menuGame.addSeparator();
        menuGame.add(exitItem);

        gameDescription = new JMenuItem("游戏说明");
        menuHelp.add(gameDescription);


    }

    public File getGradeFile() {
        return gradeFile;
    }

    public void setGradeFile(File gradeFile) {
        this.gradeFile = gradeFile;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public PuzzlePanel getPuzzlePanel() {
        return puzzlePanel;
    }

    public void setPuzzlePanel(PuzzlePanel puzzlePanel) {
        this.puzzlePanel = puzzlePanel;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public JLabel getPlayerName() {
        return playerName;
    }

    public void setPlayerName(JLabel playerName) {
        this.playerName = playerName;
    }

    public JLabel getUserStep() {
        return userStep;
    }

    public void setUserStep(JLabel userStep) {
        this.userStep = userStep;
    }



    public static void main(String[] args){

        new GameWindow();
    }
}
