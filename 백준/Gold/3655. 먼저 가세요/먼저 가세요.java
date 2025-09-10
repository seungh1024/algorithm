

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			char[] input = br.readLine().toCharArray();
			int[] count = new int[150];
			int[] lastIdx = new int[150];

			for (int i = 0; i < N; i++) {
				count[input[i]]++;
				lastIdx[input[i]] = i;
			}
			PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
			for (int i = 0; i < N; i++) {
				pq.offer(new int[] {i, lastIdx[input[i]]});
			}
			char[] arr = new char[N];
			boolean[] visited = new boolean[150];
			int[] newIdx = new int[150];
			for (int i = 0; i < N; i++) {
				arr[i] = input[pq.poll()[0]];
				newIdx[arr[i]] = i;
				visited[arr[i]] = true;
			}

			int result = 0;
			for(int i = 0; i < 150; i++){
				if (visited[i]) {
					int origin = lastIdx[i];
					int idx = newIdx[i];
					result += (count[i]*(origin-idx)*5);
				}
			}
			sb.append(result).append("\n");

		}
		System.out.println(sb);
	}
}
