package topic.binarySearch;

import java.util.Arrays;

public class FindFirstandLastPositionofElementinSortedArray {

	public static void main(String[] args) {
		int[] nums = {5,7,7,8,8,10};
		int target = 8;
		
//		int[] nums = {5,7,7,8,8,10};
//		int target = 6;
		
//		int[] nums = {};
//		int target = 0;
		
		System.out.println(Arrays.toString(searchRange(nums, target)));
	}
	
	public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int start = 0;
        int end = nums.length - 1;
        int mid = (start + end)/2;
        
        while(start<=end) {					// 이진탐색, target찾기
        	if(target==nums[mid]) {
        		break;
        	} else if(target>nums[mid]) {
        		start = mid+1;
        	} else {
        		end = mid-1;
        	}
        	mid = (start+end)/2;
        }									// mid == target
        
        if(start>end) {
        	return res;
        }
        
        int temp = mid;
        
        while(nums[mid]==target) {		// nums 배열 내 mid의 index로부터 왼쪽으로 이동해서 값이 target인 마지막 index 찾기
        	mid--;
        	if(mid<0) {
        		break;
        	}
        }
        mid++;
        res[0] = mid;
        
        mid = temp;
        while(nums[mid]==target) {		// nums 배열 내 mid의 index로부터 오른쪽으로 이동해서 값이 target인 마지막 index 찾기
        	mid++;
        	if(mid>nums.length-1) {
        		break;
        	}
        }
        mid--;
        res[1] = mid;
        
        return res;
    }
}
