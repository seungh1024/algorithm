package algo_202406;

import java.io.*;
import java.util.*;

public class BJ_2109_순회강연 {
	public static int N;
	public static int[] dp;
	public static List<int[]> list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		dp = new int[10001];

		list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			list.add(new int[]{p, d});
		}

		Collections.sort(list,Comparator.comparing(i -> i[1]));
		//        for (int[] l : list) {
		//            System.out.println(Arrays.toString(l));
		//        }

		int result = 0;
		for (int i = 1; i <= N; i++) {
			int[] l = list.get(i-1);
			int p = l[0];
			int d = l[1];


			for (int j = d; j >= 1; j--) {
				dp[j] = Math.max(dp[j], dp[j - 1] + p);
				result = Math.max(dp[j], result);
			}
		}

		//        StringBuilder sb = new StringBuilder();
		//        for (int i = 0; i <= N; i++) {
		//            for (int j = 1; j <= 20; j++) {
		//                sb.append(dp[i][j]).append(" ");
		//            }
		//            sb.append("\n");
		//        }
		//
		//        System.out.println(sb);

		System.out.println(result);
	}
}
