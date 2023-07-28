package Junseok.solvedac;

import java.util.Scanner;

public class BOJ_2920_음계 {

	public static void main(String[] args) {
		int[] arr = new int[8];
		boolean asc = false;
		boolean desc = false;
		boolean mix = false;
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 8; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = 0; i < 7; i++) {
			if(arr[i+1] - arr[i] == 1 ) {
				asc = true;
				desc = false;
				mix = false;
			} else if(arr[i+1] - arr[i] == -1) {
				asc = false;
				desc = true;
				mix = false;
			}
			else {
				asc = false;
				desc = false;
				mix = true;
				break;
			}
		}
		
		if(asc) {
			System.out.println("ascending");
		} else if(desc) {
			System.out.println("descending");
		} else {
			System.out.println("mixed");
		}
	}

}
