package topic.parametricSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
5 10 10
4 3 2 1 4 3 2 1 4 3

5 5 3
4 2 5 3 1

10 4 3
2 5 7 8
*/

public class BOJ_1114_통나무자르기 {
	
	private static int l;
    private static int k;
    private static int c;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        init();
        int[] answer = binarySearch();
        System.out.println(answer[0] + " " + answer[1]);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[k + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[k] = l;
        Arrays.sort(arr);
        br.close();
    }

    private static int[] binarySearch() {
        int[] ret = new int[2];
        int left = 1;
        int right = l;
        while (left <= right) {
            int mid = (left + right) / 2;
            int res = check(mid);
            if (res != -1) {
                ret[0] = mid;
                ret[1] = res;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ret;
    }

    private static int check(int len) { // 3 5
        int left = k;
        int right = k;
        int ct = 0;
        while (true) {
            left--;
            if (arr[right] - arr[left] > len) {
                if (left + 1 == right) {
                    return -1;
                }
                right = left + 1;
                left = left + 1;
                ct++;
            }
            if (left == 0) {
                break;
            }
            if (ct == c) {
                break;
            }
        }
        if (arr[right] - arr[left] > len) {
            return -1;
        }
        if (arr[left] > len) {
            return -1;
        }
        return arr[left];
    }
	
//	public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String line = sc.nextLine();
//
//        String[] spt = line.split(" ");
//        Long l = Long.parseLong(spt[0]);
//        int k = Integer.parseInt(spt[1]);
//        int c = Integer.parseInt(spt[2]);
//
//        line = sc.nextLine();
//        spt = line.split(" ");
//        List<Long> pos = new ArrayList<>();
//        pos.add(0L);
//        pos.add(l);
//        for (int i = 0; i < k; i++) {
//            pos.add(Long.parseLong(spt[i]));
//        }
//        pos.sort((a, b) -> (int) (a - b));
//        
//        long left = 0;
//        long right = l;
//        long ansFirst = 0;
//        long ansLongest = l;
//        
//        while (left <= right) {
//        	System.out.println("left: " + left + ", right: " + right);
//            long mid = left + (right - left) / 2;
//            long cutCnt = 0;
//            long firstCut = -1;
//            long diff = 0;
//            for (int i = k; i >= 0; i--) {
//                diff += pos.get(i + 1) - pos.get(i);
//                if (diff > mid) {
//                    diff = pos.get(i + 1) - pos.get(i);
//                    cutCnt++;
//                    if (diff > mid) {
//                        cutCnt = c + 1;
//                        break;
//                    }
//                }
//            }
//            // 첫번째를 자를 수 있는지 확인한다.
//            // 한번이라도 자를 수 있으면 첫번째가 최소 길이가 된다.
//            if (cutCnt < c) {
//                firstCut = pos.get(1);
//            } else {
//                firstCut = diff;
//            }
//            
//            if (cutCnt <= c) {
//                ansLongest = Math.min(mid, ansLongest);
//                ansFirst = firstCut;
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//            
//        }
//        System.out.println(ansLongest + " " + ansFirst);
//        sc.close();
//
//    }

}
