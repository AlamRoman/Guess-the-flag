package view;

import java.io.IOException;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MyFrame(JPanel panel) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(720, 520);
		setLocationRelativeTo(null);
		
		ImageIcon icon;
		
		try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("resources/icon.png")) {
            if (inputStream != null) {
                
                icon = new ImageIcon(javax.imageio.ImageIO.read(inputStream));
                setIconImage(icon.getImage());
                
            } else {
                System.out.println("Error : icon image not found");
            }
        } catch (IOException e) {
            System.out.println("Error loading image: " + e.getMessage());
        }
		
		contentPane = panel;

		setContentPane(contentPane);
		setVisible(true);
	}
	
	public void changeContentPane(JPanel panel) {
		remove(contentPane);
		
		setContentPane(panel);
		
		contentPane = panel;
		
		update();
	}

	public JPanel getContentPane() {
		return contentPane;
	}
	
	public void update() {
		revalidate();
		repaint();
	}

}
