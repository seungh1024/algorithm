

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dp = new int[100001];
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			pq.offer(num);
			dp[num]++;
		}

		long sum = 0;
		while (!pq.isEmpty()) {
			int now = pq.poll();
			if(dp[now] ==0) continue;

			long cnt = 0;
			for (int i = now; i > 0; i--) {
				if (dp[i] == 0) {
					break;
				}
				cnt++;
				dp[i]--;
			}
			sum += cnt*now;
		}

		System.out.println(sum);

	}
}
