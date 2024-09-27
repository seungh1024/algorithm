package algo_202409;

import java.io.*;
import java.util.*;

public class BJ_13422_도둑 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[] data = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				data[i] = Integer.parseInt(st.nextToken());
			}

			int left = 0;
			int right = 0;
			int sum = 0;
			for (int i = 0; i < M; i++) {
				sum += data[right];
				right = (right+1)%N;
			}

			if (N == M) {
				if (sum < K) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
				continue;
			}

			int result = 0;
			for (; left < N; left++) {
				if (sum < K) {
					result++;
				}
				// System.out.println("sum = " + sum +", left = "+left +", right = "+right);
				sum -= data[left];
				sum += data[right];
				right = (right+1)%N;
			}
			sb.append(result).append("\n");

		}

		System.out.println(sb);
	}
}
