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
    JPanel paragraphPanel = new JPanel();

    public AccentMap()
    {

        map.setBounds(0,0,1270,710);


        buttonPanel.setOpaque(false);
        buttonPanel.setBounds(0,0,1270,710);
        buttonPanel.setLayout(null);
        paragraphPanel.setOpaque(false);
        paragraphPanel.setBounds(100,100,1000,1000);
        paragraphPanel.setLayout(null);
        Insets insets = pane.getInsets();

        JButton england = new JButton();
        addButton("England", england, 618, 250);
        JButton france = new JButton();
        addButton("France", france, 630, 280);

        //more buttons

        pane.add(map, new Integer(1));
        pane.add(buttonPanel, new Integer(2));
        pane.add(paragraphPanel, new Integer(3));

        setLayeredPane(pane);

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
    
    /*public void drawParagraph(String accentname){
        paragraphPanel.setOpaque(true);
        ImageIcon paragraphImage = new ImageIcon(accentname + ".jpg");
        JLabel paragraph = new JLabel(paragraphImage);
    }*/

    public void addButton(String accentname, JButton accentName, int X, int Y){
        buttonPanel.add(accentName);
        Insets insets = pane.getInsets();
        accentName.setPreferredSize(new Dimension(10, 10));
        Dimension size = accentName.getPreferredSize();
        accentName.setBounds(X + insets.left, Y + insets.top, size.width, size.height);
        accentName.setOpaque(false);
        accentName.setContentAreaFilled(false);
        accentName.setBorderPainted(false);
        //accentName.setBackground(Color.RED);

        accentName.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    playSound(accentname + ".wav");
                    //drawParagraph(accentName);
                }
            });
            
        accentName.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    accentName.setOpaque(true);
                    accentName.setContentAreaFilled(true);
                    //accentName.setBackground(Color.RED);
                    accentName.setBorderPainted(true);
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    accentName.setOpaque(false);
                    accentName.setContentAreaFilled(false);
                    accentName.setBorderPainted(false);
                }
            });
    }

    public static void main(String [] args)
    {
        AccentMap frame = new AccentMap();
        frame.setSize(1270,710); 
        frame.setVisible(true); 
    }

}