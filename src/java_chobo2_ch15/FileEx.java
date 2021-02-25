package java_chobo2_ch15;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

public class FileEx {

	public static void main(String[] args) throws IOException {
		
		//지정된 uri로 파일을 생성
//		File file = new File("C:\\workspace_java\\native_jdbc_programming\\src\\native_jdbc_programming\\dto\\Department.java");
		File file = getSearchFile();
		String fileName = file.getName();
		System.out.println("경로를 제외한 파일 이름 : " + fileName);
		
		int idx = fileName.lastIndexOf(".");
		System.out.println("확장자를 제외한 파일 이름 : " + fileName.substring(0, idx));
		System.out.println("확장자 : " + fileName.substring(idx+1));
		
		System.out.println("경로를 포함한 파일이름 - " + file.getPath());
		System.out.println("파일의 절대경로 : " + file.getAbsolutePath());
		System.out.println("파일의 정규경로 : " + file.getCanonicalPath());
		System.out.println("파일이 속해있는 디렉토리 - " + file.getParent());
		System.out.println();
		
		System.out.println("File.pathSeparator - " + File.pathSeparator);
		System.out.println("File.pathSeparatorChar - " + File.pathSeparatorChar);
		System.out.println("File.separator - " + File.separator);
		System.out.println("File.separatorChar - " + File.separatorChar);
		System.out.println();
							//현재 프로그램의 실행중인 디렉토리를 알 수 있다.
		System.out.println("user.dir - " + System.getProperty("user.dir"));
		System.out.println("sun.boot.class.path - " + System.getProperty("sun.boot.class.path"));
	}

	public static File getSearchFile() {
		JFileChooser jfc = new JFileChooser(System.getProperty("user.dir"));	//현재 실행중인 디렉토리의
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);	//파일선택모드를 파일과 디렉토리 모두 되도록 설정
		int res = jfc.showOpenDialog(null); //Open File팝업창을 띄운다. 파일 혹은 디렉토리를 선택 후 approve가 되면 0을, cancel이 되면 1을 반환한다.
		File file = null;	//선언 및 초기화
		if(res == JFileChooser.APPROVE_OPTION) { // 상수 0로 선언되어있다. > res가 0이면 승인이기때문에 if문이 실행된다.
			file = jfc.getSelectedFile();	//지정된 파일/디렉토리의 객체를 가져와서 변수 file에 담는다.
			System.out.println(file.getAbsolutePath());
		}
		return file;	//지정된 파일/디렉토리 반환
	}

}
