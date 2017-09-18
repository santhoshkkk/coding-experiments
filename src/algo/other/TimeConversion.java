package algo.other;

import java.util.Scanner;

public class TimeConversion {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		String result = timeConversion(s);
		System.out.println(result);
		in.close();
	}

	static String timeConversion(String s) {
		String sHour = s.substring(0, 2);
		String amPm = s.substring(8);
		int finalHour = 0;
		String converted = s;
		int iHour = Integer.parseInt(sHour);
		if ("PM".equals(amPm)) {
			if(12== iHour){
                finalHour=12;
            }else{
			finalHour = iHour + 12;
            }
			converted = finalHour + s.substring(2, 8);
		} else {
			if (12 == iHour) {
				converted = "00" + s.substring(2, 8);
			}
		}

		return converted;
	}

}
