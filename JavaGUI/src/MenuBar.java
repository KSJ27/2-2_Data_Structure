import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuBar extends JMenuBar implements ActionListener, MouseListener {
    Grid grid = new Grid();
    Graphics g;

    JLabel openImage = new JLabel();
    JFileChooser fileChooser = new JFileChooser();

    JMenu FileMenu = new JMenu("File");
    JMenuItem NewFileMenu = new JMenuItem("New");
    JMenuItem OpenFileMenu = new JMenuItem("Open");
    JMenuItem SaveFileMenu = new JMenuItem("Save");
    JMenuItem SaveAsFileMenu = new JMenuItem("Save As");
    JMenuItem ExitMenu = new JMenuItem("Exit");

    JMenu ViewMenu = new JMenu("View");
    JMenuItem GridMenu = new JMenuItem("Grid");
    JMenuItem StatusMenu = new JMenuItem("Status Bar");
    JMenuItem ClearMenu = new JMenuItem("Clear");

    JMenu UndoMenu = new JMenu("Undo");
    JMenu RedoMenu = new JMenu("Redo");

    MenuBar() {
        NewFileMenu.addActionListener(this);
        OpenFileMenu.addActionListener(this);
        SaveFileMenu.addActionListener(this);
        SaveAsFileMenu.addActionListener(this);
        ExitMenu.addActionListener(this);

        add(FileMenu);
        FileMenu.add(NewFileMenu);
        FileMenu.add(OpenFileMenu);
        FileMenu.add(SaveFileMenu);
        FileMenu.add(SaveAsFileMenu);
        FileMenu.add(ExitMenu);

        GridMenu.addActionListener(this);
        StatusMenu.addActionListener(this);
        ClearMenu.addActionListener(this);

        add(ViewMenu);
        ViewMenu.add(GridMenu);
        ViewMenu.add(StatusMenu);
        ViewMenu.add(ClearMenu);

        UndoMenu.addActionListener(this);
        RedoMenu.addActionListener(this);

        add(UndoMenu);
        add(RedoMenu);
    }

    public void actionPerformed(ActionEvent event) {

        JMenuItem click = (JMenuItem) event.getSource();

        if(click == NewFileMenu) {
            FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG Images", "jpg");
            fileChooser.setFileFilter(filter);
            //BufferedImage image = new BufferedImage()//canvas 부분만 저장하는 걸 구현해야해서 canvas부터 만들어야함!!
        }




    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}