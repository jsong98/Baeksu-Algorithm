package Junseok.solvedac;

import java.util.Scanner;

/*
 * 2
 */

public class BOJ_2739_구구단 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 1; i <= 9; i++) {
			System.out.println(n + " * " + i + " = " + n*i);
		}
	}

}
