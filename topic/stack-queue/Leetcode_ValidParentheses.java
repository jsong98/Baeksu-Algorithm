package week1.Junseok.leetcode;

import java.util.Stack;

public class Leetcode_ValidParentheses {

	public static void main(String[] args) {
		String s = "[([]])";
		char[] arr = s.toCharArray();		// 입력을 char Array로 변환
		boolean isValid = true;				// 리턴 값
		int open = 0;						// 열려 있는 괄호를 나타내는 변수
		
		Stack<Character> s1 = new Stack<>();	// 각 괄호가 열려있는지 여부를 check하는 stack
		Stack<Character> s2 = new Stack<>();
		Stack<Character> s3 = new Stack<>();
		Stack<Integer> openSt = new Stack<>();	// 모든 괄호를 포함, 열려 있는 괄호를 check하는 stack 
		
		for(int i = 0; i < arr.length; i++) {
			
			if(arr[i] == '(') {	
				s1.push(arr[i]);		// 해당 stack에 추가 --> 이 괄호가 아직 열려있음을 나타냄
				open = 1;				// open에 해당 괄호를 나타내는 값을 대입
				openSt.push(open);		// open을 stack에 저장 --> 해당 괄호가 마지막으로 열림을 나타냄
			} else if(arr[i] == ')' && !s1.isEmpty() && (open == 1 || open == 0)) {
				// 닫힘 괄호가 나왔을 때, 이 괄호의 스택이 비어있지 않고, 이 괄호가 마지막으로 열렸거나 앞선 괄호가 닫힌 상태일 때
				s1.pop();				// 해당 stack에서 pop 한번 해주고
				openSt.pop();			// open 스택에서도 pop 해줌
				if(!openSt.isEmpty()) {	// open 스택이 비어있지 않으면
					open = openSt.peek();	// open 스택의 맨 위 값 = 마지막으로 열린 괄호를 open에 대입
				} else {					// 아무 괄호도 열려있지 않으면 0을 대입
					open = 0;
				}
			} else if(arr[i] == ')' && (s1.isEmpty() || !(open == 1))) {
				isValid = false;
				break;
			}
			
			if(arr[i] == '{') {
				s2.push(arr[i]);
				open = 2;
				openSt.push(open);
			} else if(arr[i] == '}' && !s2.isEmpty() && (open == 2 || open == 0)) {
				s2.pop();
				openSt.pop();
				if(!openSt.isEmpty()) {
					open = openSt.peek();
				} else {
					open = 0;
				}
			} else if(arr[i] == '}' && (s2.isEmpty() || !(open == 2))) {
				isValid = false;
				break;
			}
			
			if(arr[i] == '[') {
				s3.push(arr[i]);
				open = 3;
				openSt.push(open);
			} else if(arr[i] == ']' && !s3.isEmpty() && (open == 3 || open == 0)) {
				s3.pop();
				openSt.pop();
				if(!openSt.isEmpty()) {
					open = openSt.peek();
				} else {
					open = 0;
				}
			} else if(arr[i] == ']' && (s3.isEmpty() || !(open == 3))) {
				isValid = false;
				break;
			}
			
			if(i == arr.length-1 && (!s1.isEmpty() || !s2.isEmpty() || !s3.isEmpty())) {
				isValid = false;
			}
		}
		
		System.out.println(isValid);
		
	}

}
