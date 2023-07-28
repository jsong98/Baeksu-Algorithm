package Junseok.solvedac;

import java.util.Scanner;

public class BOJ_10250_ACM호텔 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			int p = sc.nextInt();
			int[][] hotel = new int[h][w];
			int floor = 0;
			int th = 0;
			
			if(p % h == 0) {
				floor = h;
				th = p/h;
			} else {
				floor = p % h;
				th = p/h + 1;
			}
			
			System.out.print(floor);
			if(th < 10) {
				System.out.println("0" + th);
			} else {
				System.out.println(th);
			}
			
		}
	}

}
