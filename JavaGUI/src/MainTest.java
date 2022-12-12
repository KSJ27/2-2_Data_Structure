import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MainFrame extends JFrame implements ActionListener {
    MenuBar menubar = new MenuBar();
    ToolBar toolBar = new ToolBar();
    Canvas canvas = new Canvas();
    StatusBar statusBar = new StatusBar(this);


    public MainFrame() {
        setSize(1400,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Draw Board");
        menubar.StatusMenu.addActionListener(this);
        statusBar.setVisible(false);
        setJMenuBar(menubar);
        add(toolBar, BorderLayout.NORTH);
        add(canvas);
        add(statusBar, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object click = e.getSource();

        if(click.equals(toolBar.buttons.toolBarButtons[12])) {
            this.toolBar.buttons.Undo();
            canvas.repaint();
        }
        if(click.equals(toolBar.buttons.toolBarButtons[13])) {
            this.toolBar.buttons.Redo();
            canvas.repaint();
        }
        if(click.equals(menubar.ClearMenu)) {
            canvas.repaint();
        }
        if(click.equals(menubar.StatusMenu) && statusBar.statusBarIsTrue == true) {
            statusBar.setVisible(false);
            statusBar.statusBarIsTrue = false;
        }
        else if(click.equals(menubar.StatusMenu) && statusBar.statusBarIsTrue == false) {
            statusBar.setVisible(true);
            statusBar.statusBarIsTrue = true;
        }

    }
}


public class MainTest{
    public static void main(String[] args) {
        MainFrame f = new MainFrame();
        //f.setVisible(true);
        // new PanelTest("패널 테스트");

    }
}


