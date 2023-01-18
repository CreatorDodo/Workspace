package javaz.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class StreamMessageTest {

	public static void main(String[] args) {
		//1.Message 객체 3개를 저장한 List 타입의 인스턴스 msgList 생성
		List<Message> msgList = new ArrayList<Message>() {
		}; 
		
		msgList.add(new Message("KIM", "Hi", "카카오톡"));
		msgList.add(new Message("LEE", "Thanks", "페이스북"));
		msgList.add(new Message("SANG", "Hello", "라인"));
		
		//2.foreach문을 이용하여 list에서 Katalk 메시지만 출력
		for ( Message message : msgList) {
			String command = message.getCommand();
			if(command.equals("카카오톡")) {
				System.out.println(message.getFrom() + "의 카톡 : " + message.getContent());
			}
			
		}
		System.out.println();
		
		//3.Stream api와 람다식을 이용하여 list에서 sms 메시지만 출력
		msgList.stream().filter(message -> message.getCommand().equals("라인")).forEach(message -> System.out.println(message.getFrom() + "의 sms : " + message.getContent()));
		
			
	}

}
