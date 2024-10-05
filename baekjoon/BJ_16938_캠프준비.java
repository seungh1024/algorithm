package algo_202410;

import java.io.*;
import java.util.*;

public class BJ_16938_캠프준비 {
	public static int N,L,R, X;
	public static List<Integer> data;
	public static boolean[] visited;
	public static int result;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		data = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data.add(Integer.parseInt(st.nextToken()));
		}

		result = 0;
		visited = new boolean[N];
		find(0,0, false);

		System.out.println(result);
	}

	public static void find(int idx, int cnt, boolean check){
		if(cnt >= 2 && check){
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				if (visited[i]) {
					list.add(data.get(i));
				}
			}
			IntSummaryStatistics intSummaryStatistics = list.stream().mapToInt(Integer::intValue).summaryStatistics();
			int min = intSummaryStatistics.getMin();
			int max = intSummaryStatistics.getMax();
			long sum = intSummaryStatistics.getSum();

			if (sum >= L && sum <= R && max - min >= X) {
				// System.out.println("idx = "+idx + ", cnt = "+cnt);
				// System.out.println("min = "+min +", max= "+ max +", sum = "+sum + ", visited = "+Arrays.toString(visited));
				result++;
			}
		}

		if (cnt >= N || idx >= N) {
			return;
		}


		visited[idx] = true;
		find(idx+1,cnt+1, true);
		visited[idx] = false;
		find(idx+1,cnt, false);
	}
}
