package AdvancedLevelExamMarksData;

public class ExamMarkDetails implements Comparable<ExamMarkDetails>{
	private int studentPosition;
	private String studentName;
	private int businessStudiesMark;
	private int accountingMark;
	private int econMark;
	private int totalMark;
	private double examAvg;
	
	
	public ExamMarkDetails(int studentPosition, String studentName, int businessStudiesMark, int accountingMark, int econMark, int totalMark, double examAvg) {
		this.studentPosition = studentPosition;
		this.studentName = studentName;
		this.businessStudiesMark = businessStudiesMark;
		this.accountingMark = accountingMark;
		this.econMark = econMark;
		this.totalMark = totalMark;
		this.examAvg = examAvg;
		
	}
	
	public int compareTo(ExamMarkDetails examMarkDetails) {
		return ((Integer)totalMark).compareTo(examMarkDetails.totalMark);
	}
	
	public String toString() {
		return String.format("%-5d%-30s%10d%10d%10d", studentPosition, studentName, businessStudiesMark, accountingMark,econMark,totalMark,examAvg);
	}
	
	public int getStudentPosition() {
		return studentPosition;
	}
	
	public void setStudentPosition(int setStudentPosition) {
		this.studentPosition = setStudentPosition;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public int getbusinessStudiesMark() {
		return businessStudiesMark;
	}
	
	public void setbusinessStudiesMark(int businessStudiesMark) {
		this.businessStudiesMark = businessStudiesMark;
	}
	
	public int getaccountingMark() {
		return accountingMark;
	}
	
	public void setaccountingMark(int accountingMark) {
		this.accountingMark = accountingMark;
	}
	
	public int geteconMark() {
		return econMark;
	}
	
	public void seteconMark(int econMark) {
		this.econMark = econMark;
	}
	
	public double getexamAvg() {
		return examAvg;
	}
	
	public void setexamAvg(int examAvg) {
		this.examAvg = examAvg;
	}
	
	public int gettotalMark() {
		return totalMark;
	}
	
	public void settotalMark(int totalMark) {
		this.totalMark = totalMark;
	}
	
}
