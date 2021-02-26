package java_chobo2_ch16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class URLConnectionEx {

	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("https://news.naver.com/main/read.nhn?mode=LSD&mid=shm&sid1=101&oid=056&aid=0010997137");

		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(url.openStream()));
				BufferedWriter bw = new BufferedWriter(
						new OutputStreamWriter(
								new FileOutputStream("test.html")))) {
			String line = null;

			while ((line = br.readLine()) != null) {
				System.out.println(line);
				bw.write(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
