package javaz.swing;

import java.awt.*;

import javax.swing.*;

public class JButtonTest extends JFrame {
	private static final long serialVersionUID = 1L;

	public JButtonTest()	{
		super("Cat");
		
		//이미지와 텍스트가 표시된 버튼 객체를 생성하고 프레임에 추가
		JButton imgBtn = new JButton("Cat", new ImageIcon("src/javaz/swing/tiger.jpg"));
		add(imgBtn);
		
		JCheckBox chkBox1 = new JCheckBox("RED");
		JCheckBox chkBox2 = new JCheckBox("BLUE");
		JCheckBox chkBox3 = new JCheckBox("GREEN");
		add(chkBox1);
		add(chkBox2);
		add(chkBox3);
		
		JRadioButton radio1 = new JRadioButton("RED");
		JRadioButton radio2 = new JRadioButton("BLUE");
		JRadioButton radio3 = new JRadioButton("GREEN");
		add(radio1);
		add(radio2);
		add(radio3);	//다중 선택 가능 라디오버튼
		

		JRadioButton radio4 = new JRadioButton("RED");
		JRadioButton radio5 = new JRadioButton("BLUE");
		JRadioButton radio6 = new JRadioButton("GREEN");
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(radio4);
		btnGroup.add(radio5);
		btnGroup.add(radio6);	
		add(radio4);
		add(radio5);
		add(radio6); //단일 선택 가능 라디오버튼
		
		getContentPane().setBackground(Color.pink);
		setLayout(new FlowLayout());
		setSize(600, 600);
		setLocation(1000, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
					
		
	}
	
	public static void main(String[] args) {
		new JButtonTest();

	}

}
