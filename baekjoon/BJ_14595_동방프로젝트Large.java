package algo_202406;

import java.io.*;
import java.util.*;

public class BJ_14595_동방프로젝트Large {
	public static int N, M;
	public static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			union(a,b);
		}

		// System.out.println(Arrays.toString(parent));
		int min = getParent(N);
		for (int i = N; i > 0; i--) {
			min = Math.min(min,getParent(i));
			parent[i] = min;
		}

		Set<Integer> set = new HashSet<>();
		for (int i = 1; i <= N; i++) {
			set.add(getParent(i));
		}
		// System.out.println(Arrays.toString(parent));

		System.out.println(set.size());
	}

	public static int getParent(int i) {
		if (i == parent[i]) {
			return i;
		}

		return parent[i] = getParent(parent[i]);
	}

	public static void union(int a, int b) {
		int pa = getParent(a);
		int pb = getParent(b);

		if (pa <= pb) {
			parent[pb] = pa;
		} else {
			parent[pa] = pb;
		}

	}
}
