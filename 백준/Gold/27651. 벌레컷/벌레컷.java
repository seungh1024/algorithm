

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static long[] sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sum = new long[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int input = Integer.parseInt(st.nextToken());
			sum[i] += sum[i-1]+input;
		}

		long result = 0;
		for (int i = 1; i < N; i++) {
			long head = sum[i];
			result += find(i, head);
		}
		System.out.println(result);
	}

	public static long find(int s, long head) {
		int start = s+1;
		int end = N;

		while (start < end) {
			int mid = (start + end) / 2;

			long chest = sum[mid]-sum[s];
			long stomach = sum[N] - sum[mid];
			// System.out.println("mid = "+mid +", head = "+head + ", chest = "+chest +", stomach = "+stomach);
			if (chest > stomach) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		int left = start;
		// System.out.println("left = "+left + ", head = "+head + ", chest = "+(sum[left]-sum[s]));

		if (left == N || sum[N] - sum[left] <=head) {
			return 0;
		}

		start = left;
		end = N-1;
		long chest = sum[left]-sum[s];
		while (start < end) {
			int mid = (start + end) / 2;

			long stomach = sum[N] - sum[mid];
			// System.out.println("mid = "+mid + ", chest = "+chest + ", stomach = "+stomach);
			if (head >= stomach) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		int right = start;

		if ( sum[N] - sum[right] <= head) {
			right--;
		}
		if (sum[N] - sum[right] >= sum[right] - sum[s]) {
			return 0;
		}


		// System.out.println("i = "+ s +", head = "+head + ", left = " + left + ", right = " + right);
		return right-left+1;
	}
}

// 1, 12, 2
// 1, 9, 5
// 4, 6, 5