import java.awt.*;
import java.util.Stack;
import java.util.Vector;

public class Memory {
    static int next;

    //네모 세모 선 개체들의 스택
    static Stack<Shape> drawStack = new Stack<>();
    static Stack<Color> colorStack = new Stack<>();
    static Stack<Integer> thicknessStack = new Stack<>();

    static Stack<Object> penStack = new Stack<>();

    //그린 개체들의 redo를 위한 스택
    static Stack<Shape> redoStack = new Stack<>();
    static Stack<Color> redoColorStack = new Stack<>();
    static Stack<Integer> redoThicknessStack = new Stack<>();

    //draw 모드와 eraser 모드 위한 스택
    static Vector<Point> sketch = new Vector<>();
    static Stack<Integer> start = new Stack<>();
    static Stack<Integer> end = new Stack<>();

    //draw 모드와 eraser 모드 위한 redo 스택
    static Stack<Integer> redoStart = new Stack<>();
    static Stack<Integer> redoEnd = new Stack<>();

    static Stack<Shape> cutdrawStack = new Stack<>();
    static Stack<Integer> cutThicknessStack = new Stack<>();

}