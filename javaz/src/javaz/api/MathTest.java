package javaz.api;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class MathTest {

	public static void main(String[] args) {
		System.out.println(Math.ceil(3.4));
		System.out.println(Math.ceil(3.5));
		System.out.println();
		System.out.println(Math.floor(3.4));
		System.out.println(Math.floor(3.5));
		System.out.println();
		System.out.println(Math.round(3.4));
		System.out.println(Math.round(3.5));
		System.out.println();
		System.out.println(Math.PI);
		System.out.println();
		
		double random = Math.random();
		System.out.println(random);
		
		int zeroOneTwo = 0; //0, 1, 2 중 하나를 저장
		int oneTwoSam = 0; //1, 2, 3 중 하나를 저장
		int tenTo12 = 0; //10, 11, 12 중 하나를 저장
		System.out.println();
		
					//(int) Math.random()
		zeroOneTwo = (int) random * 3;
		oneTwoSam = (int) random * 3 + 1;
		tenTo12 = (int) (random * (12 - 10 + 1)) + 10;
		
		System.out.println(zeroOneTwo);
		System.out.println(oneTwoSam);
		System.out.println(tenTo12);
		
		System.out.println("----------------------");
		System.out.println(" 로또 번호 생성 ");


		
		int min = 1;
		int max = 45;
		
		int[] lottoNum = new int[6];
		
		for (int i = 0; i < lottoNum.length; i++) {
			//1 ~ 45 사이의 중복되지 않는 정수형 난수 6개를 추출하여
			//배열 lottoNum에 저장하고
			lottoNum[i] = (int) (Math.random() * (max - min + 1)) + min;
		
			//중복 확인
			//추출한 난수와 lottoNum 배열의 값들과 비교하여 같으면
			//i 값을 1 감소 시키고 내부의 for문 종료
			//오름차순으로 정렬하여 출력
			for (int j = 0; j < i; j++) {
				if(lottoNum[i] == lottoNum[j]) {
					i--;
					break;
				} else if (lottoNum[i] < lottoNum[j]) {
					int temp = lottoNum[i];
					lottoNum[i] = lottoNum[j];
					lottoNum[j] = temp;
				}
			}
			
		}
		
		for (int i : lottoNum) {
			System.out.print(i + " ");
		}
		
		
		
		System.out.println();
		System.out.println("----------------------");
		System.out.println("2.로또 당첨 번호 ");
		
		int[] lottoNumTest = new int[] {2, 14, 15, 22, 27, 33};
		
		int[] lottoWin = {2, 14, 15, 22, 27, 33};
		int bonusNum = 31;
		int good = 0;
		
		System.out.println("win lotto : " + Arrays.toString(lottoWin) + " + " + bonusNum);
		System.out.println("my lotto : " + Arrays.toString(lottoNum));
		for (int i = 0; i < lottoNum.length; i++) {
			for (int j = 0; j < lottoWin.length; j++) {
				if(lottoNum[i] == lottoWin[j]) {
					good += 1;
					break;
				}
			}
		}
		boolean bonusA = false;
		
		for (int i = 0; i < lottoWin.length; i++) {
			if(lottoNum[i] == bonusNum) {
				bonusA = true;
			}
		}
		
//		for (int myNum : lottoNum) {
//			result = bonusNum == myNum ? "2등" : "3등";
//		}
	
		if(good == 6) {
			System.out.println("1등");
		}else if(good == 5) {
			if(bonusA = true) {
			System.out.println("2등");
			}else {
				System.out.println("3등");
			}
		}
		else if(good == 4) {
			System.out.println("4등");
		}
		else if(good == 3) {
			System.out.println("5등");
		}else {
			System.out.println("괜찮아요!");
		}
		System.out.println();
		System.out.println("----------------------");
		System.out.println("3.당첨 결과");
		System.out.println(good);
		//1등 : 6개 모두 일치
		//2등 : 5개 일치 + 보너스 일치
		//3등 : 5개 일치
		//4등 : 4개 일치
		//5등 : 3개 일치
		
		
		
		
	}

}
