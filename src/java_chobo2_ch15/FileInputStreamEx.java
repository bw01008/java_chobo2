package java_chobo2_ch15;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamEx {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		//보조스트림 BufferedStream의 사용유무에 따른 속도 차이
		fileImputStreamEx();
		bufferedImputStreamEx();
	}// end of main

	public static void bufferedImputStreamEx() throws IOException, FileNotFoundException {
		File file = new File("image.jpg"); // 이미지파일을 담은 객체 생성
		try ( // 1. 지정된 파일이름을 가진 실제 파일과 연결된 FileInputStream을 생성한다.
				FileInputStream fis = new FileInputStream(file);
				// 2. 속도를 위해 버퍼(바이트배열) 이용해서 입력 : 주어진 FileInputStream인스턴스를 입력소스로하며 지정된 크기의 버퍼를 갖는
				// 인스턴스 생성
				BufferedInputStream bis = new BufferedInputStream(fis, 8192);
				// 3. 지정된 파일이름을 가진 실제 파일과 연결된 FileInputStream을 생성한다.
				FileOutputStream fos = new FileOutputStream("image.jpg");
				// 4. 주어진 FileOutputStream인스턴스를 입력소스로 하여 인스턴스 생성
				//버퍼가 가득찼을떄만 출력 > 마지막 출력부분이 남은채로 종료할수 있음 : close(), flush()
				BufferedOutputStream bos = new BufferedOutputStream(fos)) {
			int data = 0;
			//입력소스로부터 버퍼 크기만큼의 데이터를 읽어서 자신의 내부 버퍼에 저장
			while ((data = bis.read()) != -1) {	//-1이 출력되는 경우는 다 읽고 마지막에 도달했을때...
				bos.write(data);
			}

		}
	}

	public static void fileImputStreamEx() {
		try (	//지정된 파일이름을 가진 실제 파일과 연결된 FileInputStream 생성
				FileInputStream fis = new FileInputStream("image.jpg");
				//지정된 파일이름을 가진 실제 파일과 연결된 FileOutputStream 생성
				FileOutputStream fos = new FileOutputStream("test01.jpg")) {
			int data = 0;
			while ((data = fis.read()) != -1) {
//				System.out.println((char) data);
				fos.write(data);
			}
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
