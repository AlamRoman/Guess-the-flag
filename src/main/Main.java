package main;

import control.Controller;
import view.FlagQuizPanel;
import view.MenuPanel;
import view.MyFrame;

public class Main {
	
	public static void main(String[] args) {
		
		FlagQuizPanel flagQuizPanel = new FlagQuizPanel();
		MenuPanel menuPanel = new MenuPanel();
		
		MyFrame frame = new MyFrame(menuPanel);
		
		Controller controller = new Controller(frame, menuPanel, flagQuizPanel);
	}
	
}
