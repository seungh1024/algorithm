package algo_202409;

import java.io.*;
import java.util.*;

public class BJ_10713_기차여행 {
	public static int N, M;
	public static long[] count;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		count = new long[N+1];
		for (int i = 1; i < M; i++) {
			int end = Integer.parseInt(st.nextToken());
			int left = Math.min(start, end);
			int right = Math.max(start, end);
			count[left]++;
			count[right]--;
			start = end;
		}
		for (int i = 1; i <= N; i++) {
			count[i] += count[i-1];
		}
		// System.out.println(Arrays.toString(count));


		long result = 0;
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			long cost = Long.parseLong(st.nextToken());
			long icCost = Long.parseLong(st.nextToken());
			long ic = Long.parseLong(st.nextToken());

			long totalCost = cost*count[i];
			long totalIc = ic + icCost*count[i];
			result += Math.min(totalCost, totalIc);
		}
		System.out.println(result);
	}

}
