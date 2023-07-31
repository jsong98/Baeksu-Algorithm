package topic.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode_TopKFrequentElements {

	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,3,4,4,4,4};		// 입력
		int k = 2;											// 입력
		int[] result = new int[k];
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < nums.length; i++) {
			if(!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
				continue;
			}
			int freq = map.get(nums[i]) + 1;
			map.replace(nums[i], freq);
			
		}	// for문 종료 시점에, map에는 각 key별로 빈도수 저장.
		
		Integer[] keyArray = new Integer[map.size()];
		Integer[] valueArray = new Integer[map.size()];
		int n = 0;
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			Integer key = entry.getKey();
			Integer value = entry.getValue();
			keyArray[n] = key;
			valueArray[n] = value;
			n++;
		}	// key와 value를 각 Array에 저장.
		
		int length = keyArray.length;
		for (int i = 0; i < length; i++) {  
            for (int j = i + 1; j < length; j++) {  
                int tempKey = 0;
                int tempValue = 0; 
                if (valueArray[i] > valueArray[j]) {

                    tempKey = keyArray[i];
                    keyArray[i] = keyArray[j];
                    keyArray[j] = tempKey;

                    tempValue = valueArray[i];
                    valueArray[i] = valueArray[j];  
                    valueArray[j] = tempValue;
                }  
            }
        }  	// 빈도수별로 각 배열 오름차순 정렬

        for (int i = length-1, j = 0; j < k; i--, j++) {
            result[j] = keyArray[i];
        }
		
        System.out.println(Arrays.toString(result));
		
	}

}
