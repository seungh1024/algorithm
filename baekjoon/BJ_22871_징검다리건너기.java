package algo_202403;

import java.io.*;
import java.util.*;

public class BJ_22871_징검다리건너기 {
	public static int N;
	public static int[] data;
	public static long[][] power;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		power = new long[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				power[i][j] = ((long)j-(long)i)*(1+(long)Math.abs(data[i]-data[j]));
			}
		}

		long result = find();
		System.out.println(result);
	}

	public static long find() {
		long start = 0;
		long end = 5_000_000_001L;

		while (start < end) {
			long mid = (start + end)/2;

			if (isValid(mid)) {
				end = mid;
			} else {
				start = mid+1;
			}
		}

		return start;
	}

	public static boolean isValid(long K) {
		boolean[] visited = new boolean[N];
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		visited[0] = true;

		while (!stack.isEmpty()) {
			int now = stack.pop();
			if (now == N - 1) {
				return true;
			}

			for (int i = now + 1; i < N; i++) {
				if (!visited[i] && power[now][i] <= K) {
					visited[i] = true;
					stack.push(i);
				}
			}
		}

		return false;
	}
}
