

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		List<Data> list = new ArrayList<>();
		int[] dp = new int[N + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list.add(new Data(from, to));
			dp[to] = Math.min(dp[to], from - 1);
		}
		Collections.sort(list, Comparator.comparingInt(o -> o.from));

		dp[0] = 0;

		for (int i = 0; i <= N; i++) {// 현재 날짜

			for (int j = 0; j < M; j++) { // 여행 정보
				Data now = list.get(j);
				if(now.from <= i) continue;
				dp[now.to] = Math.min(dp[now.to], Math.max(dp[i], now.from - i - 1));
			}
			dp[i] = Math.max(dp[i], N - i);
			// System.out.println("i = "+i);
			// System.out.println(Arrays.toString(dp));
		}
		// System.out.println(Arrays.toString(dp));

		int result = Integer.MAX_VALUE;
		for (int i = 0; i <= N; i++) {
			result = Math.min(result, dp[i]);
		}
		System.out.println(result);

	}

	public static class Data {
		int from;
		int to;

		@Override
		public String toString() {
			return "Data{" +
				"from=" + from +
				", to=" + to +
				'}';
		}

		public Data(int from, int to) {
			this.from = from;
			this.to = to;
		}
	}
}
