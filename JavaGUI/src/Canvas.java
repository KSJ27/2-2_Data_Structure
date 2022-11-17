import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

class Canvas extends JPanel {
    Dimension dim = new Dimension(500,450);

    SetCanvas setcanvas = new SetCanvas();
    //workStack stack = new workStack();

    Line2D.Double line;
    Rectangle2D.Double rectangle;


    public Canvas() {
        MyMouseListener listener = new MyMouseListener();

        addMouseListener(listener);
        addMouseMotionListener(listener);

        setPreferredSize(dim);
        setBackground(Color.WHITE);

        setVisible(true);
    }

    class MyMouseListener extends MouseAdapter {

    }
}