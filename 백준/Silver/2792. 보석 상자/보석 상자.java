

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] data = new int[M];
		for (int i = 0; i < M; i++) {
			data[i] = Integer.parseInt(br.readLine());
		}

		int start = 1;
		int end = 1_000_000_000;

		while (start < end) {
			int mid = (start + end) / 2;

			int cnt = 0;
			for (int i = 0; i < M; i++) {
				cnt += (data[i] + mid - 1) / mid;
			}

			if (cnt <= N) {
				end = mid;
			} else {
				start = mid+1;
			}
		}

		System.out.println(start);
	}
}
