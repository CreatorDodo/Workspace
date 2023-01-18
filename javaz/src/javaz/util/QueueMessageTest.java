package javaz.util;

import java.util.LinkedList;
import java.util.Queue;

class Message {
	private String from;		//발신자
	private String content;		//내용
	private String command;		//구분
	
	public Message(String from, String content, String command) {
		this.from = from;
		this.content = content;
		this.command = command;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	
	//멤법들을 매개변수로 받아서 초기화하는 생성자
	//setter/getter
	
	
	
	
	
	
}



public class QueueMessageTest {

	public static void main(String[] args) {
		//Message 객체만 저장하는 Queue 객체 msgQ 생성
		
		//Message 객체 3개를 msgQ에 저장
		
		Queue<Message> msgQ = new LinkedList<Message>();
		
		msgQ.add(new Message("KIM", "Hi", "카카오톡"));
		msgQ.offer(new Message("LEE", "Thanks", "페이스북"));
		msgQ.offer(new Message("SANG", "Hello", "라인"));
		
		
		System.out.println("도착 메시지 : " + msgQ.size() + "건");
		System.out.println();
		while(!msgQ.isEmpty()) {	//큐가 비어있지 않으면
			Message msg = msgQ.poll();			//메세지를 하나 꺼내어 표시
			
			
			//command에 따라서 메시지 처리
			switch (msg.getCommand()) {
			case "카카오톡":
				System.out.println("카톡! " + msg.getFrom() + "이(가) " + msg.getContent() + " 메시지를 보냈습니다." );
				break;
			case "페이스북":
				System.out.println("페이스북! " + msg.getFrom() + "이(가) " + msg.getContent() + " 메시지를 보냈습니다." );
				
				break;
			case "라인":
				System.out.println("라인! " + msg.getFrom() + "이(가) " + msg.getContent() + " 메시지를 보냈습니다." );
				
				break;

			}
			
		}
		System.out.println();
		System.out.println("-------------------------");
		System.out.println("도착 메시지 : " + msgQ.size() + "건");
		

	}

}
