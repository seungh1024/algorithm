

import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static List<Integer> list1, list2;
	public static int[][][] dp;
	public static int zeroCnt1,zeroCnt2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int l = Integer.parseInt(br.readLine());
		list1 = new ArrayList<>();
		list2 = new ArrayList<>();
		zeroCnt1 = inputData(list1, l, br);
		zeroCnt2 = inputData(list2, l, br);

		N = list1.size();
		M = list2.size();

		dp = new int[N+1][M+1][zeroCnt1+zeroCnt2+1];

		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= M; j++) {

				Arrays.fill(dp[i][j], Integer.MIN_VALUE);
			}
		}
		int result = find(0, 0, 0, 0);
		System.out.println(result);

	}

	public static int find(int idx1, int idx2, int cnt1, int cnt2) {
		if (idx1 == N && idx2 == M && cnt1 == zeroCnt1 && cnt2 == zeroCnt2) {
			return 0;
		}

		if (dp[idx1][idx2][cnt1+cnt2] != Integer.MIN_VALUE) {
			return dp[idx1][idx2][cnt1+cnt2];
		}

		int max = Integer.MIN_VALUE;
		if (idx1 < N && idx2 < M) {
			int v = list1.get(idx1) * list2.get(idx2) + find(idx1 + 1, idx2 + 1, cnt1, cnt2);
			max = Math.max(max, v);
		}
		if (idx1 < N && cnt2 < zeroCnt2) {
			int v = find(idx1 + 1, idx2, cnt1, cnt2 + 1);
			max = Math.max(max, v);
		}
		if (cnt1 < zeroCnt1 && idx2 < M) {
			int v = find(idx1, idx2 + 1, cnt1 + 1, cnt2);
			max = Math.max(max, v);
		}
		if (cnt1 < zeroCnt1 && cnt2 < zeroCnt2) {
			int v = find(idx1, idx2, cnt1 + 1, cnt2 + 1);
			max = Math.max(max, v);
		}

		return dp[idx1][idx2][cnt1+cnt2] = max;
	}

	public static int inputData(List<Integer> list, int l, BufferedReader br) throws IOException{
		int zeroCnt = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < l; i++) {
			int input = Integer.parseInt(st.nextToken());
			if (input != 0) {
				list.add(input);
			} else {
				zeroCnt++;
			}
		}

		return zeroCnt;
	}
}

