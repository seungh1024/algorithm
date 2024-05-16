package algo_202405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_4097_수익 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0) {
				break;
			}
			int[] data = new int[N + 1];
			data[1] = Integer.parseInt(br.readLine());
			int last = data[1];
			int max = data[1];
			for (int i = 2; i <= N; i++) {
				int input = Integer.parseInt(br.readLine());
				data[i] = input + data[i - 1];
				max = Math.max(max, input);
				max = Math.max(max, data[i]);
				max = Math.max(max, data[i] - last);
				last = Math.min(last,data[i]);
			}
			// System.out.println(max);
			// System.out.println(Arrays.toString(data));
			sb.append(max).append("\n");

		}
		System.out.println(sb);
	}
}
