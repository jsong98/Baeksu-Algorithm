package topic.unionFind;

import java.util.Arrays;

public class LongestConsecutiveSequence {
	
	public static void main(String[] args) {
//		int[] nums = {100,4,200,1,3,2};
//		int[] nums = {0,3,7,2,5,8,4,6,0,1};
//		int[] nums = {9,1,4,7,3,-1,0,5,8,-1,6};
		int[] nums = {1,2,0,1};
		
		System.out.println(longestConsecutive(nums));
	}
	
	
	public static int longestConsecutive(int[] nums) {
		if(nums.length==1) return 1;
		if(nums.length==0) return 0;
		
		Arrays.sort(nums);
		int sum = 0;
		int temp = 1;
		for(int i = 0; i < nums.length-1; i++) {
			if(nums[i+1]-nums[i]==1) {
				temp++;
			} else if(nums[i+1]-nums[i]==0){
				
			} else {
				sum = Math.max(sum, temp);
				temp = 1;
			}
			
			if(i == nums.length-2) {
				sum = Math.max(sum, temp);
			}
		}

		return sum;
	}

}
