package fileio;
import java.io.*;
import java.time.LocalDate;

public class FileOutLap {
	public static void main(String[] args) {
        try (FileWriter fileWriter = new FileWriter("c:/iotest/event.txt")) {
            String[] days = {"월", "화", "수", "목", "금", "토", "일"};
            LocalDate day1 = LocalDate.of(2026, 8, 15);
            LocalDate day2 = LocalDate.of(2026, 12, 25);
            
            String day3 = days[day1.getDayOfWeek().getValue() - 1];
            String day4 = days[day2.getDayOfWeek().getValue() - 1];

            fileWriter.write("2026년 8월 15일은 " + day3 + "요일입니다.\n");
            fileWriter.write("2026년 12월 25일은 " + day4 + "요일입니다.\n");
            
            System.out.println("저장이 완료되었습니다.");

        } catch (IOException e) {
            System.out.println("파일에 저장하는 동안 오류가 발생했습니다.");
        }
	}
}
