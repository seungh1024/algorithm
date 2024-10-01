package algo_202410;

import java.io.*;
import java.util.*;

public class BJ_15663_N과M {
	public static int N, M;
	public static int[] data;
	public static boolean[] visited;
	public static Set<String> set;
	public static StringBuilder result;
	public static int[] per;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		data = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(data);

		set = new HashSet<>();
		visited = new boolean[N];
		result = new StringBuilder();
		per = new int[M];
		find(0,0);
		System.out.println(result);
	}

	public static void find(int idx, int cnt){
		if(cnt == M){
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < M; i++) {
				sb.append(per[i]);
				if (i != M - 1) {
					sb.append(" ");
				}

			}

			if (sb.length() > 0) {
				if (!set.contains(sb.toString())) {
					set.add(sb.toString());
					result.append(sb).append("\n");
				}
			}
			return;
		}
		if(idx >= N){
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				per[idx] = data[i];
				find(idx+1,cnt+1);
				visited[i] = false;
			}
		}
	}
}
