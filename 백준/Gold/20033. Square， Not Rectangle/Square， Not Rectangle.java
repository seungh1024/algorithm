

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] data = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		find(N, data);
	}

	public static void find(int N, int[] data) {
		int start = 1;
		int end = 1000000000;

		int result = 0;
		while (start < end) {
			int mid = (start + end) / 2;

			int cnt = 0;
			int max = 0;
			for (int i = 0; i < N; i++) {
				if (data[i] >= mid) {
					cnt++;
				} else {
					max = Math.max(max, cnt);
					cnt = 0;
				}
			}
			max = Math.max(max, cnt);

			// System.out.println("mid = "+mid + " , max = "+max);
			if (max >= mid) {
				result = Math.max(result, mid);
			}
			if (max <= mid) {
				end = mid;
			} else {
				start = mid+1;
			}
		}
		System.out.println(result);
	}
}
