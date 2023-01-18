package javaz.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateTest {

	public static void printDateTime(Calendar cal){
		System.out.print("오늘은 " + cal.get(Calendar.YEAR) + "년 ");
		System.out.print(cal.get(Calendar.MONTH)+1 + "월 ");
		System.out.print(cal.get(Calendar.DATE) + "일 ");
		
		String yo = null;
		switch (cal.get(Calendar.DAY_OF_WEEK)) {
		case 1:yo = "일";
			
			break;
		case 2:yo = "월";
		
		break;
		case 3:yo = "화";
		
		break;
		case 4:yo = "수";
		
		break;
		case 5:yo = "목";
		
		break;
		case 6:yo = "금";
		
		
		break;
		case 7:yo = "토";
		
		break;

		default:
			break;
		}
//		String[] weekDays = { "일", "월", "화", "수", "목", "금", "토"};
//		String weekDay = weekDays[cal.get(Calendar.DAY_OF_WEEK) - 1];
		System.out.println(yo + "요일 ");
		
		String o = null;
		if(cal.get(Calendar.AM_PM) == 0) {
			o = "오전";
			} else {
				o = "오후";
			}
		
//		System.out.println(cal.get(Calendar.AM_PM) == 0 ? "오전" : "오후" );
		System.out.print("지금 시간은 " + o + " ");
		System.out.print(cal.get(Calendar.HOUR) + "시 ");
		System.out.print(cal.get(Calendar.MINUTE) + "분 ");
		System.out.println(cal.get(Calendar.SECOND) + "초 ");
	}
	
	public static void main(String[] args) throws ParseException {
		Date date = new Date();
		Date current = new Date(System.currentTimeMillis());
		
		
		System.out.println(date);
		System.out.println(current);
		System.out.println(current.toLocaleString());
		
		System.out.println();
		//Date >> String
//		String str = date;		// X
		
		SimpleDateFormat dateFmt	//특정 문자열 포맷
			= new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		String str = dateFmt.format(date); // O
		System.out.println(str);
		
		//String >> Date
//		date = "2022/10/22 11:22:33"	//X
		date = dateFmt.parse("2022/10/22 11:22:33"); //O
		System.out.println(date);
		
		//Date >> Calendar
		Date now = new Date();
//		Calendar cal = new Calendar(); 	//X
		Calendar cal = Calendar.getInstance();
		
		cal.setTime(now);
		
		//Calendar >> Date
		cal = Calendar.getInstance();
		
		date = new Date(cal.getTimeInMillis());
		
		
		
							//오늘은 ~~~~년 ~~월 ~~일 ~~요일 
							//지금 시간은 오전/오후 ~~시 ~~분 ~~초
		
		
		System.out.println("----------------------");
		System.out.println("특정일시 지정하고 받아오기");
		System.out.println("생년월일 : 2000년 5월 5일 금요일");
		System.out.println("출생시간 : 오후 11시 22분 33초");
		Calendar birthInfo = Calendar.getInstance();
		
		printDateTime(birthInfo); //before cal.set()
		birthInfo.set(2000, 5-1, 5);
		birthInfo.set(Calendar.HOUR, 11);
		birthInfo.set(Calendar.MINUTE, 22);
		birthInfo.set(Calendar.SECOND, 33);
		//after cal.set()
		System.out.println();
		printDateTime(birthInfo);
		
		
		
	}

}
