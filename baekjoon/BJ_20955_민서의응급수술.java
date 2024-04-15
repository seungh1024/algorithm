package algo_202403;

import java.util.*;
import java.io.*;

public class BJ_20955_민서의응급수술 {
	public static int[] parent;
	public static int N,M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		int count = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			if (!union(u, v)) {
				count++;
			}
		}

		Set<Integer> set = new HashSet<>();
		for (int i = 1; i <= N; i++) {
			set.add(getParent(i));
		}
		count += set.size()-1;

		System.out.println(count);
	}

	public static int getParent(int i) {
		if (i == parent[i]) {
			return i;
		}

		return parent[i] = getParent(parent[i]);
	}

	public static boolean union(int a, int b) {
		int pa = getParent(a);
		int pb = getParent(b);

		if (pa == pb) { // 이미 같은 경우 사이클이 생긴 것으로 판단
			return false;
		}

		if (pa <= pb) {
			parent[pb] = pa;
		} else {
			parent[pa] = pb;
		}

		return true;
	}
}
