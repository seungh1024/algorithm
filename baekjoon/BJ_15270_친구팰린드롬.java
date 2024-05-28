package algo_202405;

import java.io.*;
import java.util.*;

public class BJ_15270_친구팰린드롬 {
	public static int N,M;
	public static List<int[]> list;
	public static boolean[] visited;
	public static int result;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		if (M == 0) {
			System.out.println(1);
			return;
		}

		list = new ArrayList<>();


		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.add(new int[] {a, b});
		}

		visited = new boolean[N+1];
		result = 0;
		find(0,0);
		if (result < N) {
			result++;
		}
		System.out.println(result);
	}

	public static void find(int index, int count) {
		if (index >= M) {
			result = Math.max(result, count);
			return;
		}

		int[] now = list.get(index);
		if (!visited[now[0]] && !visited[now[1]]) {
			visited[now[0]] = true;
			visited[now[1]] = true;
			find(index+1,count+2);
			visited[now[0]] = false;
			visited[now[1]] = false;
		}

		find(index+1,count);
	}

}
