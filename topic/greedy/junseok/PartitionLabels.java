package topic.greedy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PartitionLabels {

	public static void main(String[] args) {
		String s = "qiejxqfnqceocmy";
		
		System.out.println(partitionLabels(s).toString());
		
	}
	
	// rpt를 재귀적으로 찾기
	public static List<Integer> partitionLabels(String s) {
		List<Integer> res = new ArrayList<Integer>();
		HashSet<Character> set = new HashSet<>();
		
		char[] arr = s.toCharArray();
		
		int i = 0;
		while(i<arr.length) {
			char target = arr[i];
			if(!set.contains(target)) {
				set.add(target);
				for(int j = arr.length-1; j >= i; j--) {
					if(arr[j] == target) {
						int rpt = findRpt(arr, i, j);
						res.add(rpt-i+1);
						i = rpt+1;
					}
				}
			} else {
				i++;
			}
		}
		
		return res;
	}
	
	public static int findRpt(char[] arr, int i, int j) {
		HashSet<Character> set = new HashSet<>();
		int rpt = j;
		
		for(int k = i+1; k <= j-1; k++) {
			if(!set.contains(arr[k])) {
				set.add(arr[k]);
				for(int o = arr.length-1;o>=j+1;o--) {
					if(arr[o] == arr[k] && o>rpt) {
						rpt = findRpt(arr, k, o);
						break;
					}
				}
			}
		}
		
		return rpt;
	}

}
