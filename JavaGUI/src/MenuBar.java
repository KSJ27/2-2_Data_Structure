import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MenuBar extends JMenuBar implements ActionListener, MouseListener {
    static boolean clearCheck = false;
    static CanvasGroup canvas = new CanvasGroup();
    Buttons buttons = new Buttons();

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
    JButton ClearMenu = buttons.toolBarButtons[14];

    JButton UndoMenu = buttons.toolBarButtons[12];
    JButton RedoMenu = buttons.toolBarButtons[13];

    MenuBar() {
        setBackground(Color.lightGray);

        NewFileMenu.addActionListener(this);
        NewFileMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));

        OpenFileMenu.addActionListener(this);
        OpenFileMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));

        SaveFileMenu.addActionListener(this);
        SaveFileMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));

        SaveAsFileMenu.addActionListener(this);
        ExitMenu.addActionListener(this);
        ExitMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

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

//        UndoMenu.add(buttons.toolBarButtons[12]);
//        RedoMenu.add(buttons.toolBarButtons[13]);

        UndoMenu.addActionListener(this);
        RedoMenu.addActionListener(this);

        add(UndoMenu);
        add(RedoMenu);
    }

    public void actionPerformed(ActionEvent event) {

        JFileChooser chooser = new JFileChooser();

        Object click = event.getSource();

        if(click == NewFileMenu) { //Todo
            // FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG Images", "jpg");
            //fileChooser.setFileFilter(filter);
            //BufferedImage image = new BufferedImage()//canvas 부분만 저장하는 걸 구현해야해서 canvas부터 만들어야함!!
            JFileChooser save = new JFileChooser();
            int option = save.showSaveDialog(this);
            //  String message = "Do u want to save this file ?";

            //  int reply = JOptionPane.showConfirmDialog(null, message, "New File",.OPTION);

            if (option == JFileChooser.APPROVE_OPTION) {
                try{
                    BufferedWriter out = new BufferedWriter(new FileWriter(save.getSelectedFile().getPath()));
                    out.close();
                }
                catch(Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
            else {
                MenuBar.clearCheck = true;
            }

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

        if(click.equals(ClearMenu)) {
            clearCheck = true;
        }

        if(click.equals(UndoMenu)) {
            buttons.Undo();
        }

        if(click.equals(RedoMenu)) {
            buttons.Redo();
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