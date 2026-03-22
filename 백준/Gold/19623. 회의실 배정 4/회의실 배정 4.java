

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Data[] data = new Data[N + 1];
		data[0] = new Data(0, 0, 0);
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			data[i] = new Data(start, to, cost);
		}

		Arrays.sort(data, Comparator.comparingInt(o -> o.end));

		int[] dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {

			int start = 0;
			int end = i;
			while (start < end) {
				int mid = (start + end) / 2;

				if (data[mid].end > data[i].start) {
					end = mid;
				} else {
					start = mid + 1;
				}
			}
			start--;

			dp[i] = Math.max(dp[i - 1], dp[start] + data[i].cnt);
		}

		System.out.println(dp[N]);

	}

	public static class Data{
		int start;
		int end;
		int cnt;

		@Override
		public String toString() {
			return "Data{" +
				"start=" + start +
				", end=" + end +
				", cnt=" + cnt +
				'}';
		}

		public Data(int start, int end, int cnt) {
			this.start = start;
			this.end = end;
			this.cnt = cnt;
		}
	}
}
