package fileio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class CountLab {
	public static void main(String[] args) {
		int count = 0;
		String target = "yesterday";
		try {
	            FileReader fileReader = new FileReader("c:/iotest/yesterday.txt");
	            BufferedReader bufferredReader = new BufferedReader(fileReader);
	            Scanner scan = new Scanner(bufferredReader);
	            
				while (scan.hasNext()) {
					if (scan.next().equals(target))
						count ++;
				}
				scan.close();
				System.out.println("yesterday 라는 단어는 " + count + "개 있습니다.");
	        } catch (FileNotFoundException e) {
	            System.out.println("yesterday.txt 파일을 찾을 수 없습니다.");
	        } 
	}
}
