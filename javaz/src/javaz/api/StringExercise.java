package javaz.api;

public class StringExercise {

	public void printBirthInfo(String idNo) {
		String year1, year2, month, date, gender;
		if((idNo.charAt(7) == '3') || (idNo.charAt(7) == '4'))  {
			year1 = "20";
		} else	{
			year1 = "19";
		}
//		year = idNo.substring(0, 2);
//		month = idNo.substring(2, 4);
//		date = idNo.substring(4, 6);
		
//		char g = idNo.charAt(idNo.indexOf("-") + 1);
//		if(g <= '2') {
//			
//		}else {
//			
//		}
		year2 = idNo.charAt(0)+ "" + idNo.charAt(1);
		month = idNo.charAt(2)+ "" + idNo.charAt(3);
		date = idNo.charAt(4)+ "" + idNo.charAt(5);
		if((idNo.charAt(7) == '2') || (idNo.charAt(7) == '4')) {
			gender = "여성";
		}else	{
			gender  = "남성";
		}
		System.out.println(idNo + "|" + year1 + year2 + "|" + month + "|" + date
				+ "|"+ gender);
	}

	public static void printFileInfo(String filename) {
		String name, ext;
		name = filename.replace(".mp3", "");
		String name1 = name.replace(".mpeg", "");
		ext = filename.substring(18);
		name = filename.substring(0, filename.lastIndexOf("."));
		ext = filename.substring(filename.lastIndexOf("." + 1));
		String ext1 = ext.replace(".", "");
		System.out.println(" 파일명 : " + name1);
		System.out.println(" 확장자 : " + ext1);
	}
	
	
	public static void main(String[] args) {
		//명령행 매개변수로 주민등록번호 4개 입력받기
		//990909-1234567	010203-2345678
		//101231-3456789	010203-4567890
		StringExercise s = new StringExercise();

		String idNo1 = args[0];
		String idNo2 = args[1];
		String idNo3 = args[2];
		String idNo4 = args[3];

		
		
		//1.주민등록번호에서 출생연도, 월, 일, 성별 추출

		
		
		//2.파일 정보에서 파일명과 확장자 분리하기
		String file1 = "my.music.best.one.mp3";
		String file2 = "long_long_file_two.mpeg";
		
		
		
		System.out.println("주민등록번호|출생년도|월|일|성별");
//		for (int i = 0; i < args.length; i++) {
//		}
		s.printBirthInfo(idNo1);
		s.printBirthInfo(idNo2);
		s.printBirthInfo(idNo3);
		s.printBirthInfo(idNo4);
		System.out.println();
		System.out.println("파일정보 : " + file1);
//		printFileInfo(file1);
		s.printFileInfo(file1);
		System.out.println();
		System.out.println("파일정보 : " + file2);
//		printFileInfo(file2);
		s.printFileInfo(file2);
		
	}

}
