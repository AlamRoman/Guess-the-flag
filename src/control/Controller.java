package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Score;
import view.FlagQuizPanel;
import view.MenuPanel;
import view.MyFrame;

public class Controller implements ActionListener{

	private MyFrame frame;
	private MenuPanel menuPanel;
	private FlagQuizPanel flagQuizPanel;
	
	
	public Controller(MyFrame frame, MenuPanel menuPanel, FlagQuizPanel flagQuizPanel) {
		this.frame = frame;
		this.menuPanel = menuPanel;
		this.flagQuizPanel = flagQuizPanel;
		
		menuPanel.addListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//play flag quiz
		if (e.getActionCommand().equalsIgnoreCase("playFlagQuiz")) {
			
			frame.changeContentPane(flagQuizPanel);
		}
		
	}
	
}
