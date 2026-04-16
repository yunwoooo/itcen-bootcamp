package fileio;
import java.io.*;

public class CopyLab {

	public static void main(String[] args) {
		try (
	            FileReader fileReader = new FileReader("c:/iotest/sample.txt");
	            BufferedReader bufferredReader = new BufferedReader(fileReader);
	            
	            FileWriter writer = new FileWriter("c:/iotest/sample_new.txt", true)
	        ) {
	            String data;
	            while ((data = bufferredReader.readLine()) != null) {
	                writer.write(data + "\n");
	            }
	            
	            System.out.println("저장 완료되었습니다.");
	            
	        } catch (FileNotFoundException e) {
	            System.out.println("sample.txt 파일을 찾을 수 없습니다.");
	        } catch (IOException e) {
	            System.out.println("입출력을 처리하는 동안 오류가 발생했습니다.");
	        }
	}
}
