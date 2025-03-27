

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] data = new int[N+1];
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(data);

		for (int i = 1; i <= N; i++) {
			int a = data[i];
			if (a == C) {
				System.out.println(1);
				return;
			}
			for (int j = i + 1; j <= N; j++) {
				int b = data[j];

				if (a + b > C) {
					continue;
				} else if (a + b == C) {
					System.out.println(1);
					return;
				}

				// System.out.println("a = " + a + ", b=  " + b);
				if (j + 1 <= N) {
					int idx = binarySearch(j + 1, N, C - (a + b), data);
					if (a + b + data[idx] == C) {
						System.out.println(1);
						return;
					}
				}
			}
		}

		System.out.println(0);
	}

	public static int binarySearch(int start, int end, int C,int[] data) {

		// System.out.println("start = "+start +", end = "+end);
		while (start < end) {
			int mid = (start + end) / 2;

			if (data[mid] >= C) {
				end = mid;
			} else {
				start = mid+1;
			}
		}

		// System.out.println("result = "+start);
		return start;
	}
}
