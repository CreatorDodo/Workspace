package javaz.swing;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



//JFrame은 Frame, Menubar, Content Pane으로 구성된 컨테이너
//- Frame : 윈도우 자체
//- Menubar : 메뉴 부착 공간
//- Content Pane : 컴포넌트 부착 공간
//
public class JFrameTest extends JFrame{
	private static final long serialVersionUID = 1L;

	//JFrame을 상속받아, 기본생성자에서
	//가로 300, 세로 200 크기의 프레임을 만들고
	//프레임의 타이틀은 "JFrame extends"로 지정한 뒤
	//화면에 표시
	//단, 프레임을 닫으면 프로그램도 종료하도록 처리

	
	public JFrameTest()	{
		super("JFrame extends");
		JButton btn = new JButton("X");
		add(btn);
		
		btn.addActionListener(e -> {
				dispose();
				System.exit(0);
		}
		);//이벤트 핸들러 추가 - 람다식으로
		getContentPane().setBackground(Color.pink);
		setLayout(new FlowLayout());
		setSize(300, 200);
		setLocation(1000, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
					
		
	}

	public static void main(String[] args) {
		new JFrameTest();
		///////////////////////////////////////////////////////////		
		JFrame f = new JFrame("JFrame Object");	//JFrame 객체 생성
		JButton btn = new JButton("close");	//버튼 객체 생성
		//버튼을 클릭하면 프레임을 닫고 프로그램을 종료하도록
		//이벤트 핸들러 추가
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//이벤트 처리
				f.dispose(); //자원 해제
				System.exit(0);
			}
		});
		
		
		f.add(btn); //버튼을 프레임에 추가
		
		f.setResizable(false);//사이즈 조절 불가
		
		f.getContentPane().setBackground(Color.yellow);
		f.setLayout(new FlowLayout());
		f.pack();	//크기 자동 설정
		f.setSize(300, 200);	//가로 300, 세로 200 크기 지정
		f.setLocation(1000, 500);
		//프레임을 닫으면 프로그램 종료
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setVisible(true);	//보이도록 설정

		
		
	}

}
