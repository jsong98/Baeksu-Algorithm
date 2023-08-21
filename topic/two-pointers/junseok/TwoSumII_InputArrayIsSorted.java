package topic.twoPointer;

/*
 * 배열 시작에 left pointer, 배열 끝에 right pointer를 두고
 * (lpt+rpt)==target 검사, 더 작으면 lpt++, 크면 rpt++
 * */

public class TwoSumII_InputArrayIsSorted {

	public int[] twoSum(int[] numbers, int target) {
        int lpt = 0;
        int rpt = numbers.length-1;
        while(lpt<rpt) {
            if(numbers[lpt] + numbers[rpt] == target) {
                break;
            } else if(numbers[lpt] + numbers[rpt] < target) {
                lpt++;
            } else {
                rpt--;
            }
        }

        int[] res = new int[2];
        res[0] = lpt+1;
        res[1] = rpt+1;

        return res;
    }

}
