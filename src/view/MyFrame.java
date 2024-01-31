package view;

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
		
		ImageIcon icon = new ImageIcon("src/resources/icon.png");
		setIconImage(icon.getImage());
		
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
