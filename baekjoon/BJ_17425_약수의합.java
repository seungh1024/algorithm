package algo_202401;

import java.io.*;
import java.util.*;

public class BJ_17425_약수의합 {
	public static long[] data;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		init();
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(data[N]).append("\n");
		}
		System.out.println(sb);
	}

	public static void init() {
		int size = 1000001;
		data = new long[size];
		data[1] = 1;
		for (int i = 2; i < size; i++) {
			data[i] = 1 + i;
		}
		boolean[] visited = new boolean[size];
		visited[1] = true;

		for (int i = 2; i < size; i++) {
			int temp = 2;
			while (true) {
				int value = i*temp;
				if(value >= size) break;
				data[value] += i;
				temp++;
				visited[value] = true;
			}

		}

		for (int i = 2; i < size; i++) {
			data[i] += data[i-1];
		}
	}
}
