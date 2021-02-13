package AdvancedLevelExamMarksData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import AdvancedLevelExamMarksData.ExamMarkDetails;

public class ExamMarkFilter {
	
	public static void main(String[] args) {
		readAndWrite();
	}

	public static void readAndWrite() {
		List<ExamMarkDetails> table = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("ExamMarksDetails1.csv"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(",");
		        table.add(new ExamMarkDetails(
		        		Integer.parseInt(values[0]),
		        		values[1].toString(),
		        		Integer.parseInt(values[2]),
		        		Integer.parseInt(values[3].toString()),
		        		Integer.parseInt(values[4].toString()),
		        		Integer.parseInt(values[5].toString()),
		        		Double.parseDouble(values[6].toString())));
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("\nStudent Who Got 230 as a Total Mark");
	    table.stream().filter(student -> student.gettotalMark() == 230)
	        .forEach(System.out::println);

	    System.out.println();
	    System.out.println("Student Who Got 40 as a Account Mark");
	    table.stream().filter(student -> student.getaccountingMark() == 40)
	        .forEach(System.out::println);
	    
	    try {
		      FileWriter writer = new FileWriter("ExamMarkFilter.txt");
		      writer.write("Student Who Got 78 as a BS Mark\n");
		      table.stream().filter(student -> student.getbusinessStudiesMark() == 78)
		        .forEach(str -> {
		        	try {
						writer.write(str.toString() + "\n");
					} catch (IOException e) {
						e.printStackTrace();
					}
		        });
		      
		      writer.write("\nStudent Who Got 25 as a Econ Mark\n");
		      table.stream().filter(student -> student.geteconMark() == 25)
		        .forEach(str -> {
		        	try {
						writer.write(str.toString() + "\n");
					} catch (IOException e) {
						e.printStackTrace();
					}
		        });
		      writer.close();
		      System.out.println("Created Exam Mark For Each Successfully !");
		    } catch (IOException e) {
		      System.out.println("Process Faield. Try Again !");
		      e.printStackTrace();
		    }
	}
	
}
