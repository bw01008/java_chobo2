package java_chobo2_ch11;

import java.util.HashMap;
import java.util.Scanner;

public class Ex11_16 {

	public static void main(String[] args) {
		HashMap map = new HashMap();
		
		map.put("myId", "1234");
		map.put("asdf", "1111");
		map.put("asdf", "1234");
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("아이디와 비밀번호를 입력해주세요. ");
			System.out.println("id > ");
			String id = sc.nextLine().trim();
			
			System.out.println("password > ");
			String pw = sc.nextLine().trim();
			
			if(!map.containsKey(id)) {
				System.out.println("입력하신 아이디는 존재하지 않습니다. 다시 입력해주세요.");
				continue;
			}
			
			if(!(map.get(id)).equals(pw)) {
				System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요");
			}else {
				System.out.println("로그인에 성공했습니다.");
				break;
			}
			
		}

	}//end of main

}// end of class
