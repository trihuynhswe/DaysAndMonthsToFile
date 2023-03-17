import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class daysNmonthsToFile {
	public static void main(String[] args) throws Exception {
		Scanner scnr = new Scanner(System.in);

		System.out.print("Enter Year: ");
		int year = scnr.nextInt();

		String arr[] = { " ", "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		int days = 0;

		PrintWriter pw = new PrintWriter(new File("daysNmonths.txt"));
		pw.print("YEAR\tMONTH\tDAYS\n");
		pw.print("___________________________\n");

		for (int i = 1; i <= 12; i++) {
			days = getDays(i, year);
			String s = String.format("%5d%12s%6d", year, arr[i], days);
			pw.println(s);
		}
		pw.close();
		scnr.close();
	}

	private static int getDays(int mm, int aYy) {
		int res = -1;
		switch (mm) {
			case 1:
				res = 31;
				break;
			case 2:
				if (isLeap(aYy))
					res = 29;
				else
					res = 28;
				break;
			case 3:
				res = 31;
				break;
			case 4:
				res = 30;
				break;
			case 5:
				res = 31;
				break;
			case 6:
				res = 30;
				break;
			case 7:
				res = 31;
				break;
			case 8:
				res = 31;
				break;
			case 9:
				res = 30;
				break;
			case 10:
				res = 31;
				break;
			case 11:
				res = 30;
				break;
			case 12:
				res = 31;
				break;
		}

		return res;
	}

	private static boolean isLeap(int year) {
		boolean leap = false;

		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0)
					leap = true;
				else
					leap = false;
			} else
				leap = true;
		} else
			leap = false;
		return leap;
	}
}
