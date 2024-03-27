package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.Score;
import view.FlagQuizPanel;
import view.MenuPanel;
import view.MyFrame;

public class FlagQuizPanelController implements ActionListener, MouseListener {
	
	private MyFrame frame;
	private MenuPanel menuPanel;
	private FlagQuizPanel flagQuizPanel;
	
	private Score score;
	
	public FlagQuizPanelController(MyFrame frame, MenuPanel menuPanel, FlagQuizPanel flagQuizPanel){
		this.frame = frame;
		this.menuPanel = menuPanel;
		this.flagQuizPanel = flagQuizPanel;
		
		flagQuizPanel.addListener(this);
		
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
			
			if (flagQuizPanel.checkAnswer(e.getActionCommand())) {
				
				//if already guessed wrong, don't increment score
				if (!flagQuizPanel.isGuessedWrong()) {
					score.increaseCorrectAnswer();
				}
				
				flagQuizPanel.newQuiz();
				
			}else if(flagQuizPanel.isGuessedWrong() == false){
				
				score.increaseWrongAnswer();
				flagQuizPanel.setGuessedWrong(true);
			}
			
			flagQuizPanel.updateScore(score);
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		flagQuizPanel.btnBackMouseEntered();
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		flagQuizPanel.btnBackMouseExited();
	}
}
