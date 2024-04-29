package algo_202404;

import java.io.*;
import java.util.*;

public class BJ_2876_그래픽스퀴즈 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] data = new int[6][N+1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			data[a][i] = data[a][i-1]+1;
			data[b][i] = data[b][i-1]+1;
		}
		// for (int i = 1; i <= 5; i++) {
		// 	System.out.println(Arrays.toString(data[i]));
		// }

		int maxStudent = 0;
		int maxGrade = 0;
		for (int j = 1; j <= N; j++) {
			for (int i = 1; i <= 5; i++) {
				if(data[i][j] > maxStudent){
					maxStudent = data[i][j];
					maxGrade = i;
				} else if (data[i][j] == maxStudent) {
					maxGrade = Math.min(i, maxGrade);
				}
			}
		}

		System.out.println(maxStudent + " " + maxGrade);

	}
}
