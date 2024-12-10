package algo_202412;

import java.io.*;
import java.util.*;

public class BJ_1507_궁금한민호 {
	public static int N;
	public static int[][] data;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		data = new int[N][N];
		int[][] dis = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
				dis[i][j] = data[i][j];
			}
		}

		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N; i++) {
				if(i == j) continue;
				for (int k = 0; k < N; k++) {
					if(j == k || i == k) continue;

					if (data[i][k] == data[i][j] + data[j][k]) {
						dis[i][k] = 0;
					}

					if (data[i][k] > data[i][j] + data[j][k]) {
						System.out.println(-1);
						return;
					}
				}
			}
		}

		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				sum += dis[i][j];
			}
		}

		System.out.println(sum);

	}



}
