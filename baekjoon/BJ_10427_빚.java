package algo_202412;

import java.io.*;
import java.util.*;

public class BJ_10427_빚 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N =Integer.parseInt(st.nextToken());
			long[] data = new long[N];
			for (int i = 0; i < N; i++) {
				data[i] = Long.parseLong(st.nextToken());
			}
			Arrays.sort(data);

			long result = 0;
			// 1번 ~ N번까지
			for (int i = 1; i <= N; i++) {
				long min = Long.MAX_VALUE;
				int left = 0;
				int right = 0;
				long sum = 0;
				for (; right < i; right++) {
					sum += data[right];
				}
				right--;

				while (true) {
					long value = data[right]*i - sum;
					min = Math.min(min, value);
					if (right == N - 1) {
						break;
					}
					right++;
					sum += data[right];
					sum -= data[left];
					left ++;

				}

				result += min;

			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}
