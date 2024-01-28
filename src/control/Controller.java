package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Score;
import view.FlagQuizPanel;
import view.MenuPanel;
import view.MyFrame;

public class Controller implements ActionListener{

	private MyFrame frame;
	
	private FlagQuizPanel flagQuizPanel;
	private MenuPanel menuPanel;
	
	private Score score;
	
	public Controller(MyFrame frame, MenuPanel menuPanel, FlagQuizPanel flagQuizPanel) {
		this.frame = frame;
		this.menuPanel = menuPanel;
		this.flagQuizPanel = flagQuizPanel;
		
		menuPanel.addListener(this);
		flagQuizPanel.addListener(this);
		
		score = Score.getInstance();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equalsIgnoreCase("playFlagQuiz")) {
			
			frame.changeContentPane(flagQuizPanel);
		}else if (e.getActionCommand().equalsIgnoreCase("goBack")) {
			
			frame.changeContentPane(menuPanel);
		}
		
		//check answer
		if (e.getActionCommand().equalsIgnoreCase("option 1") ||
					e.getActionCommand().equalsIgnoreCase("option 2") ||
					e.getActionCommand().equalsIgnoreCase("option 3") ||
					e.getActionCommand().equalsIgnoreCase("option 4")
				) {
			
			if (flagQuizPanel.checkAnswer(e.getActionCommand())) {
				
				score.increaseCorrectAnswer();
				
				flagQuizPanel.newQuiz();
			}else if(flagQuizPanel.isGuessedWrong() == false){
				
				score.increaseWrongAnswer();
				flagQuizPanel.setGuessedWrong(true);
			}
			
			flagQuizPanel.updateScore(score);
		}
		
	}
	
}
