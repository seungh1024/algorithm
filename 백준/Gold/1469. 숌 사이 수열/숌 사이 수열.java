

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[] data;
	public static int[] arr;
	public static boolean[] visited;
	public static String result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		arr = new int[N * 2];
		Arrays.sort(data);
		Arrays.fill(arr, -1);

		visited = new boolean[N];
		boolean result = find(0, 0);
		if (result) {
			StringBuilder sb = new StringBuilder();
			for (int i : arr) {
				sb.append(i).append(" ");
			}
			System.out.println(sb);
		} else {
			System.out.println(-1);
		}
	}

	public static boolean find(int idx, int arrIdx){
		if (idx >= N) {
			return true;
		}
		if (arrIdx >= N * 2) {
			return false;
		}
		if(arr[arrIdx] !=-1){
			if (find(idx, arrIdx + 1)) {
				return true;
			}
			return false;
		}

		for (int i = 0; i < N; i++) {
			if(visited[i]) continue;
			int v = data[i];
			if (arrIdx+v+1 < N*2 &&arr[arrIdx] == -1 && arr[arrIdx + v+1] == -1) {
				arr[arrIdx] = v;
				arr[arrIdx+v+1] = v;
				visited[i] = true;
				if (find(idx + 1, arrIdx + 1)) {
					return true;
				}
				visited[i] = false;
				arr[arrIdx+v+1] = -1;
				arr[arrIdx] = -1;
			}
		}

		return false;
	}
}
