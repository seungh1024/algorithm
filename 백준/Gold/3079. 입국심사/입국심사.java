

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] data = new int[N];
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(br.readLine());
		}

		long start = 0;
		long end = Long.MAX_VALUE;

		while (start < end) {
			long mid = (start + end) / 2;

			boolean flag = false;
			long count = 0;
			for (int i = 0; i < N; i++) {
				count += mid / data[i];
				if (count >= M) {
					flag = true;
					break;
				}
			}
			// System.out.println("start = "+start + ", end = "+end);

			if (flag) {
				end = mid;
			} else {
				start = mid+1;
			}
		}

		System.out.println(start);
	}

}
