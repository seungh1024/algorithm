
import java.io.*;
import java.util.*;

public class Main {
	public static int N,W,T, K;
	public static int[][] dp;
	public static int[] fire;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		dp = new int[T + 1][N + 1]; // 현 시점에서의 위치
		fire = new int[N + 2];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			fire[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= T; i++) {
			Arrays.fill(dp[i],-1);
		}
		int result = find(1, W+1, 0);
		System.out.println(result);
	}

	public static int find(int t, int idx, int target) {
		int[] data = getMinusData();
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if(i == target) {
                if(fire[i]>0) cnt++;
                continue;
            }
			fire[i] -= data[i];
			if (fire[i] > 0) {
				cnt++;
			}
		}
		if(cnt < K) {
			for (int i = 1; i <= N; i++) {
				if(i == target) continue;
				fire[i] += data[i];
			}
			dp[t][idx] = 0;
			return 0;
		}

		if (t == T) {
			for (int i = 1; i <= N; i++) {
				if(i == target) continue;
				fire[i] += data[i];
			}
			return 1;
		}

		// if (dp[t][idx] > 0) {
		// 	return dp[t][idx];
		// }
		int sum = 0;

		sum += find(t+1,idx,idx);
		if (idx + 1 <= N) {
			sum += find(t + 1, idx + 1, idx + 1);
		}
		if (idx - 1 > 0) {
			sum += find(t + 1, idx - 1, idx - 1);
		}

		for (int i = 1; i <= N; i++) {
			if(i == target) continue;
			fire[i] += data[i];
		}

		return dp[t][idx] = sum;
	}

	public static int[] getMinusData() {
		int[] data = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			int cnt = 3;
			if (fire[i - 1] > 0) {
				cnt--;
			}
			if (fire[i + 1] > 0) {
				cnt--;
			}
			data[i] = cnt;
		}
		return data;
	}
}
