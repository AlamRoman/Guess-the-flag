package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import model.Score;
import view.HardcorePanel;
import view.MenuPanel;
import view.MyFrame;

public class HardcoreController implements ActionListener, MouseListener{

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
				
				//if already guessed wrong, don't increment score
				if (!hardcorePanel.isGuessedWrong()) {
					score.increaseCorrectAnswer();
				}
				
				hardcorePanel.newQuiz();
				
			}else if(hardcorePanel.isGuessedWrong() == false){
				
				score.increaseWrongAnswer();
				hardcorePanel.setGuessedWrong(true);
				
				hardcorePanel.decrementHeart();
				hardcorePanel.showHearts();
				
				if (hardcorePanel.getnHeart() <= 0) {
					
					String message = "<html><div style='text-align: center;'><font size='+1'><b>Game Over</b></font><br><br>";
					message += "Score: " + score.getCorrectAnswer() + "<br>";
					message += "Highest score: 0" + "<br><br><hr>";
					message += "Do you want to play again?</div></html>";
					
					int choice = JOptionPane.showConfirmDialog(hardcorePanel, message, "Game Over", JOptionPane.YES_NO_OPTION);
					
					//new game
					hardcorePanel.resetGame();
					score.reset();
					hardcorePanel.newQuiz();
					
					//go back
					if (choice == JOptionPane.NO_OPTION) {
						frame.changeContentPane(menuPanel);
					}
				}
			}
			
			hardcorePanel.updateScore(score);
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
		hardcorePanel.btnBackMouseEntered();
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		hardcorePanel.btnBackMouseExited();
		
	}
	
	
}
