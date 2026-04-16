package day9;
import java.util.*;

public class HashSetLab {
	public static void main(String[] args) {
		HashSet<Integer> hashtable = new HashSet<Integer>(10);
		int nums;
		while (hashtable.size() < 10) {
			nums = (int)(Math.random() * 21) + 10;
			hashtable.add(nums);
		}
		Iterator<Integer> iterator = hashtable.iterator();
		int count = 0;
		System.out.print("오늘의 로또 번호 : ");
		while (iterator.hasNext()) {
			int num = iterator.next();
			if (count < 9)
				System.out.print(num +  ", ");
			else
				System.out.print(num);
			count++;
		}
	}
}
