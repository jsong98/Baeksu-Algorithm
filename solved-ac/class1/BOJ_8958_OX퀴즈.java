package Junseok.solvedac;

import java.util.Scanner;

public class BOJ_8958_OX퀴즈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 1; i <= T; i++) {
			char[] quiz = sc.next().toCharArray();
			int result = 0;
			int cnt = 0;
			for(int j = 0; j < quiz.length; j++) {
				if(quiz[j] == 'O') {
					cnt++;
					result += cnt;
				} else {
					cnt = 0;
				}
			}
			System.out.println(result);
			
		}
	}

}
