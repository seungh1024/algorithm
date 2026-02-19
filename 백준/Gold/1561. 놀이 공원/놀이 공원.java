

import java.io.*;
import java.util.*;

public class Main {
	public static long N;
	public static int M;
	public static long[] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		data = new long[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			data[i] = Long.parseLong(st.nextToken());
		}

		if (N <= M) {
			System.out.println(N);
			return;
		}

		long result = find();
		long cnt = getChildCount(result-1);
		for (int i = 0; i < M; i++) {
			if (result % data[i] == 0) {
				cnt++;
			}
			if (cnt == N) {
				System.out.println(i + 1);
				break;
			}
		}
	}

	public static long find() {
		long start = 0;
		long end = N*30;

		while (start < end) {
			long mid = (start + end) / 2;
			long cnt = getChildCount(mid);

			if (cnt >= N) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}

		return start;
	}

	public static long getChildCount(long mid) {
		long cnt = M;
		for (int i = 0; i < M; i++) {
			cnt += mid / data[i];
		}

		return cnt;
	}
}
