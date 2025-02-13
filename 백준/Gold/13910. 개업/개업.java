import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<>();
		int[] dp = new int[N+1];
		for (int i = 0; i < M; i++) {
			int value = Integer.parseInt(st.nextToken());
			list.add(value);
			dp[value] = 1;
		}
		int size = list.size();
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				int value = list.get(i) + list.get(j);
				if (value == N) {
					System.out.println(1);
					return;
				}
				if(value > N)continue;
				set.add(value);
				dp[value] = 1;
			}
		}
		list.addAll(set);

		// Arrays.fill(dp,Integer.MAX_VALUE);
		for (int v : list) {
			// System.out.println("v = "+v);
			for (int i = 1; i <= N; i++) {
				if(i < v || dp[i-v] == 0) continue;
				
				else if (dp[i] == 0) {
					dp[i] = dp[i - v] + 1;
				} else {
					dp[i] = Math.min(dp[i], dp[i - v] + 1);
				}
			}
			// System.out.println(Arrays.toString(dp));
		}

		// for (int i = 1; i <= N; i++) {
		// 	for (int v : list) {
		// 		if(i < v) break;
		// 		if (i == v) {
		// 			dp[i] = 1;
		// 			break;
		// 		}
		// 		else if (dp[i - v] != 0) {
		// 			dp[i] = Math.min(dp[i], dp[i - v] + 1);
		// 		} else if (dp[i - v] == 0) {
		// 			dp[i] = dp[i - v] + 1;
		// 		}
		// 	}
		// }

		if (dp[N] == 0) {
			dp[N] = -1;
		}
		System.out.println(dp[N]);

	}
}