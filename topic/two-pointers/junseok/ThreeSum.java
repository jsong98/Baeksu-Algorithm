package topic.twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
 * 배열 내 중복된 원소가 없기 때문에
 * 배열 내 특정 원소와 또다른 두 원소를 골랐을 때 0이 되는 경우가 한정
 * 배열을 for문으로 처음부터 순회하면서 left pointer를 for문의 index+1
 * right pointer를 배열의 끝에 두고 셋의 합이 0인지 검사
 * */

public class ThreeSum {
	
	public static void main(String[] args) {
		int[] nums = {-1,0,1,2,-1,-4};
//		int[] nums = {0,0,0};
//		int[] nums = {1,-1,-1,0};
		
		System.out.println(threeSum(nums).isEmpty());
	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashSet<List<Integer>> listSet = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++) {
        	int st = i+1;
        	int ed = nums.length-1;
        	while(st<ed) {
        		List<Integer> trip = new ArrayList<>();
//        		System.out.println(nums[i] + ", " + nums[st] + ", " + nums[ed]);
        		if(nums[i]+nums[st]+nums[ed] < 0) {
        			st++;
        		} else if(nums[i]+nums[st]+nums[ed] > 0) {
        			ed--;
        		} else {
//        			System.out.println("chk");
        			trip.add(nums[i]);
        			trip.add(nums[st]);
        			trip.add(nums[ed]);
        			if(!listSet.contains(trip)) {
        				listSet.add(trip);
        				result.add(trip);
        			}
        			st++;
        		}
        	}
        }
        
        return result;
    }
}
