

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			long n = Long.parseLong(br.readLine());
			long result = find(n);
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	public static long find(long n) {
		long start = 1;
		long end = Integer.MAX_VALUE;

		while (start < end) {
			long mid = (start+end)/2;
			long target = mid * (3 * mid + 1) / 2;
			if (target >= n) {
				end = mid;
			} else {
				start = mid+1;
			}
			// System.out.println("start = "+start + ", end = "+end);
		}

		long a = n-(start-1)*(3*start-2)/2; // 3k-1 -> a
		long line = 0;
		long cnt = 0;
		if (a <= start) {
			line = 3*start-2;
			cnt = 3*a-2;
		} else if (a <= 2 * start - 1) {
			line = 3 * start - 1;
			cnt = 3 * (a - start);
		} else {
			line = 3*start;
			cnt = 3 * (a - 2 * start + 1) - 1;
		}

		return line*(line-1)/2+cnt;
	}
}
