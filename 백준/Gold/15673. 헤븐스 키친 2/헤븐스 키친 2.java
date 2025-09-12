
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] data = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		if (N == 2) {
			System.out.println(data[1] * data[2]);
			return;
		}

		int[] sumPlusRight = new int[N + 1];
		int[] sumMinusRight = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			if (sumPlusRight[i - 1] + data[i] > 0) {
				sumPlusRight[i] += sumPlusRight[i - 1] + data[i];
			}
			if (sumMinusRight[i - 1] + data[i] < 0) {
				sumMinusRight[i] += sumMinusRight[i - 1] + data[i];
			}
		}

		long[] rightMax = new long[N + 1];
		long[] rightMin = new long[N + 1];
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, sumPlusRight[i]);
			min = Math.min(min, sumMinusRight[i]);
			rightMax[i] = max;
			rightMin[i] = min;
		}

		int[] sumPlusLeft = new int[N + 2];
		int[] sumMinusLeft = new int[N + 2];
		for (int i = N; i > 0; i--) {
			if (sumPlusLeft[i + 1] + data[i] > 0) {
				sumPlusLeft[i] += sumPlusLeft[i + 1] + data[i];
			}
			if (sumMinusLeft[i + 1] + data[i] < 0) {
				sumMinusLeft[i] += sumMinusLeft[i + 1] + data[i];
			}
		}

		long[] leftMax = new long[N + 1];
		long[] leftMin = new long[N + 1];
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		for (int i = N; i > 0; i--) {
			max = Math.max(max, sumPlusLeft[i]);
			min = Math.min(min, sumMinusLeft[i]);
			leftMax[i] = max;
			leftMin[i] = min;
		}

		long result = Long.MIN_VALUE;
		for (int i = 1; i < N; i++) {
			result = Math.max(result, rightMax[i] * leftMax[i + 1]);
			result = Math.max(result, rightMin[i] * leftMin[i + 1]);
		}
		// System.out.println(Arrays.toString(rightMax));
		// System.out.println(Arrays.toString(leftMax));
		// System.out.println(Arrays.toString(rightMin));
		// System.out.println(Arrays.toString(leftMin));
		System.out.println(result);
	}
}
