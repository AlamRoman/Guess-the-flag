package main;

import control.Controller;
import control.FlagQuizPanelController;
import control.HardcoreController;
import model.CountryList;
import model.FlagQuiz;
import view.FlagQuizPanel;
import view.HardcorePanel;
import view.MenuPanel;
import view.MyFrame;

public class Main {
	
	public static void main(String[] args) {
		
		CountryList countryList = new CountryList();
		FlagQuiz flagQuiz = new FlagQuiz();
	
		//panels
		FlagQuizPanel flagQuizPanel = new FlagQuizPanel();
		MenuPanel menuPanel = new MenuPanel();
		HardcorePanel hardcorePanel = new HardcorePanel();
		
		MyFrame frame = new MyFrame(menuPanel);
		
		//controllers
		Controller controller = new Controller(frame, menuPanel, flagQuizPanel, hardcorePanel);
		FlagQuizPanelController fc = new FlagQuizPanelController(frame, menuPanel, flagQuizPanel);
		HardcoreController hc = new HardcoreController(frame, menuPanel, hardcorePanel);
	}
	
}
