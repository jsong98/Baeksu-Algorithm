package topic.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// Kadane's algo, DP

public class MaximumSubarray {

	public static void main(String[] args) {
//		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//		int[] nums = {5,4,-1,7,8};
		int[] nums = { 8, -2, -4, -1, -8, 3, 8, 8, 3, 4, 2, -9, -1, -3, -6, 8, -3, 9 };

		System.out.println(maxSubArray(nums));
	}

	public static int maxSubArray(int[] nums) {
		int sum = 0;
		// 특정 index까지의 sum을 저장, 해당 index까지의 합이 0보다 작아지는 순간 0으로 다시 초기화
		// cuz 0보다 작아지는 순간 그 index까지 더한건 다 버려도 상관 없음.
		int max = Integer.MIN_VALUE;
		// 특정 index까지의 sum의 최대값을 저장.
		
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
			max = Math.max(sum, max);
			
			if(sum < 0) sum = 0;
		}
		/*
		for문 진행
		sum : 
		max :
		
		*/
		
		return max;
	}
	
//	public static int maxSubArray(int[] nums) {
//		if(nums.length == 1) return nums[0];
//		
//		ArrayList<Integer> maxArr = getMaxValIdx(nums);
//		ArrayList<Integer> res = new ArrayList<>();
//		
//		for(int recur = 0; recur < maxArr.size(); recur++) {
//			int sum = 0;
//			int maxIdx = maxArr.get(recur);		// nums 내 최고값의 idx를 순차적으로 받음.
//			int[] temp = new int[nums.length];	// 임시 배열
//			
//			for(int lpt = maxIdx-1; lpt >= 0; lpt--) {	// 왼쪽으로 누적합
//				temp[lpt] = temp[lpt+1] + nums[lpt];
//			}
//			for(int rpt = maxIdx+1; rpt < nums.length; rpt++) {		// 오른쪽으로 누적합
//				temp[rpt] = temp[rpt-1] + nums[rpt];
//			}
//			System.out.println(Arrays.toString(temp));
//			int leftTempMax = Integer.MIN_VALUE;
//			for(int i = 0; i <= maxIdx; i++) {	// maxIdx를 기준으로 왼쪽 누적합 중에 최대값
//				if(temp[i] >= leftTempMax) {
//					leftTempMax = temp[i];
//				}
//			}
//			int rightTempMax = Integer.MIN_VALUE;
//			for(int i = maxIdx; i < nums.length; i++) {		// maxIdx를 기준으로 오른쪽 누적합 중에 최대값
//				if(temp[i] >= rightTempMax) {
//					rightTempMax = temp[i];
//				}
//			}
//			leftTempMax = (leftTempMax > 0) ? leftTempMax : 0;
//			rightTempMax = (rightTempMax > 0) ? rightTempMax : 0;
//			
//			sum = nums[maxIdx] + leftTempMax + rightTempMax;
//			res.add(sum);
//		}
//		Collections.sort(res);
//		
//		return res.get(res.size()-1);
//	}
//	
//	public static ArrayList<Integer> getMaxValIdx(int[] nums) {
//		ArrayList<Integer> maxArr = new ArrayList<>();
//		int max = Integer.MIN_VALUE;
//		
//		for(int i = 0; i < nums.length; i++) {
//			if(nums[i] > max) {
//				max = nums[i];
//			}
//		}
//		for(int i = 0; i < nums.length; i++) {
//			if(nums[i] == max) {
//				maxArr.add(i);
//			}
//		}
//		
//		return maxArr;
//	}
}
