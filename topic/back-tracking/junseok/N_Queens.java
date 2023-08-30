package topic.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_Queens {

	public static void main(String[] args) {
		int n = 4;
		solveNQueens(8);
	}

	static List<List<String>> res;
	
	public static List<List<String>> solveNQueens(int n) {
		res = new ArrayList<List<String>>();
		int[] arr = new int[n];
		Arrays.fill(arr, -1);
		nQueens(arr, 0);
		
//		for(List<String> test : res) {
//			System.out.println(test.toString());
//		}
//		System.out.println(res.size());
		return res;
	}

	public static void nQueens(int[] arr, int idx) {
		if(idx==arr.length) {
			List<String> temp = new ArrayList<>();
			for(int i = 0; i < arr.length; i++) {
				String s = "";
				for(int j = 0; j < arr.length; j++) {
					if(arr[i] == j) {
						s += "Q";
					} else {
						s += ".";
					}
				}
				temp.add(s);
			}
			res.add(temp);
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (check(arr, idx, i)) {
				arr[idx] = i;
//				System.out.println(Arrays.toString(arr) + " " + idx + " " + i);
				nQueens(arr, idx+1);
			}
		}
	}

	// target == 들어갈 숫자 == column, idx == 들어갈 위치 == row
	public static boolean check(int[] arr, int idx, int target) {
		if(idx == 0) {
			for(int i = 1; i < arr.length; i++) {
				arr[i] = -1;
			}
			return true;
		}
		for(int i = 0; i < idx; i++) {
			if(arr[i]==target) return false;
			if(Math.abs(i-idx) == Math.abs(target-arr[i])) return false;
		}
		
		return true;
	}
}
