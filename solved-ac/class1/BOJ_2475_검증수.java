package Junseok.solvedac;

// 검증 수

/*
 * 0 4 2 5 6
 */

import java.util.Scanner;

public class BOJ_2475_검증수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		
		for(int i = 0; i < 5; i++) {
			arr[i] = sc.nextInt();
		}
		
		int sum = 0;
		for(int i = 0; i < 5; i++) {
			sum += Math.pow(arr[i], 2);
		}
		
		int result = sum % 10;
		
		System.out.println(result);
	}

}
