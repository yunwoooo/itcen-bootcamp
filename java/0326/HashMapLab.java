package day9;
import java.util.*;

public class HashMapLab {
	public static void main(String[] args) {
		HashMap<String, Integer> hashtable = new HashMap<String, Integer>(5);
		Scanner sc = new Scanner(System.in);
		
		while (hashtable.size() < 5) {
			System.out.print("나라이름을 입력하세요 : ");
	        String name = sc.nextLine();

	        if (hashtable.containsKey(name)) {
	        	System.out.printf("나라명 %s는 이미 저장되었습니다.\n", name);
	        	continue;
	        }
	        
	        System.out.print("인구 수를 입력하세요 : ");
	        int peopleCount = sc.nextInt();
	        sc.nextLine();
	        
	        hashtable.put(name, peopleCount);
	        System.out.println("*저장되었습니다*");
		}
		System.out.print("5개가 모두 입력되었습니다.\n 입력된 데이터 : ");
		
		int count = 0;
		for (String key: hashtable.keySet()) {
			count++;
			System.out.print(key + "(" + hashtable.get(key) + ")");
			if (count < hashtable.size()) {
				System.out.print(" ,");
			}
		}

	}
}
