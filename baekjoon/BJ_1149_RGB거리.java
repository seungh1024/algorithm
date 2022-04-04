package day0331;

import java.io.*;
import java.util.*;

public class BJ_1149_RGB거리 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] rgb = new int[N][3];
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		rgb[0][0] = Integer.parseInt(st.nextToken());
		rgb[0][1] = Integer.parseInt(st.nextToken());
		rgb[0][2] = Integer.parseInt(st.nextToken());//첫째 줄 먼저 비교를 위해 넣어줌
		
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				int minNum = Math.min(rgb[i-1][(j+1)%3], rgb[i-1][(j+2)%3]); //자기 색 외의 다른 색의 값 중 작은 값을 찾음
				rgb[i][j] = minNum + Integer.parseInt(st.nextToken());
			}
//			System.out.println(Arrays.toString(rgb[i]));
		}
		int result = Math.min(rgb[N-1][0],rgb[N-1][1]);
		result = Math.min(result, rgb[N-1][2]);
		
		System.out.println(result);
	}
}
