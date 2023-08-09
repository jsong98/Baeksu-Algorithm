package udemy.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	// BruteForce with double for loop
	public static int[] sum(int[] nums , int target) {
	    int[] ans = new int[2];
	    if(nums.length < 2) return null;
	    
	    for (int i = 0; i < nums.length; i++) {
	        for(int j = i+1 ; j< nums.length ; j++) {
	            if(nums[i] + nums[j] == target) {
	                ans[0] = i;
	                ans[1] = j;
	                return ans;
	            }
	        }
	    }
	    return null;
	}
	
	// Optimal Solution with HashMap
	public static int[] sum2(int[] nums, int target) {
	    if(nums.length < 2) return null;
	    int[] ans = new int[2];
	    
	    Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	    for(int i = 0 ; i < nums.length ; i++) {
	        if(map.containsKey(target - nums[i])) {
	            ans[0] = map.get(target - nums[i]);
	            ans[1] = i;
	            return ans;
	        } else {
	            map.put(nums[i],i);
	        }
	    }
	    return null;
	}
}
