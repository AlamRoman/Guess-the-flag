package main;

import control.Controller;
import model.CountryList;
import model.FlagQuiz;
import view.FlagQuizPanel;
import view.MenuPanel;
import view.MyFrame;

public class Main {
	
	public static void main(String[] args) {
		
		CountryList countryList = new CountryList();
		FlagQuiz flagQuiz = new FlagQuiz();
	
		FlagQuizPanel flagQuizPanel = new FlagQuizPanel();
		MenuPanel menuPanel = new MenuPanel();
		
		MyFrame frame = new MyFrame(menuPanel);
		
		Controller controller = new Controller(frame, menuPanel, flagQuizPanel);
	}
	
}
