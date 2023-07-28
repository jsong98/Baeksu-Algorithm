package Junseok.solvedac;

/*
 * baekjoon
 */

import java.util.Scanner;

public class BOJ_10809_알파벳찾기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		for(int i = 97; i < 123; i++) {
			System.out.print(str.indexOf(i));
			System.out.print(" ");
		}
	}
}
