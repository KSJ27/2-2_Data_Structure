import java.awt.*;
import java.util.Stack;
import java.util.Vector;

public class SetCanvas {
    static Vector<Point> sketch = new Vector<Point>();
    static Stack<Integer> start = new Stack<Integer>();
    static Stack<Integer> end = new Stack<Integer>();

    static Stack<Integer> redoStart = new Stack<Integer>();
    static Stack<Integer> redoEnd = new Stack<Integer>();

    int next;
}