

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] data = new int[N];
		boolean[] visited = new boolean[1000001];
		int[] pos = new int[1000001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
			visited[data[i]] = true;
			pos[data[i]] = i;
		}

		int[] result = new int[N];
		for (int i = 0; i < N; i++) {
			int num = data[i];
			for (int j = num * 2; j <= 1000000; j += num) {
				if (visited[j]) {
					result[i]++;
					result[pos[j]]--;
				}
			}
			// System.out.println(Arrays.toString(result));

		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(result[i]).append(" ");
		}
		System.out.println(sb);
	}
}
