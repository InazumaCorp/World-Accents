import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class AccentMap extends JFrame
{
    ImageIcon mapImage = new ImageIcon("/Users/Jivankhakee/Desktop/World Accents/map.jpg");
    JDesktopPane pane = new JDesktopPane();
    JLabel map = new JLabel(mapImage);
    JPanel buttonPanel = new JPanel();

    public AccentMap()
    {

        map.setBounds(0,0,1270,710); 

        buttonPanel.setOpaque(false);
        buttonPanel.setBounds(0,0,1270,710);
        buttonPanel.setLayout(null);
        Insets insets = pane.getInsets();
        
        JButton england = new JButton();
        addButton(england, 618, 250);
        JButton france = new JButton();
        addButton(france, 630, 280);

        //more buttons

        pane.add(map, new Integer(1));
        pane.add(buttonPanel, new Integer(2));

        setLayeredPane(pane);

        england.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e)
                {
                    playSound("England.wav");
                }
            });

    }

    public void playSound(String soundName){
        try 
        {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());;
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        }
        catch(Exception ex)
        {
            System.out.println("Error with playing sound.");
            ex.printStackTrace( );
        }
    }
    
    public void addButton(JButton accentName, int X, int Y){
        buttonPanel.add(accentName);
        Insets insets = pane.getInsets();
        accentName.setPreferredSize(new Dimension(10, 10));
        Dimension size = accentName.getPreferredSize();
        accentName.setBounds(X + insets.left, Y + insets.top, size.width, size.height);
    }
   
    public static void main(String [] args)
    {
        AccentMap frame = new AccentMap();
        frame.setSize(1270,710); 
        frame.setVisible(true); 
    }

}