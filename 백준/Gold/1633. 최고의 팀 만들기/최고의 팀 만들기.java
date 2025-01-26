import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Data> list = new ArrayList<>();

		while (true) {
			String input = br.readLine();
			if (input == null || input.isEmpty()) {
				break;
			}
			String[] data = input.split(" ");
			int w = Integer.parseInt(data[0]);
			int b = Integer.parseInt(data[1]);
			list.add(new Data(w, b));
		}

		int N = list.size();
		int[][][] dp = new int[N][16][16];
		dp[0][1][0] = list.get(0).w;
		dp[0][0][1] = list.get(0).b;

		int result = 0;
		for (int i = 1; i < N; i++) {
			Data now = list.get(i);
			for (int j = 0; j <= 15; j++) {
				for (int k = 0; k <= 15; k++) {
					int temp1 = 0;
					int temp2 = 0;
					if (j > 0) {
						temp1 = Math.max(temp1, dp[i - 1][j - 1][k] + now.w);
					}
					if (k > 0) {
						temp2 = Math.max(temp2, dp[i - 1][j][k - 1] + now.b);
					}
					dp[i][j][k] = Math.max(temp1, temp2);
					dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j][k]);
				}
			}
			result = Math.max(result, dp[i][15][15]);
		}
		System.out.println(result);
	}

	public static class Data{
		int w;
		int b;

		public Data(int w, int b) {
			this.w = w;
			this.b = b;
		}

		@Override
		public String toString() {
			return "Data{" +
				"w=" + w +
				", b=" + b +
				'}';
		}
	}
}