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



class ToolBar extends JToolBar {
    JButton[] buttons = new JButton[12];

    ToolBar() {
        //icons excepted to line.png: www.flaticon.com
        //line.png: icons8.com

        ImageIcon icon0 = new ImageIcon("src/images/pointer.png");
        Image img0 = icon0.getImage();
        Image changeImg0 = img0.getScaledInstance(18,18,Image.SCALE_SMOOTH);
        ImageIcon changeIcon0 = new ImageIcon(changeImg0);

        ImageIcon icon1 = new ImageIcon("src/images/area.png");
        Image img1 = icon1.getImage();
        Image changeImg1 = img1.getScaledInstance(18,18,Image.SCALE_SMOOTH);
        ImageIcon changeIcon1 = new ImageIcon(changeImg1);

        ImageIcon icon2 = new ImageIcon("src/images/cut.png");
        Image img2 = icon2.getImage();
        Image changeImg2 = img2.getScaledInstance(18,18,Image.SCALE_SMOOTH);
        ImageIcon changeIcon2 = new ImageIcon(changeImg2);

        ImageIcon icon3 = new ImageIcon("src/images/paste.png");
        Image img3 = icon3.getImage();
        Image changeImg3 = img3.getScaledInstance(18,18,Image.SCALE_SMOOTH);
        ImageIcon changeIcon3 = new ImageIcon(changeImg3);

        ImageIcon icon4 = new ImageIcon("src/images/pen.png");
        Image img4 = icon4.getImage();
        Image changeImg4 = img4.getScaledInstance(18,18,Image.SCALE_SMOOTH);
        ImageIcon changeIcon4 = new ImageIcon(changeImg4);

        ImageIcon icon5 = new ImageIcon("src/images/line.png");
        Image img5 = icon5.getImage();
        Image changeImg5 = img5.getScaledInstance(18,18,Image.SCALE_SMOOTH);
        ImageIcon changeIcon5 = new ImageIcon(changeImg5);

        ImageIcon icon6 = new ImageIcon("src/images/triangle.png");
        Image img6 = icon6.getImage();
        Image changeImg6 = img6.getScaledInstance(18,18,Image.SCALE_SMOOTH);
        ImageIcon changeIcon6 = new ImageIcon(changeImg6);

        ImageIcon icon7 = new ImageIcon("src/images/square.png");
        Image img7 = icon7.getImage();
        Image changeImg7 = img7.getScaledInstance(18,18,Image.SCALE_SMOOTH);
        ImageIcon changeIcon7 = new ImageIcon(changeImg7);

        ImageIcon icon8 = new ImageIcon("src/images/text.png");
        Image img8 = icon8.getImage();
        Image changeImg8 = img8.getScaledInstance(18,18,Image.SCALE_SMOOTH);
        ImageIcon changeIcon8 = new ImageIcon(changeImg8);

        ImageIcon icon9 = new ImageIcon("src/images/fill.png");
        Image img9 = icon9.getImage();
        Image changeImg9 = img9.getScaledInstance(18,18,Image.SCALE_SMOOTH);
        ImageIcon changeIcon9 = new ImageIcon(changeImg9);

        ImageIcon icon10 = new ImageIcon("src/images/color.png");
        Image img10 = icon10.getImage();
        Image changeImg10 = img10.getScaledInstance(18,18,Image.SCALE_SMOOTH);
        ImageIcon changeIcon10 = new ImageIcon(changeImg10);

        ImageIcon icon11 = new ImageIcon("src/images/eraser.png");
        Image img11 = icon11.getImage();
        Image changeImg11 = img11.getScaledInstance(18,18,Image.SCALE_SMOOTH);
        ImageIcon changeIcon11 = new ImageIcon(changeImg11);

        setSize(500, 50);
        setLayout(new FlowLayout());
        buttons[0] = new JButton(changeIcon0);
        buttons[1] = new JButton(changeIcon1);
        buttons[2] = new JButton(changeIcon2);
        buttons[3] = new JButton(changeIcon3);
        buttons[4] = new JButton(changeIcon4);
        buttons[5] = new JButton(changeIcon5);
        buttons[6] = new JButton(changeIcon6);
        buttons[7] = new JButton(changeIcon7);
        buttons[8] = new JButton(changeIcon8);
        buttons[9] = new JButton(changeIcon9);
        buttons[10] = new JButton(changeIcon10);
        buttons[11] = new JButton(changeIcon11);

        SpinnerModel numberModel = new SpinnerNumberModel(1, 0, 99, 1);
        JSpinner thickSpinner = new JSpinner(numberModel);


        setBackground(Color.LIGHT_GRAY);

        for(int i = 0; i < 4; i++) {
            add(buttons[i]);
            buttons[i].setPreferredSize(new Dimension(30,30));
//            buttons[i].addActionListener(new ButtonAction());
        }
        addSeparator();

        for(int i = 4; i < 9; i++) {
            add(buttons[i]);
            buttons[i].setPreferredSize(new Dimension(30,30));
//            buttons[i].addActionListener(new ButtonAction());
        }
        addSeparator();

        for(int i = 9; i < buttons.length; i++) {
            add(buttons[i]);
            buttons[i].setPreferredSize(new Dimension(30,30));
//            buttons[i].addActionListener(new ButtonAction());
        }
        addSeparator();

        JLabel thickLabel = new JLabel("size");
        thickLabel.setPreferredSize(new Dimension(25,30));
        add(thickLabel);
        add(thickSpinner);
    }
}


public class MainTest{
    public static void main(String[] args) {
        MainFrame f = new MainFrame();

        // new PanelTest("패널 테스트");

    }
}


