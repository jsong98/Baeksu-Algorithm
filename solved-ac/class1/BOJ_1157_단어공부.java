package Junseok.solvedac;

// 단어 공부

/*
 * Mississipi
 */

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1157_단어공부 {

	public static void main(String[] args) {
		char[] upper = new char[26];
		char[] lower = new char[26];
		int[] cnt = new int[26];
		int max = -1;
		int maxIdx = 0;
		boolean isdup = false;
		
		// 대문자 저장
		int i = 0;
		for(char c = 'A'; c <= 'Z'; c++) {
			upper[i] = c;
			i++;
		}
		
		// 소문자 저장
		i = 0;
		for(char c = 'a'; c <= 'z'; c++) {
			lower[i] = c;
			i++;
		}
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char cmp;
		
		// 입력받은 단어의 각 알파벳의 수를 cnt 배열에 저장.
		for(int n = 0; n < str.length(); n++) {
			cmp = str.charAt(n);
			for(int m = 0; m < 26; m++) {
				if(cmp == upper[m] || cmp == lower[m]) {
					cnt[m]++;
				}
			}
		}
		
		// cnt 배열 내 최대값을 가지는 index 도출.
		for(int pt = 0; pt < 26; pt++) {
			if(cnt[pt] != 0 && cnt[pt] == max) {
				isdup = true;
			}
			if(cnt[pt] > max) {
				max = cnt[pt];
				maxIdx = pt;
				isdup = false;
			}
		}
		
		char maxCh = upper[maxIdx];
		
		if(isdup) {
			System.out.println("?");
		} else {
			System.out.println(maxCh);
		}
	}

}
