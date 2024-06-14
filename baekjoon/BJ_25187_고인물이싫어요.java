package algo_202406;

import java.io.*;
import java.util.*;

public class BJ_25187_고인물이싫어요 {
	public static int N,M, Q;
	public static int[] water;
	public static int[] parent;
	public static int[] sum;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		water = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			water[i] = Integer.parseInt(st.nextToken());
			if (water[i] == 0) {
				water[i] = -1;
			}
		}
		parent = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a,b);
		}

		sum = new int[N+1];
		for (int i = 1; i <= N; i++) {
			int p = getParent(i);
			int w = water[i];
			sum[p] += w;
		}

		// System.out.println(Arrays.toString(sum));

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Q; i++) {
			int q = Integer.parseInt(br.readLine());
			if (sum[getParent(q)] > 0) {
				sb.append(1);
			} else {
				sb.append(0);
			}
			sb.append("\n");
		}
		System.out.println(sb);

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
