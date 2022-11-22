import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

class Canvas extends JPanel {
    Dimension dim = new Dimension(500,450);

    MemoryStack stacks = new MemoryStack();

    DrawMode drawMode = new DrawMode();
    Line2D.Double line;
    Polygon triangle;
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
            if(Buttons.draw == true) {
                start = event.getPoint();
                drawMode.sketch.add(start);
                drawMode.next = drawMode.sketch.size()-1;
                drawMode.start.add(drawMode.sketch.size()-1);
            }
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
            if (Buttons.draw == true) {
                end = event.getPoint();
                drawMode.sketch.add(end);
                repaint();
            }
            if (Buttons.drawLine == true) {
                end = event.getPoint();
                line = new Line2D.Double(start.x, start.y, end.x, end.y);
                repaint();
            }
            if (Buttons.drawTriangle == true) {
                end = event.getPoint();
                int x[] = {start.x, start.x + (end.x - start.x)/2, end.x};
                int y[] = {end.y, start.y, end.y};
                triangle = new Polygon(x, y, 3);
                repaint();
            }
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
                //setcanvas.end.add(setcanvas.sketch.size()-1);
            }

            if (Buttons.drawTriangle == true) {
                stacks.drawStack.push(null);
//                memory.colorMemory.push(ColorFrame.color);
//                memory.thicknessMemory.push(Stroke.thick);
                //setcanvas.end.add(setcanvas.sketch.size()-1);
            }

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

        if(Buttons.draw == true) {
            for (int i = drawMode.next; i < drawMode.sketch.size() -1; i++)
                g2.drawLine(drawMode.sketch.get(i).x, drawMode.sketch.get(i).y, drawMode.sketch.get(i+1).x, drawMode.sketch.get(i+1).y);
        }
        if(Buttons.drawLine == true)
            g2.draw(line);
        if(Buttons.drawTriangle == true)
            g2.draw(triangle);
        if(Buttons.drawRectangle == true)
            g2.draw(rectangle);
    }
}