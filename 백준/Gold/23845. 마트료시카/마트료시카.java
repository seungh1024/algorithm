

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] data = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(data);

		int[] dp = new int[100001];
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		for (int i = 0; i < N; i++) {
			pq.offer(data[i]);
			dp[data[i]]++;
		}


		long sum = 0;
		while (!pq.isEmpty()) {
			int now = pq.poll();
			if(dp[now] == 0) continue;

			long cnt = 0;
			for (int i = now; i > 0; i--) {
				if (dp[i] == 0) {
					break;
				}
				cnt++;
				dp[i]--;
			}
			sum += now*cnt;
		}
		System.out.println(sum);

	}
}
