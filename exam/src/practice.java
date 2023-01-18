import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class practice {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
			list.add(101);
			list.add(102);
			list.add(103);
			list.add(104);
			list.add(105);
		int random = (int) (Math.random() * list.size());
		System.out.println("오늘의 추천 여행지 : " + list.get(random));
	}

}
