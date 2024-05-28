package algo_202405;

import java.io.*;
import java.util.*;

public class BJ_15810_풍선공장 {
	public static int N,M;
	public static int[] time;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		time = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}

		long result = find();
		System.out.println(result);
	}

	public static long find() {
		long start = 0;
		long end = 1_000_000_000_000L;

		while (start < end) {
			long mid = (start+end)/2;
			// System.out.println("mid = "+mid);

			long count = getCount(mid);
			// System.out.println("count = "+count);

			if (count >= M) {
				end = mid;
			} else {
				start = mid+1;
			}
		}

		return start;
	}

	public static long getCount(long mid) {
		long count = 0;

		for (int i = 0; i < N; i++) {
			count += (mid / time[i]);
		}

		return count;
	}
}
