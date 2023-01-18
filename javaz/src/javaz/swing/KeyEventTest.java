package javaz.swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

//JFrame을 상속받고 KeyListener를 구현

public class KeyEventTest extends JFrame implements KeyListener {
	private static final long serialVersionUID = 1L;

	public KeyEventTest()	{
		JLabel inputLbl = new JLabel("INPUT ");
		JTextField text = new JTextField(12);
		JButton clearBtn = new JButton("clear");
		
		//text에게 KeyListener 추가하기
				text.addKeyListener(this);
				
				clearBtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						text.setText("");	//clearBtn을 클릭하면 text의 내용 지우기
						text.requestFocus();	//text에 포커스 맞추기
					}
				});
		
		add(inputLbl);
		add(text);
		add(clearBtn);

		
		
		setLayout(new FlowLayout());
		setTitle("KeyEvent");
		getContentPane().setBackground(Color.ORANGE);
		setSize(250, 80);
		setLocation(1000, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
//		System.out.println("keyTyped");
	}

	@Override
	public void keyPressed(KeyEvent e) {
//		System.out.println("keyPressed");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println(e.getKeyChar());
		System.out.println(e.getKeyCode());
		System.out.println(e.isActionKey());
		System.out.println(e.isControlDown());
		
		switch (e.getKeyCode()) {
		case KeyEvent.VK_ENTER: System.out.println("엔터키!");
			break;
		case KeyEvent.VK_UP: System.out.println("위쪽 화살표!");
			break;

		default:
			break;
		}
//		System.out.println("keyReleased");
		
	}

	
	
	
	
	
	
	public static void main(String[] args) {
		new KeyEventTest();
	}

	

}
