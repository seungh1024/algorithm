

import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static int[] height;
	public static List<Integer>[] list;
	public static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		height = new int[N + 1];
		list = new ArrayList[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			height[i] = Integer.parseInt(st.nextToken());
			list[i] = new ArrayList<>();
		}


		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			if (height[from] < height[to]) {
				list[from].add(to);
			} else {
				list[to].add(from);
			}
		}

		dp = new int[N + 1];
		Arrays.fill(dp,-1);
		List<int[]> list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			list.add(new int[] {i, height[i]});
		}
		Collections.sort(list, Comparator.comparingInt(o -> o[1]));

		for (int i = 1; i <= N; i++) {
			// System.out.println("start = "+i);
			int[] now = list.get(i-1);
			int idx = now[0];
			if(dp[idx] != -1) continue;
			find(idx, 1);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if (dp[i] == -1) {
				sb.append(1);
			} else {
				sb.append(dp[i]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static int find(int idx, int cnt) {
		if (list[idx].size() == 0) {
			// System.out.println("end = "+idx);
			return 1;
		}

		if (dp[idx] > 0) {
			return dp[idx];
		}

		int max = 0;
		for (int next : list[idx]) {
			// System.out.println("next = "+next);
			max  = Math.max(max,find(next, cnt + 1)+1);
		}

		return dp[idx] = max;
	}
}
