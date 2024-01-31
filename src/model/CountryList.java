package model;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CountryList {

	private ArrayList<String> countries;
	
	public CountryList() {
		
		countries = new ArrayList<String>();
		
		try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("resources/countries.txt");
	             Scanner scanner = new Scanner(inputStream)) {

	            while (scanner.hasNextLine()) {
	                countries.add(scanner.nextLine());
	            }

	        } catch (Exception e) {
	            System.out.println("Error reading countries.txt: " + e.getMessage());
	        }
		
	}
	
	
	public String getRandomCountry() {
		
		Random random = new Random();
		
		int index = random.nextInt(countries.size() - 1);
		
		return countries.get(index);
	}
}
