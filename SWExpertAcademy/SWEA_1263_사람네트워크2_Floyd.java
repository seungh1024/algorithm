package day0404;

import java.io.*;
import java.util.*;

public class SWEA_1263_사람네트워크2_Floyd {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] list = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int now = Integer.parseInt(st.nextToken());
					if(i!=j && now != 0) {						
						list[i][j] = now;
					}else if(i != j && now == 0) {
//						list[i][j] = -1;
					}
				}
//				System.out.println(Arrays.toString(list[i]));
			}
			
			for(int k = 0; k < N; k++) {
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++) {
						if(list[i][k] >= 1 && list[k][j] >= 1 && i != j) {
							if(list[i][j] == 0) {								
								list[i][j] =list[i][k]+list[k][j];
							}else {
								list[i][j] = Math.min(list[i][j], list[i][k]+list[k][j]);
							}
						}
					}
				}
			}
			
			int result = Integer.MAX_VALUE;
			for(int i = 0; i < N; i ++) {
				int sum = 0;
//				System.out.println(Arrays.toString(list[i]));
				for(int j = 0; j < N; j++) {
					if(list[i][j] != -1) {
						sum += list[i][j];
					}
				}
				result = Math.min(result, sum);
			}
			System.out.println("#"+t+" "+result);
			
		}
	}
}

//#1 2
//#2 3
//#3 25
//#4 37
//#5 16
//#6 11
//#7 21
//#8 20
//#9 715
//#10 1449
