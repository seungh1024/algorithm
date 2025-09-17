

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		PriorityQueue<int[]> pq =new PriorityQueue<>(Comparator.comparingInt(o->o[1]));
		pq.offer(new int[] {K, 0});
		int[] dp = new int[100001];
		Arrays.fill(dp, Integer.MAX_VALUE);
		while (!pq.isEmpty()) {
			int[] now = pq.poll();

			if (now[0] == N) {
				System.out.println(now[1]);
				break;
			}

			if (now[0] > N) {
				if (now[0] % 2 == 0 && dp[now[0]/2] > now[1]) {
					dp[now[0]/2] = now[1];
					pq.offer(new int[] {now[0] / 2, now[1]});
				}
			}

			if (now[0] + 1 <= 100000 && dp[now[0] + 1] > now[1] + 1) {
				dp[now[0]+1] = now[1]+1;
				pq.offer(new int[] {now[0] + 1, now[1] + 1});
			}
			if (now[0] - 1 >= 0 && dp[now[0] - 1] > now[1] + 1) {
				dp[now[0]-1] = now[1]+1;
				pq.offer(new int[] {now[0] - 1, now[1] + 1});
			}
		}

	}
}
