import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

class Canvas extends JPanel {
    Dimension dim = new Dimension(500,450);

    SetCanvas setcanvas = new SetCanvas();
    MemoryStack stacks = new MemoryStack();

    Line2D.Double line;
    Rectangle2D.Double rectangle;

    Point start, end;


    public Canvas() {
        MyMouseListener listener = new MyMouseListener();

        addMouseListener(listener);
        addMouseMotionListener(listener);

        setPreferredSize(dim);
        setBackground(Color.WHITE);

        setVisible(true);
    }

    class MyMouseListener extends MouseAdapter {
        public void mousePressed(MouseEvent event) {
            if(Buttons.drawLine == true) {
                start = event.getPoint();
            }
            if(Buttons.drawTriangle == true) {
                start = event.getPoint();
            }
            if(Buttons.drawRectangle == true) {
                start = event.getPoint();
            }
        }

        public void mouseDragged(MouseEvent event) {
            if (Buttons.drawLine == true) {
                end = event.getPoint();
                line = new Line2D.Double(start.x, start.y, end.x, end.y);
                repaint();
            }
//            if (Buttons.drawTriangle == true) {
//                end = event.getPoint();
//                triangle = new Polygon();
//                repaint();
//            }
            if (Buttons.drawRectangle == true) {
                end = event.getPoint();
                rectangle = new Rectangle2D.Double(Math.min(start.x, end.x), Math.min(start.y, end.y), Math.abs(start.x - end.x), Math.abs(start.y - end.y));
                repaint();
            }
        }

        public void mouseReleased(MouseEvent event) {
            if (Buttons.drawLine == true) {
                stacks.drawStack.push(null);
//                memory.colorMemory.push(ColorFrame.color);
//                memory.thicknessMemory.push(Stroke.thick);
                setcanvas.end.add(setcanvas.sketch.size()-1);
            }

//            if (Buttons.drawTriangle == true) {
//                memory.memory.push(line);
//                memory.colorMemory.push(ColorFrame.color);
//                memory.thicknessMemory.push(Stroke.thick);
//            }

            if(Buttons.drawRectangle == true) {
                stacks.drawStack.push(rectangle);
//                memory.colorMemory.push(ColorFrame.color);
//                memory.thicknessMemory.push(Stroke.thick);
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        if(Buttons.drawLine == true)
            g2.draw(line);
        if(Buttons.drawRectangle == true)
            g2.draw(rectangle);
    }
}