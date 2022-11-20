import javax.swing.*;
import java.awt.*;

public class Grid extends JFrame {
    boolean GridIsTrue = false;
    Graphics g;

    public Grid()    {
        setSize( 500, 500 );
    }

    public void setGrid(Graphics g) {
        for ( int x = 30; x <= 300; x += 30 )
            for ( int y = 30; y <= 300; y += 30 )
                g.drawRect( x, y, 30, 30 );

    }
}