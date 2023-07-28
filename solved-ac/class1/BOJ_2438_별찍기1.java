package Junseok.solvedac;

// 별찍기-1

/*
 * 5
 */

import java.util.Scanner;

public class BOJ_2438_별찍기1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 1; i <= n; i++) {
			int j = 0;
			while(i != j) {
				System.out.print("*");
				j++;
			}
			System.out.println();
		}
	}

}
