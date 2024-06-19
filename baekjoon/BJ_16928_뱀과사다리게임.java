package algo_202406;

import java.io.*;
import java.util.*;

public class BJ_16928_뱀과사다리게임 {
	public static int N,M;
	public static int[] data = new int[101];
	public static int[] ladder = new int[101];
	public static int[] snake = new int[101];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			ladder[from] = to;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			snake[from] = to;
		}

		Arrays.fill(data, Integer.MAX_VALUE);
		data[1] = 0;

		Queue<Integer> q = new ArrayDeque<>();
		q.offer(1);
		while (!q.isEmpty()) {
			int now = q.poll();
			if(data[now] == Integer.MAX_VALUE) continue;

			for (int i = 1; i <= 6; i++) {
				int next = now+i;
				if(next > 100 ) continue;

				while(true){
					if (ladder[next] > 0) {
						next = ladder[next];
					} else if (snake[next] > 0) {
						next = snake[next];
					} else {
						break;
					}
				}

				if (data[next] > data[now] + 1) {
					q.offer(next);
					data[next] = data[now]+1;
				}

			}
		}
		// for (int i = 1; i < 100; i++) {
		// 	for (int j = 1; j <= 6; j++) {
		// 		int next = i+j;
		// 		if(next > 100 || data[i] == Integer.MAX_VALUE)continue;
		//
		// 		while(true){
		// 			if (ladder[next] > 0) {
		// 				next = ladder[next];
		// 			} else if (snake[next] > 0) {
		// 				next = snake[next];
		// 			} else {
		// 				break;
		// 			}
		// 		}
		//
		//
		// 		data[next] = Math.min(data[next], data[i] + 1);
		// 	}
		// }
		System.out.println(data[100]);
	}
}
