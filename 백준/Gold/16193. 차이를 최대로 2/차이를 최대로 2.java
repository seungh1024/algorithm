

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

		Arrays.sort(data);
		Deque<Integer> dq = new ArrayDeque<>();


		int leftValue = data[N-1];
		int rightValue = leftValue;

		for (int i = 0; i < N - 1; i++) {
			dq.offer(data[i]);
		}

		long result = 0;
		for (int i = 0; i < N - 1; i++) {
			int df = dq.peekFirst();
			int de = dq.peekLast();

			int v1 = Math.abs(leftValue - df);
			int v2 = Math.abs(rightValue - df);
			int v3 = Math.abs(leftValue - de);
			int v4 = Math.abs(rightValue - de);

			int max = Math.max(Math.max(v1, v2), Math.max(v3, v4));
			result += max;
			if (max == v1) {
				leftValue = dq.pollFirst();
			} else if (max == v2) {
				rightValue = dq.pollFirst();
			} else if (max == v3) {
				leftValue = dq.pollLast();
			} else {
				rightValue = dq.pollLast();
			}
		}

		System.out.println(result);
	}
}

// 20 1 15 4 8 -> 19 + 14 + 11 + 4 = 48
// 8 20 1 15 4 -> 12 + 19 + 14 + 11 = 56
// 19 + 14 + 11 + 12=