package model;

import java.awt.Image;

import javax.swing.ImageIcon;

public class FlagQuiz {
	
	private String answer;
	private String option1;
	private String option2;
	private String option3;
	
	private ImageIcon questionFlag;
	
	public FlagQuiz() {
		
		newQuiz();
	}
	
	public void newQuiz() {
		
		CountryList cl = new CountryList();
		
		answer = cl.getRandomCountry();
		
		questionFlag = new ImageIcon("src/resources/flags/"+answer+".png");
		
		questionFlag = scaleIcon(questionFlag, 0.75);
		
		do {
			option1 = cl.getRandomCountry();
			
		} while (option1.equals(answer));
		
		do {
			option2 = cl.getRandomCountry();
			
		} while (option2.equals(answer) || option2.equals(option1));
		
		do {
			option3 = cl.getRandomCountry();
			
		} while (option3.equals(answer) || option3.equals(option1) || option3.equals(option2));
	}
	
	public ImageIcon getQuestionFlag() {
		return questionFlag;
	}

	public String getCorrectAnswer() {
		return answer;
	}
	
	public String getOption1() {
		return option1;
	}
	
	public String getOption2() {
		return option2;
	}
	
	public String getOption3() {
		return option3;
	}
	
	private ImageIcon scaleIcon(ImageIcon icon, double scale) {
        int newWidth = (int) (icon.getIconWidth() * scale);
        int newHeight = (int) (icon.getIconHeight() * scale);

        Image image = icon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }
}
