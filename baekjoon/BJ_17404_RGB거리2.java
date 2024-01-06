package algo_202401;

import java.io.*;
import java.util.*;

public class BJ_17404_RGB거리2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] data = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int length = N-1;
		int result = Integer.MAX_VALUE;
		for (int s = 0; s < 3; s++) {
			int[][] count = new int[N][3];
			count[0][s] = data[0][s];
			for (int i = 0; i < length; i++) {
				for (int j = 0; j < 3; j++) {
					int left = (j+2)%3;
					int right = (j+1)%3;
					if(count[i][j] == 0) continue;
					if (count[i + 1][left] == 0) {
						count[i+1][left] = count[i][j] +data[i+1][left];
					} else {
						count[i + 1][left] = Math.min(count[i + 1][left], count[i][j] + data[i + 1][left]);
					}
					if (count[i + 1][right] == 0) {
						count[i + 1][right] = count[i][j] + data[i + 1][right];
					} else {
						count[i + 1][right] = Math.min(count[i + 1][right], count[i][j] + data[i + 1][right]);
					}
				}
			}
			// for (int i = 0; i < N; i++) {
			// 	System.out.println(Arrays.toString(count[i]));
			// }
			// System.out.println("=============");
			for (int i = 0; i < 3; i++) {
				if (s != i && count[N - 1][i] != 0) {
					result = Math.min(result,count[N-1][i]);
				}
			}
		}
		System.out.println(result);

	}
}
