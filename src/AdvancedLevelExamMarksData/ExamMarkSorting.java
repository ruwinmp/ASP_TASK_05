package AdvancedLevelExamMarksData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import AdvancedLevelExamMarksData.ExamMarkDetails;

public class ExamMarkSorting {

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

		System.out.println("\nSorted by Position - Descending");
	    table.stream().sorted().forEach(System.out::println);

	    System.out.println();
	    System.out.println("Sorted by Student Name - Ascending");
	    table.stream()
	         .sorted((c1, c2) -> 
	            ((String) c1.getStudentName()).compareTo(c2.getStudentName()))
	         .forEach(System.out::println);

	    try {
		      FileWriter writer = new FileWriter("ExamMarkSorting.txt");
		      writer.write("Sorted by Position - Descending\n");
		      table.stream().sorted()
		        .forEach(str -> {
		        	try {
						writer.write(str.toString() + "\n");
					} catch (IOException e) {
						e.printStackTrace();
					}
		        });
		      
		      writer.write("\nSorted by Student Name - Ascending\n");
		      table.stream().sorted((c1, c2) -> 
	            ((String) c1.getStudentName()).compareTo(c2.getStudentName()))
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
