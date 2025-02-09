import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[] data;
	public static int[] sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N+1];
		sum = new int[N+1];
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(br.readLine());
			sum[i] += data[i] + sum[i - 1];
		}
		// System.out.println(Arrays.toString(sum));

		int left = 0;
		int right = 1;
		int range = 0;
		int max = 0;
		while (true) {
			int rightValue = Math.abs(sum[right] - sum[left]);
			int leftValue = sum[N] - rightValue;

			if (rightValue <= leftValue) {
				right++;
				max = Math.max(max, rightValue);
			} else {
				left ++;
				max = Math.max(max, leftValue);
			}

			if (right > N) {
				right %= N;
				range++;
			}
			if (left > N) {
				left %= N;
			}
			if (range > 2) {
				break;
			}
		}
		System.out.println(max);


	}


}