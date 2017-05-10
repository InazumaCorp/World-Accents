import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

class AccentMap extends JFrame {
	//ImageIcon mapImage = new ImageIcon("/Users/Jivankhakee/Desktop/World Accents/map.jpg");
	ImageIcon mapImage = new ImageIcon(this.getClass().getResource("map.jpg"));
	JDesktopPane pane = new JDesktopPane();
	JLabel map = new JLabel(mapImage);
	JPanel buttonPanel = new JPanel();
	JPanel paragraphPanel = new JPanel();

	public AccentMap() {
		map.setBounds(0, 0, 1270, 710);
		buttonPanel.setOpaque(false);
		buttonPanel.setBounds(0, 0, 1270, 710);
		buttonPanel.setLayout(null);
		paragraphPanel.setOpaque(false);
		paragraphPanel.setBounds(100, 100, 1000, 500);
		paragraphPanel.setLayout(null);
		Insets insets = pane.getInsets();

		JButton lithuania = new JButton();
		addButton("Lithuania", lithuania, 700, 238, 3500);
		JButton georgia = new JButton();
		addButton("Georgia", georgia, 325, 345, 3700);
		JButton denmark = new JButton();
		addButton("Denmark", denmark, 652, 238, 2500);
		JButton bahamas = new JButton();
		addButton("Bahamas", bahamas, 348, 370, 2200);
		JButton AustraliaQueensland = new JButton();
		addButton("AustraliaQueensland", AustraliaQueensland, 1160, 550, 3000);

		// more buttons
		pane.add(map, new Integer(1));
		pane.add(buttonPanel, new Integer(2));
		pane.add(paragraphPanel, new Integer(3));

		setLayeredPane(pane);

	}

	public void playSound(String soundName) {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
			;
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}

	/*public void drawParagraph(String accentname) {
		try {
			ImageIcon paragraphImage = new ImageIcon(accentname + ".jpg");
			JLabel label = new JLabel(paragraphImage);
			paragraphPanel.add(label);

		} catch (Exception ex) {
			System.out.println("Error with Paragraph");
			ex.printStackTrace();
		}

	}*/

	public void addButton(String accentname, JButton accentName, int X, int Y, int audioLength) {
		buttonPanel.add(accentName);
		Insets insets = pane.getInsets();
		accentName.setPreferredSize(new Dimension(18, 18));
		Dimension size = accentName.getPreferredSize();
		accentName.setBounds(X + insets.left, Y + insets.top, size.width, size.height);
		accentName.setOpaque(false);
		accentName.setContentAreaFilled(false);
		accentName.setBorderPainted(false);
		accentName.setMultiClickThreshhold(audioLength);

		accentName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playSound(accentname + ".wav");
				//drawParagraph(accentname);
			}
		});

		accentName.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				try {
					ImageIcon buttonImage = new ImageIcon("/Users/Jivankhakee/Desktop/World Accents/button.jpg");
					accentName.setIcon(buttonImage);
				} catch (Exception ex) {
					System.out.println(ex);
				}
				accentName.setOpaque(true);
				accentName.setContentAreaFilled(true);
				accentName.setBorderPainted(true);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				try {
					accentName.setIcon(null);
				} catch (Exception ex) {
					System.out.println(ex);
				}
				accentName.setOpaque(false);
				accentName.setContentAreaFilled(false);
				accentName.setBorderPainted(false);
			}
		});
	}

	public static void main(String[] args) {
		AccentMap window = new AccentMap();
		window.setSize(1270, 729);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
