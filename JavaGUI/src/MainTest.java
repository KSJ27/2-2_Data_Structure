import javax.swing.*;
import java.awt.*;

class MainFrame extends JFrame{
    MenuBar menubar = new MenuBar();
    ToolBar toolBar = new ToolBar();
    Canvas canvas = new Canvas();

    public MainFrame() {
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Draw Board");
        setJMenuBar(menubar);
        add(toolBar, BorderLayout.NORTH);
        add(canvas);

        setVisible(true);
    }


}


public class MainTest{
    public static void main(String[] args) {
        MainFrame f = new MainFrame();

        // new PanelTest("패널 테스트");

    }
}


