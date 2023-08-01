package udemy.arrays;

public class TrappingRainWater {
	
	// BruteForce
	// 배열 내 모든 index에 대해 각각 pointer l과 r을 배열의 끝과 끝으로 보내고
	// max_l과 max_r에 그 사이에 존재하는 최대값에 할당
	// 그리고 max_l과 max_r 중 최소값에서 curr_height를 뺌으로써
	// 해당 index에 저장되는 물의 양을 측정.
	public static int trapping_water(int[] height) {
	    int total = 0;
	    for(int i = 0 ; i < height.length ; i++) {
	        int max_l = 0;
	        int max_r = 0;
	        int l = i;
	        int r = i;
	        int curr_height = height[i];
	        while(r < height.length) {
	            if(height[r] > max_r) {
	                max_r = height[r];
	            }
	            r++;
	        }
	        while(l>=0) {
	            if(height[l] > max_l) {
	                max_l = height[l];
	            }
	            l--;
	        }
	        
	        int water_level = (Math.min(max_r, max_l) - curr_height);
	        if(water_level > 0) {
	            total = total + water_level;
	        }
	    }
	    
	    return total;
	}
	
	// Two Pointer
	// l은 배열의 시작, r은 배열의 끝에서 시작.
	// max_l은 l이 멈춘 부분의 높이, max_r은 r이 멈춘 부분의 높이
	// max_l이 max_r보다 작은 경우, max_l에 해당하는 index가 이동해서 max_r보다 큰  value를 만날때,
	// 그 이전까지 지나온 index들에는 container가 생성되는 것이 보장됨!
	public static int trapping_water2(int[] height){
	    int l = 0;
	    int r = height.length - 1;
	    int total = 0;
	    int max_l = height[l] , max_r = height[r];
	    
	    while (l<r) {
	        if(height[l]<= height[r]){
	            
	            if(height[l]>max_l) {
	                max_l = height[l];
	            } else {
	                int curr = max_l -  height[l];
	                total = total + curr;
	            }
	            l++;
	        } else {
	            if (height[r]>max_r) {
	                max_r = height[r];
	            } else {
	                int curr = max_r - height[r];
	                total = total + curr;
	            }
	            r--;
	        }
	    }
	    
	    return total;
	}
}
