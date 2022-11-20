import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class StatusBar extends JPanel {
    boolean statusBarIsTrue = false;
    //JLabel xlabel = new JLabel();

    StatusBar(JFrame frame) {
        setBorder(new BevelBorder(BevelBorder.LOWERED));
        setPreferredSize(new Dimension(frame.getWidth(), 16));
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        JLabel statusLabel = new JLabel("status");
        statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
        add(statusLabel);
        //add(xlabel);
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