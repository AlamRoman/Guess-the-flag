package view;

import javax.swing.JPanel;

import model.FlagQuiz;
import model.ImageLoader;
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
	
	protected JButton btnBack;
	
	protected JButton btnOption1;
	protected JButton btnOption2;
	protected JButton btnOption3;
	protected JButton btnOption4;
	
	protected JLabel lblTitle;
	
	private Boolean guessedWrong;
	
	protected JLabel lblCorrectAnswer;
	protected JLabel lblWrongAnswer;
	
	private ImageIcon goBackIcon;
	
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
		
		lblTitle = new JLabel("Flag Quiz");
		lblTitle.setVerticalAlignment(SwingConstants.TOP);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setBounds(227, 25, 230, 47);
		add(lblTitle);
		
		//go back button
		btnBack = new JButton("");
		btnBack.setBounds(31, 20, 110, 38);
		btnBack.setActionCommand("goBack");
		//make the button transparent
		btnBack.setOpaque(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		btnBack.setFocusPainted(false);
		//set the button image
		ImageLoader imageLoader = new ImageLoader();
		goBackIcon = imageLoader.getImageFrom("resources/backButton.png");
		btnBack.setIcon(imageLoader.scaleImage(goBackIcon, 0.027));
		add(btnBack);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(8, 331, 684, 30);
		add(separator);
		
		//options
		
		btnOption1 = new JButton("New button");
		btnOption1.setBounds(87, 356, 241, 47);
		btnOption1.setFocusable(false);
		add(btnOption1);
		
		btnOption2 = new JButton("New button");
		btnOption2.setBounds(387, 356, 241, 47);
		btnOption2.setFocusable(false);
		add(btnOption2);
		
		btnOption3 = new JButton("New button");
		btnOption3.setBounds(87, 421, 241, 47);
		btnOption3.setFocusable(false);
		add(btnOption3);
		
		btnOption4 = new JButton("New button");
		btnOption4.setBounds(387, 421, 241, 47);
		btnOption4.setFocusable(false);
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
		btnBack.addMouseListener(controller);
		
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
		
		//set action commands to the buttons
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
	
	public void btnBackMouseEntered() {
		btnBack.setIcon(ImageLoader.scaleImage(goBackIcon, 0.029));
	}
	
	public void btnBackMouseExited() {
		btnBack.setIcon(ImageLoader.scaleImage(goBackIcon, 0.027));
	}
}
