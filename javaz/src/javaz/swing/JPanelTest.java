package javaz.swing;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;

//JPanel
//- 컴포넌트들을 부착할 수 있는 컨테이너
//- 독립적으로 사용 불가

//JFrame을 상속 받고 기본 생성자를 이용하여
//크기 설정 및 종료 이벤트 처리를 한 후
//화면에 보이도록 설정
//단, 버튼 객체 3개를
//	X, 2nd Button, 3rd Button으로 표시하여
//	프레임에 추가



public class JPanelTest extends JFrame{
	private static final long serialVersionUID = 1L;
	
		JPanelTest()	{
			super("JPanel");
			//패널 객체 두 개 생성 및 배경색 지정
			JPanel yellowPanel = new JPanel();
			JPanel bluishPanel = new JPanel();
			
			yellowPanel.setBackground(Color.yellow);
			bluishPanel.setBackground(new Color(218, 217, 255));
			
			JButton btn1 = new JButton("2nd Button");
//			add(btn1);
			JButton btn2 = new JButton("3rd Butoon");
//			add(btn2);
			JButton btn3 = new JButton("X");
//			add(btn3);
			
			ImageIcon imgIcon = new ImageIcon("src/javaz/swing/tiger.jpg");
			
			JLabel lbl1 = new JLabel("Hello");
			JLabel lbl2 = new JLabel();
			JLabel lbl3 = new JLabel(imgIcon);
			
			lbl2.setText("Duke!~");	//레이블에 텍스트 설정
			lbl2.setFont(new Font("Arial Black", Font.ITALIC, 30));	//폰트 지정
			lbl2.setForeground(Color.MAGENTA);	//레이블 텍스트 색 지정
			
			
			yellowPanel.add(lbl1);
			yellowPanel.add(lbl2);
			yellowPanel.add(lbl3);//레이블을 패널에 추가
			
			bluishPanel.add(btn1);
			bluishPanel.add(btn2);
			bluishPanel.add(btn3);//버튼을 패널에 추가
			
			add(bluishPanel);
			add(yellowPanel);//패널을 프레임에 추가
			
//			btn3.addActionListener(e -> {
//					dispose();
//					System.exit(0);
//			}
//			);//이벤트 핸들러 추가 - 람다식으로
			
			getContentPane().setBackground(Color.ORANGE);
			setLayout(new FlowLayout());
			setSize(300, 300);
			setLocation(1000, 500);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
		}
		
	public static void main(String[] args) {
		new JPanelTest();
	}

}
