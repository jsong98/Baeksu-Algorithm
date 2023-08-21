package topic.greedy;

public class JumpGame {

	public static void main(String[] args) {
//		int[] nums = {2,3,1,1,4};
//		int[] nums = {3,2,1,0,4};
		int[] nums = {0};
		
		System.out.println(canJump(nums));
	}
	
	// 배열의 Last index -1부터 점점 index 줄여가면서 탐색
	// 해당 index에서 Last index까지 도달할 수 있는지를 greedy하게 탐색
	public static boolean canJump(int[] nums) {
		if(nums.length==1) return true;
		
		int len = nums.length-1;
		int posPt = len; 			
		// 각 index에서 목표 index까지의 거리를 저장하는 변수, 처음은 nums의 길이로 초기화
		boolean[] posIdx = new boolean[nums.length];
		// 배열의 각 idx에서 Last index까지 도달할 수 있는지 여부를 저장
		
		for(int i = len-1; i >= 0; i--) {
			if(i + nums[i] >= posPt) {
				posIdx[i] = true;
				posPt = i;
			}
		}
		
		
		return posIdx[0];
	}
}
