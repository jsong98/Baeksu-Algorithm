package solvedac.class2;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_1436_영화감독숌 {
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			int start = 666;
			while(arr.size() != n) {
				if(String.valueOf(start).contains("666")) {
					arr.add(start);
				}
				start++;
			}
		}
		System.out.println(arr.get(n-1));
	}
}
