package javaz.swing;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.*;

//한 줄 입력이 가능한 텍스트 상자
//JTextFied : 기본 텍스트 필드
//JPasswordField : 입력 내용이 보이지 않음
//JComboBox : 직접 입력하거나 항목 중에서 선택 가능
//JSpinner : 이전/다음 버튼으로 선택


public class JTextFieldTest extends JFrame{
	private static final long serialVersionUID = 1L;

	JTextFieldTest()	{
		
		JTextField txtFld = new JTextField(10);	//텍스트 필드 객체 생성
		JLabel lbl1 = new JLabel("JTextField", JLabel.LEFT);
		
		add(lbl1);
		add(txtFld);
		
		JPasswordField pwFld = new JPasswordField(10); //패스워드필드 객체 생성
		add(new JLabel("JPasswordField"));
		add(pwFld);
		
		JComboBox<String> combo = new JComboBox<>();
		combo.addItem("Seoul");
		combo.addItem("Busan");
		combo.addItem("Jeju");
		combo.setSelectedIndex(2);
		add(new JLabel("JComboBox"));
		add(combo);
		
		//문자열 배열 rgb에 red, green, blue를 저장하여 객체 생성
		String[] rgb = {"red", "green", "blue"};
		JComboBox<String> combo2 = new JComboBox<>(rgb);
		add(new JLabel("JComboBox ii"));
		add(combo2);//rgb를 값으로 갖는 콤보박스를 프레임에 추가
		
		SpinnerModel numModel = new SpinnerNumberModel(1, 1, 10, 1);
		JSpinner spinner = new JSpinner(numModel);
		add(new JLabel("JSpinner"));
		add(spinner);
		
		getContentPane().setBackground(Color.MAGENTA);
		setLayout(new FlowLayout());
		setSize(600, 600);
		setLocation(1000, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
					
		
	}
	
	public static void main(String[] args) {
		new JTextFieldTest();
	}

}
