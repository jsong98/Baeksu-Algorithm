package Junseok.solvedac;

// 단어의 개수

/*
 * The Curious Case of Benjamin Button
 */

import java.util.Scanner;

public class BOJ_1152_단어의개수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String strTrim = str.trim();
		if(strTrim.equals(" ") || strTrim.equals("")) {
			System.out.println(0);
		} else {
			System.out.println(strTrim.split(" ").length);
		}
	}
}
