

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] U = new int[M];
		int[] V = new int[M];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			U[i] = u;
			V[i] = v;
		}

		int[] drink = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			drink[i] = i;
		}
		for (int i = M - 1; i >= 0; i--) {
			int u = U[i];
			int v = V[i];
			drink[u] = drink[v];
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(drink[i]).append(" ");
		}
		System.out.println(sb);
	}
}
