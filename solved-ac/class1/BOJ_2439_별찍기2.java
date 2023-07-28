package Junseok.solvedac;

// 별찍기-2

/*
 * 5
 */

import java.util.Scanner;

public class BOJ_2439_별찍기2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j < n - i; j++) {
				System.out.print(" ");
			}
			for(int k = n-i; k < n; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
