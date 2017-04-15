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

        JButton england = new JButton("England");
        buttons.add(england);
        Dimension size = england.getPreferredSize();
        england.setBounds(600 + insets.left, 200 + insets.top, size.width, size.height);
        
        JButton france = new JButton("France");
        buttons.add(france);
        france.setBounds(50 + insets.left, 50 + insets.top, size.width, size.height);

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