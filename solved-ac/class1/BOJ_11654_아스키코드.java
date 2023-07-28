package Junseok.solvedac;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class BOJ_11654_아스키코드 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		byte[] b = str.getBytes(StandardCharsets.US_ASCII);
		System.out.println(b[0]);
	}

}
