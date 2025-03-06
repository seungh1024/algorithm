import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static Data[] data;
	public static String input;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		N = Integer.parseInt(br.readLine());

		data = new Data[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			int p = Integer.parseInt(st.nextToken());
			data[i] = new Data(s, p);
		}

		int size = input.length();
		int[] dp = new int[size+ 1];

		for (int i = 1; i <= size; i++) {
			for (Data d : data) {
				dp[i] = Math.max(dp[i], dp[i - 1] + 1);
				if (input.startsWith(d.s, i - 1)) {
					dp[i + d.s.length() - 1] = Math.max(dp[i + d.s.length() - 1], dp[i - 1] + d.p);
				}
			}
		}

		// System.out.println(Arrays.toString(dp));
		System.out.println(dp[size]);
	}

	public static class Data{
		String s;
		int p;

		public Data(String s, int p) {
			this.s = s;
			this.p = p;
		}
	}
}