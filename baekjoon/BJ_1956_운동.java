package day0412;

import java.io.*;
import java.util.*;

public class BJ_1956_운동 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		int[][] map = new int[V + 1][V + 1];
		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[a][b] = c;

		}
		
		for(int i = 1; i <= V; i++) {
			for(int j = 1; j <= V; j++) {
				if(map[i][j] == 0) {
					map[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		
		for(int k = 1; k <= V; k++) {
			for(int i = 1; i <= V; i++) {
				if(k == i) continue;
				for(int j = 1; j <= V; j++) {
					if(k == j || map[i][k] == Integer.MAX_VALUE || map[k][j] == Integer.MAX_VALUE) continue;
					if(map[i][j] > map[i][k]+map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		
		int result = Integer.MAX_VALUE;
		for(int i = 1; i <= V; i++) {
//			if(map[i][i] == )
			result = Math.min(map[i][i], result);
//			System.out.println(Arrays.toString(map[i]));
		}
		if(result == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {			
			System.out.println(result);
		}
	}
}
