package javaz.swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

//Event driven programming
//- 이벤트 소스에 어떤 이벤트가 일어나는지 감시하고 있다가
//	이벤트가 발생하면 적절히 처리해주는 방식
//
//Event
//- 버튼 클릭, 마우스 움직이기, 키 입력 등...
//
//Event source
//- 이벤트를 생성하는 컴포넌트들
//- 버튼,  텍스트필드 등...
//
//Event listener
//- 생성된 이벤트 객체에 반응하여 이벤트 처리
//
//Event object
//- 이벤트 발생 시 생성
//- 발생된 이벤트에 대한 정보 보유

//이벤트 처리
//- 이벤트 리스너 작성
//- 컴포넌트에 이벤트 리스너 등록

//이벤트 처리 방법(리스너 인터페이스 또는 어답터 클래스를 이용)
//- 내부 클래스
//- 외부 클래스에서 이벤트 리스너를 구현하여 처리
//- 현재 클래스에서 이벤트 리스너를 구현하여 처리
//- 익명의 내부 클래스
//- 람다식

//ActionEvent
//- 버튼 클릭, 메뉴 항목 선택, 텍스트 필드에서 엔터키 입력 등의 경우 발생
//- ActionListener 인터페이스의 actionPerformed()를 오버라이딩하여
//	이벤트 처리 내용을 구현

//JFrame을 상속받고 ActionListener를 구현
public class ActionEventTest extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	static JLabel resultLbl;
	
	//기본생성자에서
	//패널 객체 하나를 생성하여 프레임에 추가
	//
	//가로 500, 세로 150 크기의 프레임을 생성하고
	//타이틀을 ActionEvent로 설정한 뒤
	//프레임을 닫을 때 프로그램을 종료하도록 하여
	//보이도록 처리
	public ActionEventTest()	{
		JPanel jp = new JPanel();
		JButton inner = new JButton("inner");
		JButton outer = new JButton("outer");
		JButton impl = new JButton("impl");
		JButton anony = new JButton("anony");
		JButton lambda = new JButton("lambda");
		JButton clear = new JButton("clear");
		Border border = BorderFactory.createTitledBorder("SELECT");
		
		//resultLbl 레이블의 값을 RESULT LABEL로 설정하여
		resultLbl = new JLabel("RESULT LABEL", JLabel.CENTER);
		//글씨 색을 회색으로 지정하고
		//글꼴은 Arial Black, 진하게, 크기 30으로 설정한 뒤
		resultLbl.setForeground(Color.gray);
		resultLbl.setFont(new Font("Arial Black", Font.BOLD, 30));
		
//		InnerActionListener in = new InnerActionListener();
//		inner.addActionListener(in);
		inner.addActionListener(new InnerActionListener());//inner 버튼에게 액션 리스너 추가
		outer.addActionListener(new OuterActionListener());//outer 버튼에게 액션 리스너 추가
		impl.addActionListener(this);//impl 버튼에게 액션 리스너 추가
		anony.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				resultLbl.setText(e.getActionCommand());
				
			}
		});//anony 버튼에게 액션 리스너 추가
		lambda.addActionListener(e -> { resultLbl.setText(e.getActionCommand()); });//lambda 버튼에게 액션 리스너 추가
		
		//clear 버튼의 색을 흰색으로 지정하고
		//버튼이 눌리면 resultLbl의 값을 지우기
		clear.setBackground(Color.WHITE);
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				resultLbl.setText("");
			}
		});
		
		jp.add(inner);//패널에 inner 버튼 객체 추가
		jp.add(outer);
		jp.add(impl);
		jp.add(anony);
		jp.add(lambda);
		jp.add(clear);
		
		
		jp.setBorder(border);

		//패널은 프레임의 북쪽으로 이동
		add(jp, "North");
		
		//프레임의 가운데로 추가
		add(resultLbl, BorderLayout.CENTER);
		
		
		
		setTitle("ActionEvent");
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setLayout(new FlowLayout());
		setSize(500, 150);
		setLocation(1000, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
					
		
	}
	
	//3.현재 클래스에서 액션 리스너 구현
	@Override
	public void actionPerformed(ActionEvent e) {

		resultLbl.setText("impl");
	}
	
	
	//1.내부 클래스로 액션 리스너 구현
	class InnerActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			resultLbl.setText(e.getActionCommand());
			
		}
		
	}
	
	
	public static void main(String[] args) {
		new ActionEventTest();
	}


	

}//END ActionEventTest class

//2.외부 클래스로 액션 리스너 구현
class OuterActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		ActionEventTest.resultLbl.setText(e.getActionCommand());
		
	}
	
}
