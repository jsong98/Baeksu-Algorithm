package topic.unionFind;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumberOfProvinces {

	public static void main(String[] args) {
//		int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
//		int[][] isConnected = {{1,0,0},{0,1,0},{0,0,1}};
//		int[][] isConnected = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
		int[][] isConnected = {{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},{0,1,0,1,0,0,0,0,0,0,0,0,0,1,0},{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},{0,1,0,1,0,0,0,1,0,0,0,1,0,0,0},{0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},{0,0,0,1,0,0,0,1,1,0,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0,0,0},{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},{0,0,0,1,0,0,0,0,0,0,0,1,0,0,0},{0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1}};
		
		System.out.println(findCircleNum(isConnected));
	}
	
	static int[] arr;
	
	public static int findCircleNum(int[][] isConnected) {
		int len = isConnected[0].length;
		
		arr = new int[len+1];
		for(int i = 1; i < arr.length; i++) {
			arr[i] = i;
		}
		
		for(int i = 0;i < len; i++) {
			for(int j = i+1; j < len; j++) {
				if(isConnected[i][j]==1) {
					if(find(i+1)<find(j+1)) {
						union(find(i+1), find(j+1));
					} else {
						union(find(j+1), find(i+1));
					}
				}
			}
		}
//		System.out.println(Arrays.toString(arr));
		Set<Integer> set = new HashSet<>();
		for(int i = 1; i < arr.length; i++) {
			set.add(arr[i]);
		}
		
		return set.size();
	}
	
	public static int find(int x) {
		if(arr[x] == x) return x;
		return find(arr[x]);
	}
	
	public static void union(int std, int shift) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i]==shift) {
				arr[i] = std;
			}
		}
	}
}
