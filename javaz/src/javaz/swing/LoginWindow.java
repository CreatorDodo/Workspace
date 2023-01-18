package javaz.swing;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.swing.*;

import javaz.member.LoginCheck;
import javaz.member.MemberDAO;
import javaz.member.MemberVO;

//1.JFrame 클래스 상속받기
public class LoginWindow extends JFrame {
	private static final long serialVersionUID = 1L;

	private int input;
	private Scanner scan = new Scanner(System.in);
	private MemberDAO mdao = new MemberDAO();
	private LoginCheck lc = new LoginCheck();

	private Map<String, String> loginMap;

	// 2.로그인 창 컴포넌트
	private JPanel loginPnl;
	private JButton loginBtn, cancelBtn;
	private JLabel idLbl, pwLbl;
	private JTextField idTxt, pwTxt;

	// 3.로그인 창(가로 250, 세로 130) 표시 - 기본 생성자

	public LoginWindow() {

		loginPnl = new JPanel();
		loginBtn = new JButton("LOGIN");
		cancelBtn = new JButton("CANCEL");
		idLbl = new JLabel("ID      　");
		pwLbl = new JLabel("Password");
		idTxt = new JTextField(12);
		pwTxt = new JPasswordField(12);

		// cancel 버튼을 클릭하면 프레임을 닫고 프로그램을 종료하도록
		// 이벤트 핸들러 추가

		cancelBtn.addActionListener(e -> {
			dispose();
			System.exit(0);
		});

		loginBtn.addActionListener(e -> {

			List<MemberVO> members = new ArrayList<>();

			String id = idTxt.getText().trim();

			String pw = pwTxt.getText().trim();

			boolean result = lc.loginChk(id, pw);

			if (idTxt.getText().equals("") || pwTxt.getText().equals(""))
				// 1.아이디 또는 비밀번호를 입력하지 않았을 경우의 처리
				
//				(idTxt.getText().isEmpty())
				if (idTxt.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "아이디를 입력해주세요.");
					idTxt.requestFocus();
				}
			if (pwTxt.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "비밀번호를 입력해주세요.");
				idTxt.requestFocus();
			} else {
				if (result == true) {
					dispose();
					JOptionPane.showMessageDialog(this, id + "님 어서오세요!");

					// 2.로그인 입력 창은 보이지 않게 처리
				} else {
					JOptionPane.showMessageDialog(this, "아이디 또는 비밀번호가 일치하지 않습니다.");
					idTxt.setText("");
					pwTxt.setText("");
					idTxt.requestFocus();
					// 3.입력 필드의 값을 모두 지우고
					// 아이디 입력 필드에 포커스 맞추기
				}
			}
		});

		loginPnl.add(idLbl);
		loginPnl.add(idTxt);
		loginPnl.add(pwLbl);
		loginPnl.add(pwTxt);
		loginPnl.add(cancelBtn);
		loginPnl.add(loginBtn);

		add(loginPnl); // 프레임에는 패널만 추가

//			getContentPane().setBackground(Color.CYAN);
//			setLayout(new FlowLayout());
		setTitle("Login");
		setSize(200, 130);
		setLocation(1000, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}
	// 3.로그인 창(가로 250, 세로 130) 표시 - 기본 생성자

	public static void main(String[] args) {
		new LoginWindow();

	}

}
