package week1.Junseok.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Leetcode_MinimumRemoveToMake {

	public static void main(String[] args) {
		String s = "))((";
		Queue<Character> que = new LinkedList<Character>();
		Stack<Character> stCnt = new Stack<>(); 	// '('와 ')'를 카운팅하기 위한 스택
		
		char cnt = '0';					// 스택에 넣을 카운팅 변수
		char[] sArr = s.toCharArray();	// 함수의 파라미터를 char 배열로 변환
		int len = 0;					// 리턴할 String의 길이
		int lCnt = 0;					// 리턴할 String을 만들 때 필요한 '('의 개수를 저장하는 변수
		int rCnt = 0;					
		String result = "";				// 리턴할 String 선언
		
		for(int i = 0; i < sArr.length; i++) {
			if(sArr[i] != '(' && sArr[i] != ')') {	// parentheses가 아닌 경우
				que.offer(sArr[i]);
				len++;
			}
			
			if(sArr[i] == '(') {	// '('인 경우
				que.offer(sArr[i]);
				stCnt.push(cnt);
				len++;
			}
			
			if(sArr[i] == ')' && !stCnt.isEmpty()) {	// ')'인 경우
				que.offer(sArr[i]);
				stCnt.pop();
				len++;
				rCnt++;
			}
		}
		
		for(int j = 0; j < len ; j++) {		// 리턴할 String 조립
			String k = Character.toString(que.poll());
			
			if(k.equals("(") && lCnt < rCnt) {
				result += k;
				lCnt++;
			} else if(k.equals("(") && lCnt >= rCnt) {
				result += "";
			} else {
				result += k;
			}
		}
		
		System.out.println(result);
		
	}

}
