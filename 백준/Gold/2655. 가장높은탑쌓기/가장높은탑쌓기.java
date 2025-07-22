

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static Data[] data;
	public static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new Data[N+1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			data[i] = new Data(i, a, h, w);
		}
		data[0] = new Data(0, 0, 0, 0);
		Arrays.sort(data, Comparator.comparingInt(o -> o.a));
		dp = new int[N + 1];

		int idx = 0;
		int maxIdx = 0;
		int maxHeight = 0;
		int[] index = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			Data now = data[i];
			// System.out.println("now = "+now);
			for (int j = i-1; j >= 0; j--) {
				Data last = data[j];
				if (now.w > last.w) {
					// System.out.println(now);
					if (dp[j] + now.h > dp[i]) {
						dp[i] = dp[j] + now.h;
						index[i] = j;
						idx = i;
					}
				}
			}

			if (maxHeight < dp[i]) {
				maxHeight = dp[i];
				maxIdx = i;
			}
		}
		// System.out.println(Arrays.toString(index));
		// System.out.println(Arrays.toString(dp));

		int cnt = 0;

		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		idx = maxIdx;
		while (idx != 0) {
			cnt++;
			stack.push(data[idx].idx);
			idx = index[idx];
		}
		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append("\n");
		}

		System.out.println(cnt);
		System.out.println(sb);
	}


	public static class Data{
		int idx;
		int a;
		int h;
		int w;

		public Data(int idx, int a, int h, int w) {
			this.idx = idx;
			this.a = a;
			this.h = h;
			this.w = w;
		}

		@Override
		public String toString() {
			return "Data{" +
				"idx=" + idx +
				", a=" + a +
				", h=" + h +
				", w=" + w +
				'}';
		}
	}
}
