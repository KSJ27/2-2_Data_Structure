import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

class Canvas extends JPanel {
    Dimension dim = new Dimension(1400,800);
    Memory memory = new Memory();

    Line2D.Double line;
    Polygon triangle;
    Rectangle2D.Double rectangle;

    Point start, end;

    public Canvas() {
        MyMouseListener listener = new MyMouseListener();

        addMouseListener(listener);
        addMouseMotionListener(listener);

        setPreferredSize(dim);
        setBackground(Color.white);

        setVisible(true);
    }

    class MyMouseListener extends MouseAdapter {
        public void mousePressed(MouseEvent event) {
            if(Buttons.draw == true) { //펜 그리기 모드 선택
                ColorFrame.colorChange = false;
                start = event.getPoint();
                memory.sketch.add(start);
                memory.next = memory.sketch.size()-1;
                memory.start.add(memory.sketch.size()-1);
            }
            if(Buttons.drawLine == true) { //선 그리기 모드 선택
                ColorFrame.colorChange = false;
                start = event.getPoint();
//                memory.next = memory.sketch.size()-1;
//                memory.start.add(memory.sketch.size()-1);
            }
            if(Buttons.drawTriangle == true) { //삼각형 그리기 모드 선택
                ColorFrame.colorChange = false;
                start = event.getPoint();
//                memory.next = memory.sketch.size()-1;
//                memory.start.add(memory.sketch.size()-1);
            }
            if(Buttons.drawRectangle == true) { //직사각형 그리기 모드 선택
                ColorFrame.colorChange = false;
                start = event.getPoint();
//                memory.next = memory.sketch.size()-1;
//                memory.start.add(memory.sketch.size()-1);
            }
            if(Buttons.eraser == true) { //지우개 모드 선택
                ColorFrame.colorChange = false;
                start = event.getPoint();
                memory.sketch.add(start);
                memory.next = memory.sketch.size()-1;
                memory.start.add(memory.sketch.size()-1);
            }
        }

        public void mouseDragged(MouseEvent event) {
            if (Buttons.draw == true) {
                end = event.getPoint();
                memory.sketch.add(end);
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
            if (Buttons.eraser == true) {
                end = event.getPoint();
                memory.sketch.add(end);
                repaint();
            }
        }

        public void mouseReleased(MouseEvent event) {
            if (Buttons.draw == true) {
                memory.drawStack.push(null);
                memory.colorStack.push(ColorFrame.color);
                memory.thicknessStack.push(Stroke.thick);
                memory.end.add(memory.sketch.size()-1);
            }

            if (Buttons.drawLine == true) {
                memory.drawStack.push(line);
                memory.colorStack.push(ColorFrame.color);
                memory.thicknessStack.push(Stroke.thick);
//                memory.end.add(memory.sketch.size()-1);
            }

            if (Buttons.drawTriangle == true) {
                memory.drawStack.push(triangle);
                memory.colorStack.push(ColorFrame.color);
                memory.thicknessStack.push(Stroke.thick);
//                memory.end.add(memory.sketch.size()-1);
            }

            if(Buttons.drawRectangle == true) {
                memory.drawStack.push(rectangle);
                memory.colorStack.push(ColorFrame.color);
                memory.thicknessStack.push(Stroke.thick);
//                memory.end.add(memory.sketch.size()-1);
            }

            if(Buttons.eraser == true) {
                memory.drawStack.push(null);
                memory.colorStack.push(Color.white);
                memory.thicknessStack.push(Stroke.thick);
                memory.end.add(memory.sketch.size()-1);
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        if(MenuBar.clearCheck == true) {
            WhiteBoard clearShape = new WhiteBoard();

            g2.setColor(Color.white);
            g2.setStroke(new BasicStroke(0));
            g2.draw(clearShape);
            memory.drawStack.push(clearShape);
            memory.colorStack.push(Color.white);
            memory.thicknessStack.push(0);
            g2.fill(clearShape);
            MenuBar.clearCheck = false;

        }
        else {
            int sketchNum = 0;

            for(int i = 0; i < memory.drawStack.size(); i++) {
                g2.setColor(memory.colorStack.get(i));
                g2.setStroke(new BasicStroke(memory.thicknessStack.get(i)));

                if(memory.drawStack.get(i)  == null) {
                    for (int j = memory.start.get(sketchNum); j < memory.end.get(sketchNum)-1; j++)
                        g2.drawLine(memory.sketch.get(j).x, memory.sketch.get(j).y, memory.sketch.get(j+1).x, memory.sketch.get(j+1).y);

                    sketchNum++;
                }
                else if(memory.drawStack.get(i).getClass().getSimpleName().equals("WhiteBoard"))
                    g2.fill((Shape) memory.drawStack.get(i));
                else
                    g2.draw((Shape) memory.drawStack.get(i));
            }

            g2.setColor(ColorFrame.color);
            g2.setStroke(new BasicStroke(Stroke.thick));

            if(start == null)
                return;

            if(ColorFrame.colorChange == true) ;
            else {
                if(Buttons.draw == true) {
                    for (int i = memory.next; i < memory.sketch.size() -1; i++)
                        g2.drawLine(memory.sketch.get(i).x, memory.sketch.get(i).y, memory.sketch.get(i+1).x, memory.sketch.get(i+1).y);
                }
                if(Buttons.drawLine == true)
                    g2.draw(line);
                if(Buttons.drawTriangle == true)
                    g2.draw(triangle);
                if(Buttons.drawRectangle == true)
                    g2.draw(rectangle);

                if(Buttons.eraser == true) {
                    g2.setColor(Color.white);
                    for (int i = memory.next; i < memory.sketch.size() -1; i++)
                        g2.drawLine(memory.sketch.get(i).x, memory.sketch.get(i).y, memory.sketch.get(i+1).x, memory.sketch.get(i+1).y);
                }
            }
        }
    }
}