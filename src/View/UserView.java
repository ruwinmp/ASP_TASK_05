package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import AdvancedLevelExamMarksData.ExamMarkFilter;
import AdvancedLevelExamMarksData.ExamMarkForeach;
import AdvancedLevelExamMarksData.ExamMarkLowest;
import AdvancedLevelExamMarksData.ExamMarkParellelStreaming;
import AdvancedLevelExamMarksData.ExamMarkSorting;

public class UserView extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	static JButton button;
	static JLabel label;
	static JFrame frame = new JFrame("Exploration of Functional Programming - TASK 06");
	static JPanel panel;
	
	public static void main (String[]args) {
		UserView gui = new UserView();
		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		
		panel.add(Box.createVerticalStrut(1));
		button = new JButton("Exam Marks Foreach");
		panel.add(button);
		button.addActionListener(gui); 
		panel.add(Box.createVerticalStrut(10));
		
		panel.add(Box.createVerticalStrut(1));
		button = new JButton("Exam Marks Parellel Streaming");
		panel.add(button);
		button.addActionListener(gui); 
		panel.add(Box.createVerticalStrut(10));

		panel.add(Box.createVerticalStrut(1));
		button = new JButton("Exam Marks Lowest");
		panel.add(button);
		button.addActionListener(gui); 
		panel.add(Box.createVerticalStrut(10));

		panel.add(Box.createVerticalStrut(1));
		button = new JButton("Exam Marks Filter");
		panel.add(button);
		button.addActionListener(gui); 
		panel.add(Box.createVerticalStrut(10));

		panel.add(Box.createVerticalStrut(1));
		button = new JButton("Exam Marks Sorting");
		panel.add(button);
		button.addActionListener(gui); 
		panel.add(Box.createVerticalStrut(10));
		
		frame.setSize(450,240);
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand(); 
		if (s.equals("Exam Marks Foreach")) { 
			ExamMarkForeach.readAndWrite();
		} else if (s.equals("Exam Marks Parellel Streaming")) { 
			ExamMarkParellelStreaming.readAndWrite();
		} else if (s.equals("Exam Marks Lowest")) { 
			ExamMarkLowest.readAndWrite();
		} else if (s.equals("Exam Marks Filter")) {
			ExamMarkFilter.readAndWrite();
		} else if (s.equals("Exam Marks Sorting")) { 
			ExamMarkSorting.readAndWrite();
		} 
	}
	
}
