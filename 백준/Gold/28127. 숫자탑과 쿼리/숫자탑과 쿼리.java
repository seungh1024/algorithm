

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		StringBuilder sb = new StringBuilder();
		int Q = Integer.parseInt(br.readLine());
		for (int i = 0; i < Q; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			long floor = binarySearch(a, d, x);
			long v = x - floor*(2*a+(floor-1)*d)/2;
			sb.append(floor + 1).append(" ").append(v).append("\n");
		}
		System.out.println(sb);
	}

	public static int binarySearch(int a, int d, int x) {
		int start = 1;
		int end = 2000;


		while (start < end) {
			long mid = (start + end) / 2;
			long value = mid*(2*a+(mid-1)*d)/2;

			if (value >= x) {
				end = (int)mid;
			} else {
				start = (int)mid+1;
			}
		}
		// (n - 1) * (2 * a + (n - 2) * d) / 2 + 1;
		if (start*(2*a+(start-1)*d) > x) {
			start--;
		}



		return start;
	}
}
