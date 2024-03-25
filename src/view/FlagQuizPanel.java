package view;

import javax.swing.JPanel;

import model.FlagQuiz;
import model.Score;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import control.Controller;
import control.FlagQuizPanelController;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class FlagQuizPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private FlagQuiz flagQuiz;
	
	private JLabel lblFlagImage;
	
	private JButton btnBack;
	
	private JButton btnOption1;
	private JButton btnOption2;
	private JButton btnOption3;
	private JButton btnOption4;
	
	private Boolean guessedWrong;
	
	private JLabel lblCorrectAnswer;
	private JLabel lblWrongAnswer;
	
	public FlagQuizPanel() {
		setBackground(new Color(208, 255, 255));
		setSize(700, 500);
		setLayout(null);
		
		//flag
		
		lblFlagImage = new JLabel("");
		lblFlagImage.setBackground(new Color(255, 0, 0));
		lblFlagImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblFlagImage.setBounds(190, 81, 330, 214);
		
		add(lblFlagImage);
		
		JLabel lblTitle = new JLabel("Flag Quiz");
		lblTitle.setVerticalAlignment(SwingConstants.TOP);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setBounds(227, 25, 230, 47);
		add(lblTitle);
		
		btnBack = new JButton("Go Back");
		btnBack.setBounds(31, 25, 103, 25);
		btnBack.setActionCommand("goBack");
		add(btnBack);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(8, 331, 684, 30);
		add(separator);
		
		//options
		
		btnOption1 = new JButton("New button");
		btnOption1.setBounds(87, 356, 241, 47);
		add(btnOption1);
		
		btnOption2 = new JButton("New button");
		btnOption2.setBounds(387, 356, 241, 47);
		add(btnOption2);
		
		btnOption3 = new JButton("New button");
		btnOption3.setBounds(87, 421, 241, 47);
		add(btnOption3);
		
		btnOption4 = new JButton("New button");
		btnOption4.setBounds(387, 421, 241, 47);
		add(btnOption4);
		
		JLabel lblScore = new JLabel("Score");
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setBounds(605, 35, 40, 11);
		add(lblScore);
		
		lblCorrectAnswer = new JLabel("0");
		lblCorrectAnswer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCorrectAnswer.setBackground(new Color(255, 255, 255));
		lblCorrectAnswer.setForeground(new Color(0, 128, 0));
		lblCorrectAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorrectAnswer.setBounds(588, 61, 40, 11);
		add(lblCorrectAnswer);
		
		lblWrongAnswer = new JLabel("0");
		lblWrongAnswer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblWrongAnswer.setForeground(new Color(255, 0, 0));
		lblWrongAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		lblWrongAnswer.setBounds(628, 61, 40, 11);
		add(lblWrongAnswer);
		
		//create new quiz
		newQuiz();
	}
	
	public void addListener(FlagQuizPanelController controller) {
		
		btnBack.addActionListener(controller);
		
		btnOption1.addActionListener(controller);
		btnOption2.addActionListener(controller);
		btnOption3.addActionListener(controller);
		btnOption4.addActionListener(controller);
	}
	
	public void newQuiz() {
		
		flagQuiz = new FlagQuiz();
		
		guessedWrong = false;
		
		//set flag image
		lblFlagImage.setIcon(flagQuiz.getQuestionFlag());
		
		//set random options to the buttons
		ArrayList<String> options = new ArrayList<String>();
		options.add(flagQuiz.getCorrectAnswer());
		options.add(flagQuiz.getOption1());
		options.add(flagQuiz.getOption2());
		options.add(flagQuiz.getOption3());
		
		Collections.shuffle(options);
		
		btnOption1.setText(options.get(0));
		btnOption2.setText(options.get(1));
		btnOption3.setText(options.get(2));
		btnOption4.setText(options.get(3));
		
		//set action commads to the buttons
		btnOption1.setActionCommand("option 1");
		btnOption2.setActionCommand("option 2");
		btnOption3.setActionCommand("option 3");
		btnOption4.setActionCommand("option 4");
		
		//reset background color
		btnOption1.setBackground(Color.white);
		btnOption2.setBackground(Color.white);
		btnOption3.setBackground(Color.white);
		btnOption4.setBackground(Color.white);
 		
	}
	
	private ImageIcon scaleIcon(ImageIcon icon, double scale) {
        int newWidth = (int) (icon.getIconWidth() * scale);
        int newHeight = (int) (icon.getIconHeight() * scale);

        Image image = icon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }
	
	public void update() {
		revalidate();
		repaint();
	}
	
	public boolean checkAnswer(String guess) {
		
		JButton guessedCountryBtn= new JButton();
		
		switch (guess) {
		case "option 1":
			guessedCountryBtn = btnOption1;
			break;
			
		case "option 2":
			guessedCountryBtn = btnOption2;
			break;
			
		case "option 3":
			guessedCountryBtn = btnOption3;
			break;
			
		case "option 4":
			guessedCountryBtn = btnOption4;
			break;
		}
		
		if (guessedCountryBtn.getText().equalsIgnoreCase(flagQuiz.getCorrectAnswer())) {			
			return true;
		}else {
			guessedCountryBtn.setBackground(new Color(252, 54, 40));
			return false;
		}
	}

	public Boolean isGuessedWrong() {
		return guessedWrong;
	}

	public void setGuessedWrong(Boolean guessedWrong) {
		this.guessedWrong = guessedWrong;
	}
	
	public void updateScore(Score score) {
		lblCorrectAnswer.setText(score.getCorrectAnswer()+"");
		lblWrongAnswer.setText(score.getWrongAnswer()+"");
	}
}
