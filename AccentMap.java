import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class AccentMap extends JFrame
{
    ImageIcon mapImage = new ImageIcon("/Users/Jivankhakee/Desktop/World Accents/map.jpg");
    JDesktopPane pane = new JDesktopPane();
    JLabel map = new JLabel(mapImage);
    JPanel buttons = new JPanel();

    public AccentMap()
    {

        map.setBounds(0,0,1270,710); 

        buttons.setOpaque(false);
        buttons.setBounds(0,0,1270,710);
        buttons.setLayout(null);
        Insets insets = pane.getInsets();

        /*size.width = size.height = Math.max(size.width, size.height);
        setPreferredSize(size);
        setContentAreaFilled(false);*/
        

        JButton england = new JButton("");
        buttons.add(england);
        england.setPreferredSize(new Dimension(10, 10));
        Dimension size = england.getPreferredSize();
        england.setBounds(618 + insets.left, 250 + insets.top, size.width, size.height);

        JButton france = new JButton("");
        buttons.add(france);
        france.setBounds(630 + insets.left, 280 + insets.top, size.width, size.height);

        pane.add(map, new Integer(1));
        pane.add(buttons, new Integer(2));

        setLayeredPane(pane);
    }

    public static void main(String [] args)
    {
        AccentMap frame = new AccentMap();
        frame.setSize(1270,710); 
        frame.setVisible(true); 
    }

}