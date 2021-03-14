package java_chobo2_ch15;

import java.io.File;

import javax.swing.JFileChooser;

public class FileEx2 {

	public static void main(String[] args) {
		File f = getSearchFile();	//선택한 파일 혹은 디렉토리의 경로를 검색하는 메소드 호출, 반환받은 파일의 주소값을 저장

		if (!f.exists() || !f.isDirectory()) {	//선택된 파일이 존재하지 않거나, 디렉토리가 아니라면(= 파일이라면)
			System.err.println("유효하지 않은 디렉터리입니다.");	
			System.exit(0);	//종료
		}

		File[] files = f.listFiles();	//선택된것이 파일이 아니라 디렉토리라면 그 디렉토리 안의 파일목록(디렉토리포함)을 File배열로 반환

		for (File file : files) {	//배열 안에 요소 하나씩 꺼내기 
			//디렉토리라면 []안에 디렉토리이름으로 출력, 파일이라면 그냥 파일 이름 출력
			System.out.println(file.isDirectory() ? "[" + file.getName() + "]" : file.getName());	//삼항 연산자
		}

	}

	public static File getSearchFile() {
		JFileChooser jfc = new JFileChooser(System.getProperty("user.dir"));
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // 파일선택모드를 파일과 디렉토리 모두 되도록 설정
		int res = jfc.showOpenDialog(null);	// 팝업창을 띄워서 파일 혹은 디렉토리를 선택 후 approve가 되면 0을, cancel이 되면 1을 반환한다.
		File file = null;	//선언 및 초기화 > 리턴해주려면 지역변수여선 안된다.
		if (res == JFileChooser.APPROVE_OPTION) {	//APPROVE_OPTION은 상수로 0이 지정되어 있다. > 0이면(approve) if문 실행
			file = jfc.getSelectedFile();	//선택된 파일/디렉토리를 가져와서 변수에 저장
			System.out.println(file.getAbsolutePath());	// 파일/디렉토리의 절대경로를 찍는다.
		}
		return file;	//선택된 파일/디렉토리를 반환
	}

}
