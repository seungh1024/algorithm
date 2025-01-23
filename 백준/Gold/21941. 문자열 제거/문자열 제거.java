import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String data = br.readLine();
		int M = Integer.parseInt(br.readLine());
		List<Data> list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			int cost = Integer.parseInt(st.nextToken());

			list.add(new Data(input, cost));
		}

		int N = data.length();
		int[] dp = new int[N+1];
		for (int i = 1; i <= N; i++) {
			for (Data d : list) {
				
				dp[i] = Math.max(dp[i], dp[i - 1]+1);
				if (data.startsWith(d.s, i-1)) {
					// System.out.println("?");
					// System.out.println("i = "+i +", string = "+d.s);
					dp[i + d.s.length()-1] = Math.max(dp[i + d.s.length()-1], dp[i-1] + d.cost);
				}
			}
		}
		// System.out.println(Arrays.toString(dp));
		System.out.println(dp[N]);
	}

	public static class Data{
		String s;
		int cost;

		public Data(String s, int cost) {
			this.s = s;
			this.cost = cost;
		}
	}
}