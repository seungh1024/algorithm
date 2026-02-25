

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static long[] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		data = new long[N];
		for (int i = 0; i < N; i++) {
			data[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(data);
		// System.out.println(Arrays.toString(data));

		long min = Long.MAX_VALUE;

		int a = 0;
		int b = 0;
		int c = 0;
		for (int i = 0; i < N-2; i++) {
			for (int j = i + 1; j < N-1; j++) {
				int k = j+1;
				long sum = data[i] + data[j];
				int idx = find(sum, k);
				long abs = Math.abs(sum+data[idx]);

				if (abs < min) {
					min = abs;
					a = i;
					b = j;
					c = idx;
				}

				if (idx - 1 > j) {
					abs = Math.abs(sum + data[idx - 1]);
					if (abs < min) {
						min = abs;
						a = i;
						b = j;
						c = idx-1;
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(data[a]).append(" ").append(data[b]).append(" ").append(data[c]);
		System.out.println(sb);
	}

	public static int find(long sum, int k) {
		int start = k;
		int end = N-1;

		while (start < end) {
			int mid = (start + end) / 2;
			long v = sum + data[mid];

			if (v >= 0) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}

		return start;
	}
}
