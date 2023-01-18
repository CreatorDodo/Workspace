package javaz.swing;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class MouseEventTest extends JFrame implements MouseListener, MouseMotionListener{
	private static final long serialVersionUID = 1L;

	public MouseEventTest()	{
		

		
		addMouseListener(this);

		addMouseMotionListener(this);
		
		
		
		setTitle("MouseEvent");
		getContentPane().setBackground(Color.MAGENTA);
		setLayout(new FlowLayout());
		setSize(200, 200);
		setLocation(1000, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	
	@Override
	public void mouseDragged(MouseEvent e) {
//		System.out.println("dragged");
		
	}



	@Override
	public void mouseMoved(MouseEvent e) {
//		System.out.println("moved");
		
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		int count = e.getClickCount();
		int mouseBtn = e.getButton();
		
		if(count == 1) {System.out.print("clicked ");}
		if(count == 2) {System.out.print("double clicked");	}
		System.out.print(" x:" + e.getX() + " y:" + e.getY());
		
		if(mouseBtn == MouseEvent.BUTTON1) {
			System.out.println(" BUTTON1-마우스 왼쪽 버튼");
		}
		
		if(mouseBtn == MouseEvent.BUTTON2) {
			System.out.println(" BUTTON2-마우스 휠");
		}
		
		if(mouseBtn == MouseEvent.BUTTON3) {
			System.out.println(" BUTTON3-마우스 오른쪽 버튼");
		}
		
		
//				System.out.println("clicked");
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
//		System.out.println("pressed");
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
//		System.out.println("released");
		
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("");
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("");
		
	}
	
	
	public static void main(String[] args) {
		new MouseEventTest();
	}



	

}
