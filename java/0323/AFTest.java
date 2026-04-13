package day6;

class AcademyFriend {
	static String academyName = "kosa";
	private String name;
	private String color;
	private String hobby;
	private String food;
	
	AcademyFriend(String name, String color, String hobby, String food) {
		this.name = name;
		this.color = color;
		this.hobby = hobby;
		this.food = food;
	}
	String getName() {
		return name;
	}
	String getColor() {
		return color;
	}
	String getHobby() {
		return hobby;
	}
	String getFood() {
		return food;
	}
}

public class AFTest {

	public static void main(String[] args) {
		
		AcademyFriend[] friends = new AcademyFriend[5];
		friends[0] = new AcademyFriend("김윤우", "흰색", "요가", "마라탕");
		friends[1] = new AcademyFriend("정가영", "자주색", "수영", "초밥");
		friends[2] = new AcademyFriend("이재혁", "검은색", "헬스", "김치볶음밥");
		friends[3] = new AcademyFriend("안주혁", "회색", "산책", "햄버거");
		friends[4] = new AcademyFriend("조윤지", "하늘색", "독서", "피자");
		
		for (int i = 0; i < friends.length; i++) {
			System.out.printf("%s 동료는 좋아하는 칼라가 %s이며 취미는 %s입니다. "
					+ "그리고 제일 좋아하는 음식은 %s입니다. "
					+ "지금은 %s에서 Java 기반 풀스택과 Python 기반 AI를 학습하고 있어요.\n", friends[i].getName(), friends[i].getColor(), friends[i].getHobby(), friends[i].getFood(), AcademyFriend.academyName);
		}
	}

}
