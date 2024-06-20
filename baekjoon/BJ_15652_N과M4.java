package algo_202406;

import java.io.*;
import java.util.*;

public class BJ_15652_N과M4 {
	public static int N,M;
	public static int[] data;
	public static StringBuilder result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		result = new StringBuilder();
		data = new int[M+1];
		find(1,0);
		System.out.println(result);
	}

	public static void find(int index, int count) {
		if (count == M) {
			for (int i = 1; i <= M; i++) {
				result.append(data[i]).append(" ");
			}
			result.append("\n");
			return;
		}

		if (index > M) {
			return;
		}

		for (int i = 1; i <= N; i++) {
			if(index >= 2 && i < data[index-1]) continue;
			data[index] = i;
			find(index+1,count+1);
		}
	}
}
