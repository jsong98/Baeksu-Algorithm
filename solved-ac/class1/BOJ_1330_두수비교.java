package Junseok.solvedac;

// 두 수 비교하기

/*
 * 1 2
 */

import java.util.Scanner;

public class BOJ_1330_두수비교 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		if(A>B) {
			System.out.println(">");
		} else if(A<B) {
			System.out.println("<");
		} else {
			System.out.println("==");
		}
		
	}

}
