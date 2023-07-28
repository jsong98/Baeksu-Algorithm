package Junseok.solvedac;

// 최댓값

/*
3
29
38
12
57
74
40
85
61
 */

import java.util.Scanner;

public class BOJ_2562_HelloWorld {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		int max = Integer.MIN_VALUE;
		int maxIdx = 0;
		for(int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int j = 0; j < 9; j++) {
			if(arr[j] > max) {
				max = arr[j];
				maxIdx = j;
			}
		}
		
		System.out.println(max);
		System.out.println(maxIdx + 1);
	}

}
