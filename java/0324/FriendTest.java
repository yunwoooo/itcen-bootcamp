package day7;

public class FriendTest {
	public static void main(String[] args) {
		Friend[] friends = new Friend[5];
		friends[0] = new Friend("강강강", "010-1111-1111", "gang@naver.com");
		friends[1] = new Friend("낭낭낭", "010-2222-2222", "nang@naver.com");
		friends[2] = new Friend("당당당", "010-3333-3333", "dang@naver.com");
		friends[3] = new Friend("랑랑랑", "010-4444-4444", "rang@naver.com");
		friends[4] = new Friend("망망망", "010-5555-5555", "mang@naver.com");
		
		System.out.println("이름   \t   전화번호   \t   메일주소");
		System.out.println("-----------------------------------------------------");
		
		for (int i = 0; i < friends.length; i++) {
			System.out.println(friends[i].getInfo());
		}
	}
}
