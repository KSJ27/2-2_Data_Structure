import javax.swing.*;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class ColorFrame extends JFrame implements ChangeListener{
    JColorChooser colorChooser = new JColorChooser();

    ColorSelectionModel model = colorChooser.getSelectionModel();
    static Color color = Color.black;
    static boolean colorChange;

    ColorFrame() {
        setTitle("Color");
        setLocation(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        colorChooser.getSelectionModel().addChangeListener(this);

        add(colorChooser);

        pack();
        setVisible(true);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        color = colorChooser.getColor();
        colorChange = true;
    }
}