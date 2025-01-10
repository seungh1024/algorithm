package algo_202501;

import java.io.*;
import java.util.*;

public class BJ_2141_우체국 {
	public static int N;
	public static Data[] data;
	public static long max = Long.MAX_VALUE;
	public static long[] sum;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new Data[N+1];


		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			data[i] = new Data(a, b);
		}
		data[0] = new Data(Long.MIN_VALUE, 0);
		Arrays.sort(data, Comparator.comparingLong(o->o.idx));

		sum = new long[N + 1];
		for (int i = 1; i <= N; i++) {
			sum[i] += sum[i-1] + data[i].cnt;
		}

		binarySearch();
	}

	public static void binarySearch() {
		int start = 1;
		int end = data.length;

		while (start < end) {
			int mid = (start + end) / 2;


			// System.out.println(mid);
			if (sum[mid] >= sum[N] - sum[mid]) {
				end = mid;
			} else {
				start = mid+1;
			}
		}

		System.out.println(data[start].idx);
	}


	public static class Data{
		long idx;
		long cnt;

		public Data(long idx, long cnt) {
			this.idx = idx;
			this.cnt = cnt;
		}
	}
}
