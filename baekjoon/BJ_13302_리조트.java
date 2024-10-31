package algo_202410;

import java.io.*;
import java.util.*;

public class BJ_13302_리조트 {
	public static int N, M;
	public static int[] dp;
	public static boolean[] check;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dp = new int[N+1];
		check = new boolean[N+1];
		if (M > 0) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				int idx = Integer.parseInt(st.nextToken());
				check[idx] = true;
			}
		}

		find();
		System.out.println(dp[N]);
		// System.out.println(Arrays.toString(dp));
	}

	public static void find() {
		Queue<Data> q = new ArrayDeque<>();
		q.offer(new Data(0, 0,0));
		dp[N] = Integer.MAX_VALUE;
		int[][] visited = new int[N][50];

		while (!q.isEmpty()) {
			Data now = q.poll();
			// System.out.println(now);

			if (now.day >= N) {
				dp[N] = Math.min(dp[N], now.money);
				continue;
			}

			if (visited[now.day][now.coupon] != 0 && visited[now.day][now.coupon] <= now.money) {
				continue;
			}
			visited[now.day][now.coupon] = now.money;

			if (now.day+1 <= N && check[now.day+1]) {
				q.offer(new Data(now.day + 1, now.money, now.coupon));
				continue;
			}
			// System.out.println("?");

			// if (now.day + 1 <= N && dp[now.day + 1] > now.money + 10000) {
			// 	dp[now.day+1] = now.money+10000;
			// }
			q.offer(new Data(now.day + 1, now.money + 10000, now.coupon));
			// if (now.day + 3 <= N && dp[now.day + 3] > now.money + 25000) {
			// 	dp[now.day+3] = now.money+25000;
			// }
			q.offer(new Data(now.day + 3, now.money+25000, now.coupon + 1));
			// if (now.day + 5 <= N && dp[now.day + 5] > now.money + 37000) {
			// 	dp[now.day + 5] = now.money + 37000;
			// }
			q.offer(new Data(now.day + 5, now.money+37000, now.coupon + 2));
			if (now.coupon >= 3) {
				q.offer(new Data(now.day + 1, now.money, now.coupon - 3));
			}
		}
	}

	public static class Data{
		int day;
		int money;
		int coupon;

		public Data(int day,int money, int coupon){
			this.day = day;
			this.money = money;
			this.coupon = coupon;
		}

		public String toString(){
			return "day = "+day + ", money = "+money +", coupon = "+coupon;
		}
	}
}
