package Junseok.solvedac;

// 숫자의 개수

/*
150
266
427
 */

import java.util.Scanner;

public class BOJ_2577_최댓값 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		char[] m = String.valueOf(A*B*C).toCharArray();
		char[] arr = new char[10];
		int[] cnt = new int[10];
		
		for(int i = 0; i < 10; i++) {
			arr[i] = (char)(i + '0');
		}
		
		for(int j = 0; j < m.length; j++) {
			for(int k = 0; k < 10; k++) {
				if(m[j] == arr[k]) {
					cnt[k]++;
				}
			}
		}
		
		for(int l = 0; l < 10; l++) {
			System.out.println(cnt[l]);
		}
		
		
	}

}
