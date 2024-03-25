package view;

import control.HardcoreController;

public class HardcorePanel extends FlagQuizPanel{

	public HardcorePanel() {
		super();
	}
	
	public void addListener(HardcoreController controller) {
		
		btnBack.addActionListener(controller);
		
		btnOption1.addActionListener(controller);
		btnOption2.addActionListener(controller);
		btnOption3.addActionListener(controller);
		btnOption4.addActionListener(controller);
	}
}
