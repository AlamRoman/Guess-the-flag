package model;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CountryList {

	private ArrayList<String> countries;
	
	public CountryList() {
		
		countries = new ArrayList<String>();
		
		try {
			
			List<String> countryNames = Files.readAllLines(Paths.get("src/resources/countries.txt"));
			
			countries = (ArrayList<String>) countryNames;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public String getRandomCountry() {
		
		Random random = new Random();
		
		int index = random.nextInt(countries.size() - 1);
		
		return countries.get(index);
	}
}
