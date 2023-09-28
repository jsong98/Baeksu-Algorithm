package topic.binarySearch;

import java.util.Arrays;

public class KthSmallestElementinaSortedMatrix {

	public static void main(String[] args) {
		int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
		int k = 8;
		
//		int[][] matrix = {{-5}};
//		int k = 1;
		
//		int[][] matrix = {{1,3,5},{6,7,12},{11,14,14}};
//		int k = 3;
		
		System.out.println(kthSmallest(matrix, k));
	}
	
	public static int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;
        int lo = matrix[0][0];
        int hi = matrix[len-1][len-1];
        
        while(lo<=hi) {								// 이진 탐색
        	int count = 0;
        	int mid = lo + (hi - lo)/2;
        	int maxNum = lo;
        	for(int r = 0, c = len-1; r < len; r++) {	// row별로 mid보다 큰 값을 count
        		while(c>=0 && matrix[r][c] > mid) c--;
        		if(c>=0) {
        			count += (c+1);
        			maxNum = Math.max(maxNum, matrix[r][c]);	
        			// count == k인 경우, maxNum을 반환해야 하는데 maxNum이 배열 내 존재하지 않는 값일 수 있음.
        		} else {
        			break;
        		}
        	}
//        	System.out.println(lo + ", " + hi);
//         	System.out.println("count=" + count);
        	if(count==k) return maxNum;
        	else if(count<k) lo = mid +1;
        	else hi = mid -1;
        }
        
        return lo;
	}
	
}
