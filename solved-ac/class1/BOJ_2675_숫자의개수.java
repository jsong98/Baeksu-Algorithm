package Junseok.solvedac;

// 문자열 반복

/*
2
3 ABC
5 /HTP
 */

import java.util.Scanner;

public class BOJ_2675_숫자의개수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int iter = sc.nextInt();
			String str = sc.next();
			
			char[] arr = str.toCharArray();
			
			for(int i = 0; i < arr.length; i++) {
				for(int j = 0; j < iter; j++) {
					System.out.print(arr[i]);
				}
			}
			System.out.println();
		}
	}

}
