import java.io.*;
import java.util.*;


public class Main {
	public static int N;
	public static int[] data;
	public static List<Integer>[] list;
	public static int[][] dp;
	public static int result = 0;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N + 1];
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		int[] count = new int[N+1];
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
			count[from]++;
			count[to]++;
		}

		int start = 0;
		for (int i = 1; i <= N; i++) {
			if (count[i] == 1) {
				start = i;
				break;
			}
		}

		dp = new int[N+1][2];
		find(start, -1);

		System.out.println(Math.max(dp[start][0], dp[start][1]));
	}

	public static void find(int now, int last) {

		dp[now][0] = 0;
		dp[now][1] = data[now];

		for (int next : list[now]) {
			if(next == last) continue;
			find(next, now);

			dp[now][0] += Math.max(dp[next][0], dp[next][1]);
			dp[now][1] += dp[next][0];
		}



	}
}