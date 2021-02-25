package java_chobo2_ch15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriterEx {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// 문자기반 스트림 : txt, xml, properties 등등(이미지파일은 올 수 없다), byte배열대신 char배열을 사용한다.
		fileReaderWriter();
		fileReaderWriterBuffer();

	}// end of main

	public static void fileReaderWriterBuffer() throws IOException, FileNotFoundException {
		try(//지정된 파일이름을 가진 실제 파일과 연결된 FileReader 생성
			FileReader fr = new FileReader("output2.properties");
			//버퍼를 이용해서 입출력효율향상
			BufferedReader br = new BufferedReader(fr);
			//지정된 파일이름을 가진 실제 파일과 연결된 FileWriter 생성
			FileWriter fw = new FileWriter("test.properties");
			//버퍼를 이용해서 입출력 효율 향상
			BufferedWriter bw = new BufferedWriter(fw, 8192)
			){
			String line;
			while((line = br.readLine())!= null) {
				bw.write(line);
				bw.newLine();
			}
		}
	}

	public static void fileReaderWriter() {
		try (FileReader fr = new FileReader("output.xml");
			FileWriter fw = new FileWriter("test.xml")) {

			char[] cbuf = new char[512];
			while ((fr.read(cbuf)) != -1) {
				fw.write(cbuf);
			}

		} catch (FileNotFoundException e) {
			System.err.println("해당 파일이 존재하지 않음.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}// end of class
