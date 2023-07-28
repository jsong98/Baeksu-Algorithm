package Junseok.solvedac;

import java.util.Scanner;

public class BOJ_3052_나머지 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] in = new int[10];
		for(int i = 0; i < 10; i++) {
			in[i] = sc.nextInt();
		}
		
		int cnt = 0;
		int[] cmp = new int[42];
		
		for(int i = 0; i < 10; i++) {
			if(cmp[in[i]%42] == 0) {
				cmp[in[i]%42]++;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
