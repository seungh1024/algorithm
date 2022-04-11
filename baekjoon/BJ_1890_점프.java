package day0411;

import java.io.*;
import java.util.*;

public class BJ_1890_점프 {

	static int N;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
//			System.out.println(Arrays.toString(map[i]));
		}
		
		long[][] check = new long[N][N];
		check[0][0] = 1;

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int now = map[i][j];
				if(now != 0 && check[i][j] != 0) {
					if(i+now < N) {
						check[i+now][j]+= check[i][j];						
					}
					if(j+now < N) {						
						check[i][j+now]+= check[i][j]; //오른쪽, 아래 방문하는 곳 = 이전값 +1
					}
				}
			}
//			System.out.println(Arrays.toString(check[i]));
		}
		System.out.println(check[N-1][N-1]);
	}


}
