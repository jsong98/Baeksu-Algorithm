package Junseok.solvedac;

import java.util.Scanner;

public class BOJ_11720_숫자의합 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] arr = sc.next().split("");
		int sum = 0;
		for(int i = 0; i < n; i++) {
			sum += Integer.parseInt(arr[i]);
		}
		
		System.out.println(sum);
	}
}
