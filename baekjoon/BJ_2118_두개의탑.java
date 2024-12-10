package algo_202412;

import java.io.*;
import java.util.*;

public class BJ_2118_두개의탑 {
	public static int N;
	public static int[] data;
	public static int[] sum;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N+1];
		sum = new int[N+1];

		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(br.readLine());
			sum[i] = sum[i-1] + data[i];
		}

		int left = 0;
		int right = 1;
		int now = 0;
		int total = sum[N];
		int max = now;
		int count = 0;
		while (true) {
			int rightValue = Math.abs(sum[right] - sum[left]);
			int leftValue = total - Math.abs((sum[right] - sum[left]));
			if (rightValue <= leftValue) {
				max = Math.max(max, rightValue);
				right++;
			}else{
				left++;
				max = Math.max(max, leftValue);
			}

			if (right > N) {
				right %= N;
				count++;
			}
			if (left > N) {
				left %= N;
			}
			if (count >= 2) {
				break;
			}
		}

		System.out.println(max);

	}
}
