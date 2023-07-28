package solvedac.class2;

import java.util.Scanner;

public class BOJ_1676_팩토리얼0의개수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int d2 = 0;
		int d5 = 0;
		int result = 0;
		
		for(int i = 1; i <= n; i++) {
			int temp2 = i;
			while(temp2 % 2 == 0) {
				temp2 = temp2/2;
				d2++;
			}
			
			int temp5 = i;
			while(temp5 % 5 == 0) {
				temp5 = temp5/5;
				d5++;
			}
		}
		
		if(d5 > 0 || d2 > d5) {
			result = d5;
		} else if(d5 > 0 || d2 < d5){
			result = d2;
		}
		
		System.out.println(result);
	}

}
