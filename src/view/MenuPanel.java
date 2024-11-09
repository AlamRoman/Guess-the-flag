package view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;

import control.Controller;
import model.ImageLoader;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class MenuPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JButton btnFlagQuiz;
	private JButton btnHardcoreMode;
	private Image bgImage;

	public MenuPanel() {
		setSize(700, 500);
		setLayout(null);
		
		ImageLoader imageLoader = new ImageLoader();
		
		bgImage = imageLoader.getImageFrom("resources/world-map.jpg").getImage();
		
		btnFlagQuiz = new JButton("Flag Quiz");
		btnFlagQuiz.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnFlagQuiz.setBounds(237, 152, 213, 46);
		btnFlagQuiz.setActionCommand("playFlagQuiz");
		btnFlagQuiz.setFocusable(false);
		add(btnFlagQuiz);
		
		JLabel lblTitle = new JLabel("GUESS THE FLAG");
		lblTitle.setFont(new Font("Arial Black", Font.BOLD, 50));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(91, 8, 518, 109);
		add(lblTitle);
		
		JLabel lblTitle2 = new JLabel("GUESS THE FLAG");
		lblTitle2.setFont(new Font("Arial Black", Font.BOLD, 50));
		lblTitle2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle2.setBounds(93, 10, 518, 109);
		lblTitle2.setForeground(Color.WHITE);
		add(lblTitle2);
		
		btnHardcoreMode = new JButton("Hardcore Mode");
		btnHardcoreMode.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnHardcoreMode.setActionCommand("playHardcore");
		btnHardcoreMode.setBounds(237, 219, 213, 46);
		btnHardcoreMode.setFocusable(false);
		btnHardcoreMode.setOpaque(true);
		add(btnHardcoreMode);
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
		// Draw the image with the size of the panel
        g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);
    }
	
	public void addListener(Controller controller) {
		btnFlagQuiz.addActionListener(controller);
		btnHardcoreMode.addActionListener(controller);
	}
}
