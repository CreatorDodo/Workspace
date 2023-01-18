package javaz.swing;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

//Adapter class
//- 인터페이스를 구현해 놓은 클래스들
//- 인터페이스처럼 모든 메소드를 오버라이딩하지 않고
//	상속을 받은 후 원하는 메소드만 사용 가능

public class AdapterTest extends JFrame implements MouseListener, MouseMotionListener{
	private static final long serialVersionUID = 1L;
	
	public AdapterTest()	{
		//패널 객체 panel을 생성하고
		//배경색을 노란색으로 지정한 후
		//프레임에 추가
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		
		panel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				panel.setBackground(Color.yellow);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel.setBackground(Color.LIGHT_GRAY);
			}
			
		});	//panel에게 마우스 리스너 추가
		

		add(panel);
		
		
		setSize(200, 200);
		setLocation(1000, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
					
		
	}

	public static void main(String[] args) {
		new AdapterTest();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}


