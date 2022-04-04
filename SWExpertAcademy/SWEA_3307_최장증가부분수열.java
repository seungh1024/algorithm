package day0404;

import java.io.*;
import java.util.*;

public class SWEA_3307_최장증가부분수열 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {//총 테스트 케이스
			
			int N = Integer.parseInt(br.readLine()); //수열의 길이
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] list = new int[N];
			for(int i = 0; i < N ; i++) {
				list[i] = Integer.parseInt(st.nextToken());
			}
//			System.out.println(Arrays.toString(list));
			
			int[] result = new int[N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < i; j++) {
					if(list[j] <= list[i]) {
						result[i] = Math.max(result[j] +1,result[i]);
					}
				}
			}
			
			int maxLength = 0;
			for(int i = 0; i < N; i++) {
				maxLength = maxLength>result[i]?maxLength:result[i];
			}
			System.out.println("#"+t+" "+(maxLength+1));
//			System.out.println(Arrays.toString(result));
			
		}//end test
		
	}
}
//2
//5
//1 3 2 5 4
//6
//4 2 3 1 5 6