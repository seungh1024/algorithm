

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		Stack<int[]> stack = new Stack<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			stack.push(new int[] {a, b});
			// union(a, b);
			// System.out.println(Arrays.toString(parent));
		}
		while (!stack.isEmpty()) {
			int[] now = stack.pop();
			parent[now[0]] = parent[now[1]];
			// System.out.println(Arrays.toString(parent));
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(parent[i]).append(" ");
		}
		System.out.println(sb);
	}

}
