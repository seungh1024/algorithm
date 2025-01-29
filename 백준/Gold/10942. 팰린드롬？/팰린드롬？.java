import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] data = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		boolean[][] dp = new boolean[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			dp[i][i] = true;
		}

		for (int i = 1; i <= N; i++) {
			int left = i-1;
			int right = i+1;
			while (left > 0 && right <= N) {
				if (data[left] != data[right]) {
					break;
				}

				dp[left][right] = true;
				left--;
				right++;
			}
		}

		for (int i = 1; i <= N; i++) {
			int left = i;
			int right = i+1;

			while (left > 0 && right <= N) {
				if (data[left] != data[right]) {
					break;
				}
				dp[left][right] = true;
				left--;
				right++;
			}
		}

		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			if (dp[S][E]) {
				sb.append(1);
			} else {
				sb.append(0);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}