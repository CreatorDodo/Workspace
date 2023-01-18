package javaz.swing;

import java.awt.*;
import javax.swing.*;

public class LayoutTest extends JFrame {
	private static final long serialVersionUID = 1L;
	
	
	
	//1.프레임을 설정 -----------------------------
	//메소드 이름 : setFrame
	//매개변수 : 문자열 layoutMgr
	//반환타입 : 없음
	//기능 : 프레임의 크기 지정 - 가로 300, 세로 150
	//		매개변수로 받은 문자열로 프레임의 타이틀 지정
	//		프레임을 닫을 때 프로그램 종료 처리
	//		프레임 보이기 설정
	
	public void setFrame(String layoutMgr)	{
		setTitle(layoutMgr);
		setSize(300, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	//2.FlowLayout 설정 -------------------------
	//메소드 이름 : flowLayout
	//접근제한 : 없음
	//매개변수 : 없음
	//반환타입 : 없음
	//기능 : 버튼 객체 5개를 first, second, third, 
	//		fourth, fifth의 텍스트가 표시되게 생성하여 
	//		프레임을 추가
	
	public void flowLayout()	{
		JButton first = new JButton("first");
		JButton second = new JButton("second");
		JButton third = new JButton("third");
		
		add(first);
		add(second);
		add(third);
		add(new JButton("fourth"));
		add(new JButton("fifth"));
		
		setLayout(new FlowLayout());
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		setFrame("FlowLayout");
	
	}
	
	public void borderLayout()	{
		setLayout(new BorderLayout());	//프레임의 기본 레이아웃 매니저
		setLayout(new BorderLayout(10, 20));
		
		JButton first = new JButton("first");
		JButton second = new JButton("second");
		JButton third = new JButton("third");
		
		add(first, BorderLayout.PAGE_START);
		add(second, BorderLayout.WEST);
//		add(third);	//위치를 지정하지 않을 경우 기본 위치
		add(third, "Center");
		add(new JButton("fourth"), BorderLayout.LINE_END);
		add(new JButton("fifth"), BorderLayout.SOUTH);

		setFrame("BorderLayout");
	
	}
	
	public void gridLayout()	{
		JButton first = new JButton("first");
		JButton second = new JButton("second");
		JButton third = new JButton("third");
		
		add(first);
		add(second);
		add(third);
		add(new JButton("fourth"));
		add(new JButton("fifth"));
		
		setLayout(new GridLayout());
		setLayout(new GridLayout(2, 3));
		setLayout(new GridLayout(3, 2, 5, 10));
		setFrame("GridLayout");
	
	}
	
	public void nullLayout()	{
		JButton first = new JButton("first");
		JButton second = new JButton("second");
		JButton third = new JButton("third");
		
		first.setBounds(10, 10, 70, 30);
		second.setBounds(100, 20, 70, 70);
		
		
		add(first);
		add(second);
		add(third);
		add(new JButton("fourth"));
		add(new JButton("fifth"));
		
		setLayout(null);
		setFrame("Null Layout");
	
	}
	
	public LayoutTest()	{
	
		setLocation(1000, 500);
	
	}
	


	public static void main(String[] args) {
		LayoutTest layout =  new LayoutTest();
		
//		layout.flowLayout();
//		layout.borderLayout();
//		layout.gridLayout();
		layout.nullLayout();
		
		
		
		
		
		
		
		
		
		
		
	}

}
