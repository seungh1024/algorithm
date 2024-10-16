package algo_202410;

import java.io.*;
import java.util.*;

public class BJ_16168_퍼레이드 {
	public static int V, E;
	public static List<Integer>[] list;
	public static boolean[][] visited;
	public static boolean check = false;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		list = new ArrayList[V+1];
		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}

		int[] count = new int[V+1];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
			count[from]++;
			count[to]++;
		}

		int idx1 = 0; // 일반 최대값
		int max1 = 0;

		int idx2 = 0; // 홀수 최대값
		int max2 = 0;
		for (int i = 1; i <= V; i++) {

			if (max1 < count[i]) {
				max1 = count[i];
				idx1 = i;
			}
			if (count[i] % 2 == 1) {
				max2 = count[i];
				idx2 = i;
			}
		}


		visited = new boolean[V+1][V+1];

		find(idx1,0);
		if (idx2 > 0) {
			visited = new boolean[V+1][V+1];
			find(idx2,0);
		}
		if (check) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	public static void find(int idx, int cnt) {
		if (cnt == E) {
			check = true;
			return;
		}

		for (int next : list[idx]) {
			if (!visited[idx][next]) {
				visited[idx][next]= true;
				visited[next][idx] = true;
				find(next,cnt+1);
				// visited[idx][next]= false;
				// visited[next][idx] = false;
			}
		}
	}
}
// 5 6
// 1 2
// 1 3
// 1 4
// 1 5
// 2 3
// 4 5