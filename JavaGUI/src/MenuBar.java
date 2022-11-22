import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MenuBar extends JMenuBar implements ActionListener, MouseListener {


    JLabel openImage = new JLabel();
    Grid grid = new Grid();
    Graphics g;

    JLabel imageLabel = new JLabel();
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

        JFileChooser chooser = new JFileChooser();

        JMenuItem click = (JMenuItem) event.getSource();

        if(click == NewFileMenu) { //Todo
            FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG Images", "jpg");
            fileChooser.setFileFilter(filter);
            //BufferedImage image = new BufferedImage()//canvas 부분만 저장하는 걸 구현해야해서 canvas부터 만들어야함!!
        }

        if(click.equals(OpenFileMenu)){
            // TODO Auto-generated method stub
            FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png");
            chooser.setFileFilter(filter);
            int ret = chooser.showOpenDialog(null);
            if(ret!= JFileChooser.APPROVE_OPTION){
                JOptionPane.showConfirmDialog(null, "파일을 선택하지 않았습니다.",
                        "경고",JOptionPane.WARNING_MESSAGE);
                return;
            }
            String filePath = chooser.getSelectedFile().getPath();
            imageLabel.setIcon(new ImageIcon(filePath));
        }


        if(click.equals(SaveAsFileMenu)) {
            // TODO Auto-generated method stub
            FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG Images", "png");
            chooser.setFileFilter(filter);
            int ret = chooser.showSaveDialog(null);
            if (ret == JFileChooser.APPROVE_OPTION) {
                String filePath = chooser.getSelectedFile().getPath()+".png";
                File saveFile = new File(filePath);
                System.out.println(saveFile);
                BufferedImage newImage = new BufferedImage(imageLabel.getIcon().getIconWidth(), imageLabel.getIcon().getIconHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics g = newImage.getGraphics();
                imageLabel.getIcon().paintIcon(null, g, 0, 0);
                g.dispose();
                try {
                    ImageIO.write(newImage, "png", saveFile);
                }
                catch (IOException ex) {
                }
            }
        }

        if(click.equals(ExitMenu)) {
            System.exit(0);
        }

        if(click.equals(UndoMenu)) {

        }

        if(click.equals(RedoMenu)) {

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