package javaz.swing;

import java.awt.*;

import javax.swing.*;

public class JTableTest extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public JTableTest()	{
		
		String[] tblHeader = {"Name", "AGE", "ADDRESS"};
		
		String[][] tblData = {{"Kim", "20", "SEOUL"}, {"Lee", "30", "JEJU"}, {"Han", "40", "BUSAN"},
				{"San", "50", "MUKO"}, {"Ann", "60", "ISLAND"}, {"Man", "70", "SIMA"}};
		
		
		JTable tbl = new JTable(tblData, tblHeader);
		JScrollPane scrollPne = new JScrollPane(tbl);
		add(scrollPne);
		
		getContentPane().setBackground(Color.CYAN);
//		setLayout(new FlowLayout());
		setTitle("JTable test");
		setSize(300, 100);
		setLocation(1000, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
					
		
	}
	public static void main(String[] args) {
		new JTableTest();
	}

}
