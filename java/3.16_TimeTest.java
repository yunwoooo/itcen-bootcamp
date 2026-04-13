package day1;

public class TimeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int time;
		time = 32150; //초
		
		int hour; // 24
		int min; // 60
		int sec; // 60
		
		hour = time / ( 60 * 60 );
		min = (time % ( 60 * 60 )) / 60;
		sec = time %  60 ;
		
		System.out.println(hour + "시간 " + min + "분 " + sec + "초");
	}

}
