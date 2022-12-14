import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.time.LocalDate;

public class StatusBar extends JPanel implements MouseMotionListener {
    boolean statusBarIsTrue = false;
//    JLabel xlabel = new JLabel();
    LocalDate now = LocalDate.now();

    int x;
    int y;

    StatusBar(JFrame frame) {
        setBorder(new BevelBorder(BevelBorder.LOWERED));
        setPreferredSize(new Dimension(frame.getWidth(), 16));
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        JLabel todayLabel = new JLabel("Today: "+String.valueOf(now) + "   ");
        todayLabel.setHorizontalAlignment(SwingConstants.LEFT);

        add(todayLabel);
//        xlabel.setHorizontalAlignment(SwingConstants.RIGHT);
//        add(xlabel);

    }

//    public void paintComponent(Graphics g) {
//        xlabel.setText("(X: " + canvas.X + " Y: " + canvas.Y + ")");
//    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();

        repaint();
    }

//    public void showPointer() { //현재 마우스 포인터 보여주는 설정, 버그 있음
//
//            PointerInfo pi = MouseInfo.getPointerInfo();
//            Point p = pi.getLocation();
//            xlabel.setText("x position = " + p.getX());
//            //if(statusBarIsTrue == false) break;
//
//    }

}