package AdvancedLevelExamMarksData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

import AdvancedLevelExamMarksData.ExamMarkDetails;

public class ExamMarkLowest {

	public static void main(String[] args) {
		readAndWrite();
	}

	public static void readAndWrite() {
		List<ExamMarkDetails> table = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("ExamMarksDetails1.csv"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(",");
		        table.add(new ExamMarkDetails(Integer.parseInt(values[0]),values[1],Integer.parseInt(values[2]),Integer.parseInt(values[3]),Integer.parseInt(values[4]),Integer.parseInt(values[5]),Double.parseDouble(values[6])));
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

		OptionalInt min = table.stream().mapToInt(ExamMarkDetails::gettotalMark).min();
	    if (min.isPresent()) {
	      System.out.printf("\nLowest Total Mark is %d\n", min.getAsInt());
	    } else {
	      System.out.println("Failed !");
	    }

	    System.out.print("Marks of Business Studies is ");
	    Integer result = table.stream().map(ExamMarkDetails::getbusinessStudiesMark).reduce(0, (a, b) -> a + b);
	    System.out.println(result);
	    

	    List<String> s = table.stream()
	    	    .filter(p -> p.getbusinessStudiesMark() < 60)
	    	    .map(ExamMarkDetails::getStudentName)
	    	    .collect(Collectors.toList());
	    	                   
	    	System.out.println("Student who got less than 60 marks for BS :" +
	    	    s.toString());
	    	
		    
    	try {
		      FileWriter writer = new FileWriter("ExamMarkLowest.txt");
		      writer.write("Lowest Exam Mark " + min.getAsInt() + "\n");
		      writer.write("Total Marks of Business Studies : " + result + "\n");
		      writer.write("Students who got less than 60 marks for BS : " + s + "\n");
		      writer.close();
		      System.out.println("Created Exam Mark Lowest Details Successfully!");
		    } catch (IOException e) {
		      System.out.println("Process Faield. Try Again !");
		      e.printStackTrace();
		    }
	}
	
}
