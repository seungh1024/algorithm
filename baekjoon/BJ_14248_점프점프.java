package algo_202405;

import java.io.*;
import java.util.*;

public class BJ_14248_점프점프 {
	public static int N;
	public static int[] data;
	public static int s;
	public static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		s = Integer.parseInt(br.readLine());
		visited = new boolean[N];
		find(s-1);
		int result = 0;
		for (int i = 0; i < N; i++) {
			if (visited[i]) {
				result++;
			}
		}
		System.out.println(result);
	}

	public static void find(int now) {
		if (visited[now]) {
			return;
		}
		visited[now] = true;

		int jump = data[now];
		if (now - jump >= 0) {
			find(now-jump);
		}
		if (now + jump < N) {
			find(now+jump);
		}
	}

}
