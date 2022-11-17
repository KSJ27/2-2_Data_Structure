import java.awt.*;
import java.util.Stack;

public class MemoryStack {
    static Stack<Object> drawStack = new Stack<Object>();
    static Stack<Color> colorStack = new Stack<Color>();
    static Stack<Integer> thicknessStack = new Stack<Integer>();

    static Stack<Object> redoStack = new Stack<Object>();
    static Stack<Color> redoColorStack = new Stack<Color>();
    static Stack<Integer> redoThicknessStack = new Stack<Integer>();
}