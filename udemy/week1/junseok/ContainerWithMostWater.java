package udemy.arrays;

public class ContainerWithMostWater {
	
	// Two Pointer
	// maxContainer를 만들기 위해서는 결국 두 높이 중에 작은 값을 너비에 곱해야 함
	// --> 두 인덱스 중 height가 작은 쪽을 이동
	public int maxArea(int[] height) {
		int l = 0;
		int r = height.length-1;
		int area = (r-l) * Math.min(height[l], height[r]);
		
		while (l < r) {
			if (height[l] <= height[r]) {
				l++;
			} else {
				r--;
			}

			int curr = (r - l) * (Math.min(height[l], height[r]));
			if (curr > area) {
				area = curr;
			}
		}
		
		return area;
	}
}
