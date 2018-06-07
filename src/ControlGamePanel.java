import javax.swing.*;

/**
 * Created by simao on 2018/6/5.
 */
public class ControlGamePanel extends JPanel {
    JButton buttonStart,buttonPreview,buttonSave,buttonDraw,buttonExit;
    int row,column;

    public ControlGamePanel(){

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

    }


}
