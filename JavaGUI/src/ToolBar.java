import javax.swing.*;
import java.awt.*;

class ToolBar extends JToolBar {
    Buttons buttons = new Buttons();
    SpinnerModel numberModel = new SpinnerNumberModel(1, 0, 99, 1);
    JSpinner thickSpinner = new JSpinner(numberModel);

    ToolBar() {
        setBackground(Color.LIGHT_GRAY);

        for (int i = 0; i < 4; i++) {
            add(buttons.toolBarButtons[i]);
            buttons.toolBarButtons[i].setPreferredSize(new Dimension(30, 30));
//            buttons[i].addActionListener(new ButtonAction());
        }
        addSeparator();

        for (int i = 4; i < 9; i++) {
            add(buttons.toolBarButtons[i]);
            buttons.toolBarButtons[i].setPreferredSize(new Dimension(30, 30));
//            buttons[i].addActionListener(new ButtonAction());
        }
        addSeparator();

        for (int i = 9; i < buttons.toolBarButtons.length; i++) {
            add(buttons.toolBarButtons[i]);
            buttons.toolBarButtons[i].setPreferredSize(new Dimension(30, 30));
//            buttons[i].addActionListener(new ButtonAction());
        }
        addSeparator();

        JLabel thickLabel = new JLabel("size");
        thickLabel.setPreferredSize(new Dimension(25, 30));
        add(thickLabel);
        add(thickSpinner);
    }
}