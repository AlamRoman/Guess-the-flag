package view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;

import control.Controller;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class MenuPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JButton btnFlagQuiz;
	private JButton btnHardcoreMode;

	public MenuPanel() {
		setSize(700, 500);
		setLayout(null);
		
		btnFlagQuiz = new JButton("Flag Quiz");
		btnFlagQuiz.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnFlagQuiz.setBounds(237, 152, 213, 46);
		btnFlagQuiz.setActionCommand("playFlagQuiz");
		add(btnFlagQuiz);
		
		JLabel lblTitle = new JLabel("GUESS THE FLAG");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(166, 8, 372, 109);
		add(lblTitle);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(8, 96, 684, 23);
		add(separator);
		
		btnHardcoreMode = new JButton("Hardcore Mode");
		btnHardcoreMode.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnHardcoreMode.setActionCommand("playHardcore");
		btnHardcoreMode.setBounds(237, 219, 213, 46);
		add(btnHardcoreMode);
	}
	
	public void addListener(Controller controller) {
		btnFlagQuiz.addActionListener(controller);
		btnHardcoreMode.addActionListener(controller);
	}
}
