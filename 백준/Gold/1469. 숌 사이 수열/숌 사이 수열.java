

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[] data;
	public static boolean[] visited;
	public static int[] arr;
	public static List<String> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(data);

		arr = new int[N * 2];
		Arrays.fill(arr, -1);

		if (!find(0)) {
			System.out.println(-1);
		}
	}

	public static boolean find(int idx) {
		// System.out.println("idx = "+idx + ", arr = "+Arrays.toString(arr));
		if (idx == 2*N) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 2 * N; i++) {
				sb.append(arr[i]).append(" ");
			}
			System.out.println(sb);
			return true;
		}

		if (arr[idx] != -1) {
			return find(idx + 1);
		}

		for (int i = 0; i < N; i++) {
			int v = data[i];
			if(visited[i]) continue;
			int r = idx+v+1;
			if(r >= 2*N || arr[r] != -1) continue;
			visited[i] = true;
			arr[idx] = v;
			arr[r] = v;
			if (find(idx + 1)) {
				return true;
			}
			visited[i] = false;
			arr[idx] = -1;
			arr[r] = -1;
		}

		return false;
	}
}
