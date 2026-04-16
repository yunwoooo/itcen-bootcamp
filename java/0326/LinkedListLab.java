package day9;
import java.util.*;

import day7.Friend;

public class LinkedListLab {
	public static void main(String[] args) {
		LinkedList<Friend> list = new LinkedList<Friend>();
		list.add(new Friend("강강강", "010-1111-1111", "gang@naver.com"));
		list.add(new Friend("낭낭낭", "010-2222-2222", "nang@naver.com"));
		list.add(new Friend("당당당", "010-3333-3333", "dang@naver.com"));
		list.add(new Friend("랑랑랑", "010-4444-4444", "rang@naver.com"));
		list.add(new Friend("망망망", "010-5555-5555", "mang@naver.com"));
		
		System.out.println("이름   \t   전화번호   \t   메일주소");
		System.out.println("-----------------------------------------------------");
		
		for (Friend f : list) {
			System.out.println(f.getInfo());
		}
	}
}
