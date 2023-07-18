package Selenium;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class new123 {
	
	public List<String[]> readData() throws IOException { 
		
		String score = "12";
		int finalScore = Integer.parseInt(score);
		
	    int count = 0;
	    String file = "bank-Detail.txt";
	    List<String[]> content = new ArrayList<>();
	    try(BufferedReader br = new BufferedReader(new FileReader(file))) {
	        String line = "";
	        while ((line = br.readLine()) != null) {
	            content.add(line.split(","));
	        }
	    } catch (FileNotFoundException e) {
	      //Some error logging
	    }
	    return content;
	}
			
	}
		
	


