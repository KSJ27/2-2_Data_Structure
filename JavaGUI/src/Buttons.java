import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Buttons implements MouseListener {
    static JButton[] toolBarButtons = new JButton[15];
    Stroke stroke = new Stroke();
//    static CanvasGroup canvas = new CanvasGroup();

    static boolean mouseMode;
    static boolean draw;
    static boolean drawLine;
    static boolean drawTriangle;
    static boolean drawRectangle;
    static boolean eraser;

    Buttons() {
        //icons excepted to line.png: www.flaticon.com
        //line.png: icons8.com

        ImageIcon icon0 = new ImageIcon("src/images/pointer.png");
        Image img0 = icon0.getImage();
        Image changeImg0 = img0.getScaledInstance(18, 18, Image.SCALE_SMOOTH);
        ImageIcon changeIcon0 = new ImageIcon(changeImg0);

        ImageIcon icon1 = new ImageIcon("src/images/area.png");
        Image img1 = icon1.getImage();
        Image changeImg1 = img1.getScaledInstance(18, 18, Image.SCALE_SMOOTH);
        ImageIcon changeIcon1 = new ImageIcon(changeImg1);

        ImageIcon icon2 = new ImageIcon("src/images/cut.png");
        Image img2 = icon2.getImage();
        Image changeImg2 = img2.getScaledInstance(18, 18, Image.SCALE_SMOOTH);
        ImageIcon changeIcon2 = new ImageIcon(changeImg2);

        ImageIcon icon3 = new ImageIcon("src/images/paste.png");
        Image img3 = icon3.getImage();
        Image changeImg3 = img3.getScaledInstance(18, 18, Image.SCALE_SMOOTH);
        ImageIcon changeIcon3 = new ImageIcon(changeImg3);

        ImageIcon icon4 = new ImageIcon("src/images/pen.png");
        Image img4 = icon4.getImage();
        Image changeImg4 = img4.getScaledInstance(18, 18, Image.SCALE_SMOOTH);
        ImageIcon changeIcon4 = new ImageIcon(changeImg4);

        ImageIcon icon5 = new ImageIcon("src/images/line.png");
        Image img5 = icon5.getImage();
        Image changeImg5 = img5.getScaledInstance(18, 18, Image.SCALE_SMOOTH);
        ImageIcon changeIcon5 = new ImageIcon(changeImg5);

        ImageIcon icon6 = new ImageIcon("src/images/triangle.png");
        Image img6 = icon6.getImage();
        Image changeImg6 = img6.getScaledInstance(18, 18, Image.SCALE_SMOOTH);
        ImageIcon changeIcon6 = new ImageIcon(changeImg6);

        ImageIcon icon7 = new ImageIcon("src/images/square.png");
        Image img7 = icon7.getImage();
        Image changeImg7 = img7.getScaledInstance(18, 18, Image.SCALE_SMOOTH);
        ImageIcon changeIcon7 = new ImageIcon(changeImg7);

        ImageIcon icon8 = new ImageIcon("src/images/text.png");
        Image img8 = icon8.getImage();
        Image changeImg8 = img8.getScaledInstance(18, 18, Image.SCALE_SMOOTH);
        ImageIcon changeIcon8 = new ImageIcon(changeImg8);

        ImageIcon icon9 = new ImageIcon("src/images/fill.png");
        Image img9 = icon9.getImage();
        Image changeImg9 = img9.getScaledInstance(18, 18, Image.SCALE_SMOOTH);
        ImageIcon changeIcon9 = new ImageIcon(changeImg9);

        ImageIcon icon10 = new ImageIcon("src/images/color.png");
        Image img10 = icon10.getImage();
        Image changeImg10 = img10.getScaledInstance(18, 18, Image.SCALE_SMOOTH);
        ImageIcon changeIcon10 = new ImageIcon(changeImg10);

        ImageIcon icon11 = new ImageIcon("src/images/eraser.png");
        Image img11 = icon11.getImage();
        Image changeImg11 = img11.getScaledInstance(18, 18, Image.SCALE_SMOOTH);
        ImageIcon changeIcon11 = new ImageIcon(changeImg11);

//        ImageIcon icon12 = new ImageIcon("src/images/undo.png");
//        Image img12 = icon12.getImage();
//        Image changeImg12 = img12.getScaledInstance(18, 18, Image.SCALE_SMOOTH);
//        ImageIcon changeIcon12 = new ImageIcon(changeImg12);
//
//        ImageIcon icon13 = new ImageIcon("src/images/redo.png");
//        Image img13 = icon13.getImage();
//        Image changeImg13 = img13.getScaledInstance(18, 18, Image.SCALE_SMOOTH);
//        ImageIcon changeIcon13 = new ImageIcon(changeImg13);


        toolBarButtons[0] = new JButton(changeIcon0);
        toolBarButtons[1] = new JButton(changeIcon1);
        toolBarButtons[2] = new JButton(changeIcon2);
        toolBarButtons[3] = new JButton(changeIcon3);
        toolBarButtons[4] = new JButton(changeIcon4);
        toolBarButtons[5] = new JButton(changeIcon5);
        toolBarButtons[6] = new JButton(changeIcon6);
        toolBarButtons[7] = new JButton(changeIcon7);
        toolBarButtons[8] = new JButton(changeIcon8);
        toolBarButtons[9] = new JButton(changeIcon9);
        toolBarButtons[10] = new JButton(changeIcon10);
        toolBarButtons[11] = new JButton(changeIcon11);
        toolBarButtons[12] = new JButton("undo");
        toolBarButtons[13] = new JButton("redo");
        toolBarButtons[14] = new JButton("Clear");

        toolBarButtons[12].setBackground(Color.lightGray);
        toolBarButtons[13].setBackground(Color.lightGray);
        toolBarButtons[14].setBackground(new Color(240,240,240));

        for(int i = 0; i < toolBarButtons.length; i++) {
            toolBarButtons[i].setBorderPainted(false);
        }

        for(int i = 0; i < 12; i++) {
            toolBarButtons[i].addMouseListener(this);
        }

        toolBarButtons[14].addMouseListener(this);

    }
    @Override
    public void mouseClicked(MouseEvent e) {
        JButton button = (JButton)e.getSource();

        if (button == toolBarButtons[0]) setMouseMode();
//        if (button == toolBarButtons[1]) setSelectMode();
//        if (button == toolBarButtons[2]) copy();
//        if (button == toolBarButtons[3]) paste();
        if (button == toolBarButtons[4]) setDraw();
        if (button == toolBarButtons[5]) setDrawLine();
        if (button == toolBarButtons[6]) setDrawTriangle();
        if (button == toolBarButtons[7]) setDrawRectangle();
//        if (button == toolBarButtons[9]) setFill(button);
        if (button == toolBarButtons[10]) {
            ColorFrame colorFrame = new ColorFrame();
        }
        if (button == toolBarButtons[11]) setEraser();
//        if (button == toolBarButtons[12]) Undo();
//        if (button == toolBarButtons[13]) Redo();
//        if (button == toolBarButtons[14]) Clear();
    }

    private void setMouseMode() {
        draw = false;
        drawLine = false;
        drawTriangle = false;
        drawRectangle = false;
        eraser = false;

        toolBarButtons[4].setBorderPainted(false);
        toolBarButtons[5].setBorderPainted(false);
        toolBarButtons[6].setBorderPainted(false);
        toolBarButtons[7].setBorderPainted(false);
        toolBarButtons[11].setBorderPainted(false);
    }

    private void setDraw() {
        draw = true;
        drawLine = false;
        drawTriangle = false;
        drawRectangle = false;
        eraser = false;

        toolBarButtons[4].setBorderPainted(true);
        toolBarButtons[5].setBorderPainted(false);
        toolBarButtons[6].setBorderPainted(false);
        toolBarButtons[7].setBorderPainted(false);
        toolBarButtons[11].setBorderPainted(false);
    }

    private void setDrawLine() {
        draw = false;
        drawLine = true;
        drawTriangle = false;
        drawRectangle = false;
        eraser = false;

        toolBarButtons[4].setBorderPainted(false);
        toolBarButtons[5].setBorderPainted(true);
        toolBarButtons[6].setBorderPainted(false);
        toolBarButtons[7].setBorderPainted(false);
        toolBarButtons[11].setBorderPainted(false);
    }

    private void setDrawTriangle() {
        draw = false;
        drawLine = false;
        drawTriangle = true;
        drawRectangle = false;
        eraser = false;

        toolBarButtons[4].setBorderPainted(false);
        toolBarButtons[5].setBorderPainted(false);
        toolBarButtons[6].setBorderPainted(true);
        toolBarButtons[7].setBorderPainted(false);
        toolBarButtons[11].setBorderPainted(false);
    }

    private void setDrawRectangle() {
        draw = false;
        drawLine = false;
        drawTriangle = false;
        drawRectangle = true;
        eraser = false;

        toolBarButtons[4].setBorderPainted(false);
        toolBarButtons[5].setBorderPainted(false);
        toolBarButtons[6].setBorderPainted(false);
        toolBarButtons[7].setBorderPainted(true);
        toolBarButtons[11].setBorderPainted(false);
    }

    private void setEraser() {
        draw = false;
        drawLine = false;
        drawTriangle = false;
        drawRectangle = false;
        eraser = true;

        toolBarButtons[4].setBorderPainted(false);
        toolBarButtons[5].setBorderPainted(false);
        toolBarButtons[6].setBorderPainted(false);
        toolBarButtons[7].setBorderPainted(false);
        toolBarButtons[11].setBorderPainted(true);
    }

    public void Undo() {

        ColorFrame.colorChange = false;

        if(Memory.drawStack.isEmpty() == true)
            ;
        else {
            if(Memory.drawStack.peek() == null) {
                Memory.redoStart.push(Memory.start.pop());
                Memory.redoEnd.push(Memory.end.pop());
            }

            Memory.redoStack.push(Memory.drawStack.pop());
            Memory.redoColorStack.push(Memory.colorStack.pop());
            Memory.redoThicknessStack.push(Memory.thicknessStack.pop());

        }
    }

    public void Redo() {
        ColorFrame.colorChange = true;

        if(Memory.redoStack.isEmpty() == true) ;
        else {
            if (Memory.redoStack.peek() == null) {
                Memory.start.push(Memory.redoStart.pop());
                Memory.end.push(Memory.redoEnd.pop());
            }

            Memory.drawStack.push(Memory.redoStack.pop());
            Memory.colorStack.push(Memory.redoColorStack.pop());
            Memory.thicknessStack.push(Memory.redoThicknessStack.pop());

        }

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