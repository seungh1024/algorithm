

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			Data[] data = new Data[N + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				int num = Integer.parseInt(st.nextToken());
				int two = getCnt(num, 2);
				int five = getCnt(num, 5);
				data[i] = new Data(two, five);
			}

			Data[] dp = new Data[N + 1];
			for (int i = 1; i <= N; i++) {
				dp[i] = new Data(Integer.MAX_VALUE, Integer.MAX_VALUE);
			}
			dp[1] = data[1];
			for (int i = 2; i <= N; i++) {
				// System.out.println("i = "+i + " ==============");
				int range = Math.max(1, i - K - 1);
				// System.out.println("range = "+range);
				for (int j = i - 1; j >= range; j--) {
					if(i-j >K) continue;
					if(dp[j].two == Integer.MAX_VALUE || dp[j].five == Integer.MAX_VALUE) continue;

					int two = dp[j].two + data[i].two;
					int five = dp[j].five + data[i].five;
					int last = Math.min(two, five);
					int now = Math.min(dp[i].two, dp[i].five);

					int minTwo = Math.min(two, dp[i].two);
					int minFive = Math.min(five, dp[i].five);
					dp[i].two = minTwo;
					dp[i].five = minFive;
				}
				// System.out.println(Arrays.toString(dp));
			}


			sb.append(Math.min(dp[N].five, dp[N].two)).append("\n");
		}
		System.out.println(sb);
	}

	public static int getCnt(int num, int div) {
		int cnt = 0;
		while(num % div == 0) {
			num /= div;
			cnt++;
		}
		return cnt;
	}

	public static class Data{
		int two;
		int five;

		@Override
		public String toString() {
			return "Data{" +
				"two=" + two +
				", five=" + five +
				'}';
		}

		public Data(int two, int five) {
			this.two = two;
			this.five = five;
		}
	}
}
