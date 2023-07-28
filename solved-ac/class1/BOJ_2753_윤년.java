package Junseok.solvedac;

import java.util.Scanner;

/*
 * 1999
 */

public class BOJ_2753_윤년 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		boolean isYoon = false;
		if(year % 4 == 0) {
			isYoon = true;
			if(year % 100 == 0) {
				isYoon = false;
				if(year % 400 == 0) {
					isYoon = true;
				}
			}
		}
		if(isYoon) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

}
