package topic.twoPointer;

public class TrappingRainWater {

	public static void main(String[] args) {
//		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
//		int[] height = {4,2,0,3,2,5};
		int[] height = {2,0,2};
		
		System.out.println(trap(height));
	}

	public static int trap(int[] height) {
		int sum = 0;

		int lpt = 0;
		int rpt = height.length-1;
		int leftMax = 0;
		int rightMax = height.length-1;
		
		
		while(lpt < rightMax && rpt > leftMax) {
			System.out.println(lpt + ", " + leftMax + ", " + rpt + ", " + rightMax);
			if(height[leftMax] <= height[rightMax]) {
				sum += height[leftMax]-height[lpt];
				lpt++;
				System.out.println(sum);
				if(height[lpt] > height[leftMax] || height[lpt] > height[rightMax]) {
					leftMax = lpt;
				}
			} else if(height[leftMax] > height[rightMax]) {
				sum += height[rightMax]-height[rpt];
				rpt--;
				if(height[rpt] > height[rightMax] || height[rpt] > height[leftMax]) {
					rightMax = rpt;
				}
			}
			
		}
		
		return sum;
	}

}
