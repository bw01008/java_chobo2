package java_chobo2_ch15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex15_12 {
	//InputStreamReader / OutputStreamWriter : 바이트기반 스트림을 문자기반 스트림으로 연결시켜주는 역할
	public static void main(String[] args) {
		String line = "";
		
		try{
			//OS에서 사용하는 기본 인코딩의 문자로 변환하는 inputStreamReader를 생성
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			//바이트기반 스트림의 데이터를 지정된 인코딩의 문자데이터로 변환하여 반환
			System.out.println("사용중인 OS의 인코딩 : " + isr.getEncoding());
			
			do {
				System.out.println("문장을 입력하세요. 마치시려면 q를 입력하세요. > ");
				// 사용자의 화면입력을 라인단위로 받는다.
				line = br.readLine();
				System.out.println("입력하신 문장 : " + line);
			}while(!line.equalsIgnoreCase("q"));
			
			System.out.println("프로그램을 종료합니다.");
		}catch(IOException e) {}

	}// end of main

}// end of class
