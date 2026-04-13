package day6;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MyDay {
	static String birthDay;
	static {
		GregorianCalendar gc = new GregorianCalendar(2003, 02, 25);
		int birthDayNum = gc.get(Calendar.DAY_OF_WEEK);
		String[] weekName = {"일", "월", "화", "수", "목", "금", "토"};
		birthDay = weekName[birthDayNum - 1];
	}
	
	public static void main(String[] args) {
		System.out.printf("윤우는 %s요일에 태어났어요", birthDay);
	}
}
