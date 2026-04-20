package fileio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

public class ImageIOLab {
	public static void main(String[] args) {
		String name;
		String url;
		String[] parts = new String[2];
		try {
	            FileReader fileReader = new FileReader("c:/iotest/list.txt");
	            BufferedReader bufferredReader = new BufferedReader(fileReader);
	            Scanner scan = new Scanner(bufferredReader);
	            
				while (scan.hasNextLine()) {
					parts = scan.nextLine().split(",");
					
					name = parts[0].trim();
					url = parts[1].trim();
					try {
	                    URL req = new URI(url).toURL();
	                    
	                    try (InputStream is = req.openStream();
	                         FileOutputStream fos = new FileOutputStream("c:/iotest/myimage/" + name + ".jpg")) {
	                        
	                        int data;
	                        while ((data = is.read()) != -1) {
	                            fos.write(data);
	                        }
	                        System.out.println(name + " 저장 완료");
	                    }
	                } catch (Exception e) {
	                    System.out.println(name + " 처리 중 오류 ");
	                }
	            }
	            System.out.println("종료");

	        } catch (FileNotFoundException e) {
	            System.out.println("list.txt 파일을 찾을 수 없습니다.");
	        }
	}
}
