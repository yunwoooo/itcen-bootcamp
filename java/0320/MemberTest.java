package day5;

class Member {
	String name;
	String account;
	String passwd;
	int birthyear;
}

public class MemberTest {
	public static void main(String[] args) {
		Member member1 = new Member();
		Member member2 = new Member();
		Member member3 = new Member();
		
		member1.name = "가나디";
		member1.account = "ganadi";
		member1.passwd = "gananadi!!@";
		member1.birthyear = 2010;
		
		member2.name = "고양이";
		member2.account = "catty123";
		member2.passwd = "imacat@";
		member2.birthyear = 2013;
		
		member3.name = "토끼";
		member3.account = "rabbittt";
		member3.passwd = "karrot!~";
		member3.birthyear = 2011;
		
		System.out.printf("회원 1 : %s(%s,%s,%d)\n", member1.name, member1.account, member1.passwd, member1.birthyear);
		System.out.printf("회원 2 : %s(%s,%s,%d)\n", member2.name, member2.account, member2.passwd, member2.birthyear);
		System.out.printf("회원 3 : %s(%s,%s,%d)", member3.name, member3.account, member3.passwd, member3.birthyear);
	}
}
