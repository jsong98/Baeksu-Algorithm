package solvedac.class2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_1259_팰린드롬수 {

	public static void main(String[] args) {
		Stack<Character> st = new Stack<>();
		Scanner sc = new Scanner(System.in);
		
		int num = 1;
		
		while(num != 0) {
			num = sc.nextInt();
			
			if(num == 0) {
				break;
			}
			
			boolean isPalin = false;
			char[] arr = String.valueOf(num).toCharArray();
			
			if(arr.length%2 == 0) {
				for(int i = 0; i < arr.length/2; i++) {
					st.push(arr[i]);
				}
				for(int j = arr.length/2; j < arr.length; j++) {
					if(arr[j] != st.pop()) {
						isPalin = false;
						break;
					} else {
						isPalin = true;
					}
				}
			} else if(arr.length == 1) {
				isPalin = true;
			} else {
				for(int i = 0; i < arr.length/2; i++) {
					st.push(arr[i]);
				}
				for(int j = arr.length/2+1; j < arr.length; j++) {
					if(arr[j] != st.pop()) {
						isPalin = false;
						break;
					} else {
						isPalin = true;
					}
				}
			}
			
			if(isPalin) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
		

	}

}
