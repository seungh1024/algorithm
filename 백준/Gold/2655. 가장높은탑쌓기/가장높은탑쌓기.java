

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static Data[] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new Data[N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int e = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			data[i] = new Data(i,e, w, h);
		}
		data[0] = new Data(0, 10001, 10001, 0);
		Arrays.sort(data, Comparator.comparingInt((Data o) -> -o.e));
		int[] dp = new int[N + 1];

		int maxIdx = 0;
		int maxHeight = 0;


		int[] index = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			Data now = data[i];
			for (int j = i - 1; j >= 0; j--) {
				Data last = data[j];
				if (now.w < last.w) {
					if (dp[j] + now.h > dp[i]) {
						dp[i] = dp[j] + now.h;
						index[i] = j;
					}
				}
			}

			if (maxHeight < dp[i]) {
				maxHeight = dp[i];
				maxIdx = i;
			}
			// System.out.println("i = "+i +", index = "+Arrays.toString(index));
			// System.out.println(Arrays.toString(dp));
		}

		int cnt = 0;

		StringBuilder sb = new StringBuilder();
		int idx = maxIdx;
		while (idx != 0) {
			cnt++;
			sb.append(data[idx].idx).append("\n");
			idx = index[idx];
		}
		System.out.println(cnt);
		System.out.println(sb);
	}

	public static class Data{
		int idx;
		int e;
		int w;
		int h;

		public Data(int idx, int e, int w, int h) {
			this.idx = idx;
			this.e = e;
			this.w = w;
			this.h = h;
		}
	}
}
