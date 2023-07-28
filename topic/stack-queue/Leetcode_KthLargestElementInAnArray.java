package week1.Junseok.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Leetcode_KthLargestElementInAnArray {

	public static void main(String[] args) {
		// 내림차순 정렬
//		Integer[] intArr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
//		Arrays.sort(intArr, Comparator.reverseOrder());
		
		int[] nums = {3,2,3,1,-1,2,-2,4,5,5,6};
		int k = 4;
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < nums.length; i++) {	// 배열 내 최대값, 최소값 구하기
			if(nums[i] > max) {
				max = nums[i];
			}
			if(nums[i] < min) {
				min = nums[i];
			}
		}
		
		int[] arr = new int[max - min + 1];		// 배열 내 숫자들의 개수 저장, 오름차순으로.
		int[] fix = new int[max - min + 1];		// 중복제거 및 정열된 배열 상태 저장.
		
		for(int j = 0; j < nums.length; j++) {
			arr[nums[j]-min]++;
			fix[nums[j]-min] = nums[j];
		}
		
		int idx = arr.length-1;			// k번째로 큰 수를 구하기 때문에 arr 배열의 마지막 idx부터 시작.
		int std = 0;					// 이 변수가 k와 같거나, k보다 커지는 순간 그 idx에 해당하는 수가 결과값
		int result = 0;					// 리턴 값을 저장할 변수
		
		while(std < k) {
			std += arr[idx];
			idx--;
		}
		result = fix[idx+1];
		
		System.out.println(result);
	}

}
