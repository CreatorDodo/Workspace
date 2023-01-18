package javaz.util;

import java.lang.reflect.Array;
import java.util.Calendar;

public class CalendarExercise {
	
	public static void makeCalendar(int start, int year, int mon) {
		int lastDate = 0;
		switch (mon) {
	case 1: lastDate = 31; break;
	case 2: //lastDate = 28; 
	lastDate =	((year%4==0 && year%100!=0) || year%400 == 0) ? 29 : 28;
		break;
	case 4:
	case 6:
	case 9: 
	case 11: lastDate = 30; break;
	default: lastDate = 31;
	}

		int firstDay = start;
		int lastDay = lastDate;
		int week = firstDay-1
				%7;

System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\t\n","Sun","Mon","Tue","Wed","Thr","Fri","Sat");
System.out.println(" ---------------------------------------------------");
		for(int i=0;i<week;i++) {	//시작 요일(1 ~ 7)까지
			System.out.print("\t");	//하루에 \t칸씩 공백찍기
		}
		
//		for (int i = 1; i < last; i++) {
//			System.out.printf("%4d", i);
//		}
//		
//		if(start++ % 7 == 0) {
//			System.out.println();
//		}
		for(int i=1;i<=lastDay;i++) {
			System.out.printf("%d\t",i);
			week++;
			if(week%7 == 0)
				System.out.println();
		}
		if(week%7 != 0) {
			System.out.println();
		}		
	
	}
	
	public static void main(String[] args) {
		//이 달의 달력 표시
		Calendar cal = Calendar.getInstance();
		//오늘이 1일로 설정하고 
		//시작 요일 정보 받기
		cal.set(Calendar.DATE, 1);
		int start = cal.get(Calendar.DAY_OF_WEEK);

		String[] weekDays = { "일", "월", "화", "수", "목", "금", "토"};
		
		
		System.out.print(cal.get(Calendar.YEAR) + "년 ");
		System.out.print(cal.get(Calendar.MONTH)+1 + "월 ");
		System.out.print(cal.get(Calendar.DATE) + "일 ");
		
		String weekDay = weekDays[cal.get(Calendar.DAY_OF_WEEK) - 1];
		System.out.println(weekDay + "요일 ");
		System.out.println();
		System.out.print(cal.get(Calendar.YEAR) + "년 ");
		System.out.println(cal.get(Calendar.MONTH)+1 + "월 ");



		int year = cal.get(Calendar.YEAR);
		int mon = cal.get(Calendar.MONTH)+1;
		

		makeCalendar(2, 2022, 5);

		makeCalendar(start, year, mon);
		

		
//		if(weekday[0] == ) {
		cal.get(Calendar.DAY_OF_MONTH);
	

	}

}
