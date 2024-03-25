package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Score;
import view.FlagQuizPanel;
import view.MenuPanel;
import view.MyFrame;

public class FlagQuizPanelController implements ActionListener{
	
	private MyFrame frame;
	private MenuPanel menuPanel;
	private FlagQuizPanel flagQuizPanel;
	
	private Score score;
	
	public FlagQuizPanelController(MyFrame frame, MenuPanel menuPanel, FlagQuizPanel flagQuizPanel){
		this.frame = frame;
		this.menuPanel = menuPanel;
		this.flagQuizPanel = flagQuizPanel;
		
		flagQuizPanel.addListener(this);
		
		score = Score.getInstance();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//go back button
		if (e.getActionCommand().equalsIgnoreCase("goBack")) {
			
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
