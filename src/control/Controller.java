package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Score;
import view.FlagQuizPanel;
import view.HardcorePanel;
import view.MenuPanel;
import view.MyFrame;

public class Controller implements ActionListener{

	private MyFrame frame;
	private MenuPanel menuPanel;
	private FlagQuizPanel flagQuizPanel;
	private HardcorePanel hardcorePanel;
	
	
	public Controller(MyFrame frame, MenuPanel menuPanel, FlagQuizPanel flagQuizPanel, HardcorePanel hardcorePanel) {
		this.frame = frame;
		this.menuPanel = menuPanel;
		this.flagQuizPanel = flagQuizPanel;
		this.hardcorePanel = hardcorePanel;
		
		menuPanel.addListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//play flag quiz
		if (e.getActionCommand().equalsIgnoreCase("playFlagQuiz")) {
			
			frame.changeContentPane(flagQuizPanel);
			
		}else if (e.getActionCommand().equalsIgnoreCase("playHardcore")) {
			
			frame.changeContentPane(hardcorePanel);
		}
		
	}
	
}
