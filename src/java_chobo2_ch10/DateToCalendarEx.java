package java_chobo2_ch10;

import java.util.Calendar;
import java.util.Date;

public class DateToCalendarEx {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();		//Calendar은 추상클래스 > 객체생성불가, 클래스 인스턴스호출
		cal.clear();	// 캘린더 클리어
		cal.set(2020, 0, 1); //새로 세팅하기
		System.out.println(cal);
		System.out.println(cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DATE));
		
		Date d = new Date();
		d.setYear(19);	
		d.setMonth(0);
		d.setDate(1);
		System.out.println(d);		//Tue Feb 16 09:23:30 KST 2021 출력
		System.out.printf("%tF %n", d);		//형식지정자 2021-02-16 출력
		
		convCalToDate(cal);
		convDateToCal(d);

	}

	private static void convCalToDate(Calendar cal) {
		System.out.println("convCalToDate()");
		Date d = new Date(cal.getTimeInMillis());
		System.out.printf("%tF %n", d);
	}

	private static void convDateToCal(Date d) {
		System.out.println("convDateToCal");
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		System.out.println(cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DATE));	// 년만 출력
	}

}
