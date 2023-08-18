package topic.parametricSearch;

/*
 * https://www.acmicpc.net/problem/2110
 * https://st-lab.tistory.com/277
 * https://st-lab.tistory.com/267
 * */

public class SplitArrayLargestSum {

	public static void main(String[] args) {
		int[] nums = {7,2,5,10,8};
		int k = 3;
		
		System.out.println(splitArray(nums, k));
	}

	public static int splitArray(int[] nums, int m) {
        int low = 0, high = 0;
        
        for (int n: nums) {
        // 정답의 범위 : 배열 내 max ~ 배열 내 원소의 총합 ==> Binary Search !!!
            low = Math.max(low, n);
            high += n;
        }
        
        while (low < high) {
        	System.out.println("hi : " + high + ", lo : " + low);
            int mid = low + (high - low) / 2;
            if (check(nums, m, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    
    // mid보다 작거나 같은 총합을 갖는 m개의 subArray로 나눌 수 있는지 검사
    private static boolean check(int[] nums, int m, int mid) {
    	System.out.println("mid : " + mid);
        int sum = 0;
        int numOfSubArrays = 1;
        
        for (int i = 0; i < nums.length; i ++) {
            sum += nums[i];
            if (sum > mid) {	// subArray의 총합이 mid보다 커지면
            	numOfSubArrays++;	// numOfSubArray의 값++
                sum = nums[i];		// 해당 nums[i]부터 다시 검사
            }
        }
        
        return numOfSubArrays <= m;
    }
}
