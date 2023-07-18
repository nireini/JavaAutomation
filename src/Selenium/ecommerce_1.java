package Selenium;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ecommerce_1 {

	public static void main(String[] args) 
	{
		
		String sqlFileRoute = "";
		
	    try (Stream<Path> walk = Files.walk(Paths.get("C:\\Utility\\OP_Resources\\ChromeDownload\\dup-installer"))) {

	        List<String> result = walk.filter(Files::isRegularFile)
	                .map(x -> x.toString()).collect(Collectors.toList());

	        result.forEach(System.out::println);
	        
	        for(String part: result) 
	        {
	         if(part.contains(".sql")) 
	             {
	        	 sqlFileRoute = part;
	        	 break;
	             }
	        }
	        System.out.println(sqlFileRoute);

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	  
	   
	   
	}
}
