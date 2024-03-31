package algo_202403;

import java.io.*;
import java.util.*;

public class BJ_3079_입국심사 {
	public static int N,M;
	public static long[] data;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new long[N];

		for (int i = 0; i < N; i++) {
			data[i] = Long.parseLong(br.readLine());
		}


		long result = find();
		System.out.println(result);
	}

	public static long find() {
		long start = 0;
		long max = 1_000_000_000L;
		long end = max*max+1;

		while (start < end) {
			long mid = (start+end)/2;

			if (isValid(mid)) {
				end = mid;
			} else {
				start = mid+1;
			}

		}

		return start;
	}

	public static boolean isValid(long value) {
		long count = 0;

		for (int i = 0; i < N; i++) {
			count += (value/data[i]);
			if(count >= M){
				return true;
			}
		}

		return false;
	}
}
