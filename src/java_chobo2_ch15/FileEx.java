package java_chobo2_ch15;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

public class FileEx {

	public static void main(String[] args) throws IOException {
		
		
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
		
		System.out.println("user.dir - " + System.getProperty("user.dir"));
		System.out.println("sun.boot.class.path - " + System.getProperty("sun.boot.class.path"));
	}

	public static File getSearchFile() {
		JFileChooser jfc = new JFileChooser(System.getProperty("user.dir"));
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);	//파일선택모드를 파일과 디렉토리 모두 되도록 설정
		int res = jfc.showOpenDialog(null);
		File file = null;
		if(res == JFileChooser.APPROVE_OPTION) {
			file = jfc.getSelectedFile();
			System.out.println(file.getAbsolutePath());
		}
		return file;
	}

}
