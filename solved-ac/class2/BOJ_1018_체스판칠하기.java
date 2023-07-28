package Junseok.solvedac;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1018_체스판칠하기 {

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		String[] c = new String[n];
		for (int i = 0; i < n; i++) {
			c[i] = sc.next();
		}
		String[][] board = new String[n][m];

		// n * m 2차원 배열에 입력값 저장.
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = c[i].split("")[j];
			}
		}

		int min = Integer.MAX_VALUE;
		int cnt1 = 0;
		int cnt2 = 1;
		for (int pt1 = 0; pt1 < n - 7; pt1++) {
			for (int pt2 = 0; pt2 < m - 7; pt2++) {

				cnt1 = 0;
				cnt2 = 1;
				int cnt3 = 0;
				int cnt4 = 0;
				
				for (int pt3 = 0; pt3 < 8; pt3++) {
					for (int pt4 = 0; pt4 < 8; pt4++) {
						if ((pt3 + pt4) > 0) {
							if (((pt3 + pt4) % 2) == 1) {
								if (board[pt1][pt2].equals(board[pt1 + pt3][pt2 + pt4])) {
									cnt3++;
									System.out.println("same" + pt1 + pt2 + pt3 + pt4 +board[pt1][pt2] + board[pt1 + pt3][pt2 + pt4]);
								}
							} else {
								if (!board[pt1][pt2].equals(board[pt1 + pt3][pt2 + pt4])) {
									cnt4++;
									System.out.println("diff"+ pt1 + pt2 + pt3 + pt4 + board[pt1][pt2] + board[pt1 + pt3][pt2 + pt4]);
								}
							}

						}
					}
				}
				

				if(board[pt1][pt2].equals("W")) {
					board[pt1][pt2] = "B";
				} else {
					board[pt1][pt2] = "W";
				}
				
				for (int pt3 = 0; pt3 < 8; pt3++) {
					for (int pt4 = 0; pt4 < 8; pt4++) {
						if ((pt3 + pt4) > 0) {
							if ((pt3 + pt4) % 2 == 0) {
								if (!board[pt1][pt2].equals(board[pt1 + pt3][pt2 + pt4])) {
									cnt2++;
								}
							} else {
								if (board[pt1][pt2].equals(board[pt1 + pt3][pt2 + pt4])) {
									cnt2++;
								}
							}

						}
					}
				}
				
				if(board[pt1][pt2].equals("W")) {
					board[pt1][pt2] = "B";
				} else {
					board[pt1][pt2] = "W";
				}
				
//				System.out.println(cnt1 + ", " + cnt2);
				
//				if(cnt < min) {
//					min = cnt;
//				}
//				System.out.println(cnt);
			}
		}

//		System.out.println(min);
	}
}
