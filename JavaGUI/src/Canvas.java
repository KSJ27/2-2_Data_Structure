import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

class Canvas extends JPanel {
    Dimension dim = new Dimension(1400,800);
    Memory memory = new Memory();
    static boolean selectCheck = true;
    int cutIndex = -1;
    Shape s1, s2;
    Shape checkShape;
    Line2D.Double line;
    Polygon triangle;
    Rectangle2D.Double rectangle;
    Rectangle2D.Double fillRect;

    Point start, end;

    public Canvas() {
        MyMouseListener listener = new MyMouseListener();

        addMouseListener(listener);
        addMouseMotionListener(listener);

        setPreferredSize(dim);
        setBackground(Color.white);

        setVisible(true);
    }

    class MyMouseListener extends MouseAdapter implements MouseListener  {
        public void mousePressed(MouseEvent event) {

            if(Buttons.mouseMode == true) {
                repaint();
            }

            if(Buttons.selectMode == true) { //선택 모드 선택 시
                if(memory.drawStack != null) { //선택한 영역을 표시해주는 네모 만든다
                    for(Shape s: memory.drawStack) {
                        if(s.contains(event.getX(), event.getY())) {
                            if(s instanceof Rectangle2D.Double && !memory.cutdrawStack.contains(s)) {
                                Rectangle2D.Double r = (Rectangle2D.Double) s;
                                s1 = new Rectangle2D.Double(r.x - 1 - memory.thicknessStack.peek(), r.y - 1 - memory.thicknessStack.peek(), 4,4);
                                cutIndex = memory.drawStack.indexOf(s);
                            }
                        }
                    }

                }
                repaint();
                if(Buttons.cutCheck == true && cutIndex >= 0 && memory.drawStack != null) { // 선택 모드에서 Cut하면 잘라내기
                    memory.cutdrawStack.push(memory.drawStack.remove(cutIndex));
                    memory.colorStack.remove(cutIndex);
                    memory.cutThicknessStack.push(memory.thicknessStack.remove(cutIndex));
                    Buttons.cutCheck = false;
                    cutIndex = -1;
                    Buttons.selectMode = false;
                    repaint();
                }
                if(Buttons.fillCheck == true ) {
                    for(Shape s: memory.drawStack) {
                        if(s.contains(event.getX(), event.getY())) {
                            if(s instanceof Rectangle2D.Double && !memory.cutdrawStack.contains(s)) {
                                Rectangle2D.Double r = (Rectangle2D.Double) s;
                                fillRect = new Rectangle2D.Double(((Rectangle2D.Double) s).x, ((Rectangle2D.Double) s).y,((Rectangle2D.Double) s).width, ((Rectangle2D.Double) s).height);
                                memory.drawStack.push(fillRect);
                                memory.colorStack.push(Color.black);
                                memory.thicknessStack.push(Stroke.thick);
                                repaint();
                            }
                        }
                    }
                }


            }
            if(Buttons.pasteCheck == true && !memory.cutdrawStack.isEmpty() ) {  // past
                memory.drawStack.push(memory.cutdrawStack.pop());
                memory.colorStack.push(Color.black);
                memory.thicknessStack.push(memory.cutThicknessStack.pop());
                repaint();
            }


            if(Buttons.draw == true) { //펜 그리기 모드 선택 시
                ColorFrame.colorChange = false;
                start = event.getPoint();
                memory.sketch.add(start);
                memory.next = memory.sketch.size()-1;
                memory.start.add(memory.sketch.size()-1);
            }

            if(Buttons.drawLine == true) { //선 그리기 모드 선택 시
                ColorFrame.colorChange = false;
                start = event.getPoint();
            }
            if(Buttons.drawTriangle == true) { //삼각형 그리기 모드 선택 시
                ColorFrame.colorChange = false;
                start = event.getPoint();
            }
            if(Buttons.drawRectangle == true) { //직사각형 그리기 모드 선택 시
                ColorFrame.colorChange = false;
                start = event.getPoint();
            }
            if(Buttons.eraser == true) { //지우개 모드 선택 시
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
//            if(Buttons.selectMode == true) { //선택 모드 선택 시
//                repaint();
//            }
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
                memory.penStack.push(null);
                memory.colorStack.push(Color.black);
                memory.thicknessStack.push(Stroke.thick);
                memory.end.add(memory.sketch.size()-1);
            }


            if (Buttons.drawLine == true) {
                memory.drawStack.push(line);
                memory.colorStack.push(Color.black);
                memory.thicknessStack.push(Stroke.thick);
            }

            if (Buttons.drawTriangle == true) {
                memory.drawStack.push(triangle);
                memory.colorStack.push(Color.black);
                memory.thicknessStack.push(Stroke.thick);
            }

            if(Buttons.drawRectangle == true) {
                memory.drawStack.push(rectangle);
                memory.colorStack.push(Color.black);
                memory.thicknessStack.push(Stroke.thick);
            }

            if(Buttons.eraser == true) {
                memory.penStack.push(null);
                memory.colorStack.push(Color.white);
                memory.thicknessStack.push(Stroke.thick);
                memory.end.add(memory.sketch.size()-1);
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        if(Buttons.fillCheck == true) {
            g2.fillRect((int) fillRect.x, (int) fillRect.y, (int) fillRect.width, (int) fillRect.height);
        }
        if(Buttons.selectMode == true && s1 != null) {
            g2.draw(s1);
        }
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
                    g2.fill( memory.drawStack.get(i));
                else
                    g2.draw( memory.drawStack.get(i));
            }

            g2.setColor(Color.black);
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
                if(Buttons.fillCheck == true) {
                    g2.setColor(ColorFrame.color);
                    g2.fill(rectangle);
                    Buttons.fillCheck = false;
                }

                if(Buttons.eraser == true) {
                    g2.setColor(Color.white);
                    for (int i = memory.next; i < memory.sketch.size() -1; i++)
                        g2.drawLine(memory.sketch.get(i).x, memory.sketch.get(i).y, memory.sketch.get(i+1).x, memory.sketch.get(i+1).y);
                }
            }
        }
    }
}