package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Score;
import view.HardcorePanel;
import view.MenuPanel;
import view.MyFrame;

public class HardcoreController implements ActionListener{

	private MyFrame frame;
	private MenuPanel menuPanel;
	private HardcorePanel hardcorePanel;
	
	private Score score;
	
	public HardcoreController(MyFrame frame, MenuPanel menuPanel, HardcorePanel hardcorePanel) {
		this.frame = frame;
		this.menuPanel = menuPanel;
		this.hardcorePanel = hardcorePanel;
		
		hardcorePanel.addListener(this);
		
		score = new Score();
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
			
			if (hardcorePanel.checkAnswer(e.getActionCommand())) {
				
				score.increaseCorrectAnswer();
				
				hardcorePanel.newQuiz();
			}else if(hardcorePanel.isGuessedWrong() == false){
				
				score.increaseWrongAnswer();
				hardcorePanel.setGuessedWrong(true);
			}
			
			hardcorePanel.updateScore(score);
		}
		
	}
	
	
}
