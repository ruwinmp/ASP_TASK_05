package AdvancedLevelExamMarksData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import AdvancedLevelExamMarksData.ExamMarkDetails;

public class ExamMarkParellelStreaming {

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
		

		table.stream().forEach(x -> System.out.println(x));
	    System.out.println();
	    table.parallelStream().forEach(System.out::println);
	    

	    try {
		      FileWriter writer = new FileWriter("ExamMarkParellelStreaming.txt");
		      table.stream()
		        .forEach(x -> {
		        	try {
						writer.write(x.toString() + "\n");
					} catch (IOException e) {
						e.printStackTrace();
					}
		        });
		      
		      writer.write("\nParallel Stream\n");
		      table.parallelStream()
		      .forEach(x -> {
		        	try {
						writer.write(x.toString() + "\n");
					} catch (IOException e) {
						e.printStackTrace();
					}
		        });
		      writer.close();
		      System.out.println("Created Exam Mark Parellel Streaming Successfully.");
		    } catch (IOException e) {
		      System.out.println("Process Faield. Try Again !");
		      e.printStackTrace();
		    }
	}
	
}
