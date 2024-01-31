package model;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.ImageIcon;

public class FlagQuiz {
	
	private String answer;
	private String option1;
	private String option2;
	private String option3;
	
	private ImageIcon questionFlag;
	
	private CountryList countryList;
	
	public FlagQuiz() {
		
		countryList = new CountryList();
		
		newQuiz();
	}
	
	public void newQuiz() {
		
		answer = countryList.getRandomCountry();
		
		 try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("resources/flags/" + answer + ".png")) {
            if (inputStream != null) {
                
                questionFlag = new ImageIcon(javax.imageio.ImageIO.read(inputStream));
            } else {
                System.out.println("Error : flag image for country " + answer + " not found");
            }
        } catch (IOException e) {
            System.out.println("Error loading image: " + e.getMessage());
        }
		 
		 
		
		questionFlag = scaleIcon(questionFlag, 0.75);
		
		do {
			option1 = countryList.getRandomCountry();
			
		} while (option1.equals(answer));
		
		do {
			option2 = countryList.getRandomCountry();
			
		} while (option2.equals(answer) || option2.equals(option1));
		
		do {
			option3 = countryList.getRandomCountry();
			
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
