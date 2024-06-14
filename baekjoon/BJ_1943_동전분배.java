package algo_202406;

import java.io.*;
import java.util.*;

public class BJ_1943_동전분배 {
	public static int N;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 0; t < 3; t++) {
			N = Integer.parseInt(br.readLine());

			int total = 0;
			List<int[]> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int count = Integer.parseInt(st.nextToken());
				// for (int j = 0; j < count; j++) {
				// 	list.add(c);
				// }
				list.add(new int[] {c, count});
				total += (c * count);
			}

			// Collections.sort(list,Comparator.reverseOrder());
			boolean[] dp = new boolean[total+1];
			dp[0] = true;

			for (int i = 0; i < list.size(); i++) {
				int[] now = list.get(i);
				for (int j = total/2; j >= now[0]; j--) {
					if (dp[j-now[0]]) {
						for (int k = 0; k < now[1] && j + k * now[0] <= total / 2; k++) {
							dp[j+k*now[0]] = true;
						}
						// dp[j] = true;
					}
				}
				if (dp[total / 2]) {
					break;
				}
			}

			if (total % 2 == 0 && dp[total / 2]) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}
}
