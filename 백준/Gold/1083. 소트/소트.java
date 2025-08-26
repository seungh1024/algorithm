

import java.io.*;
import java.util.*;

public class Main {
	public static int N, S;
	public static int[] data;
	public static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		data = new int[N];
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		S = Integer.parseInt(br.readLine());

		int head = 0;
		while (S > 0 && head<N) {
			int idx = 0;
			int max = data[head];

			int range = Math.min(N, head + S+1);
			for(int i = head+1; i < range; i++){
				if(data[i] > max){
					idx = i;
					max = data[i];
				}

			}

			int minus = idx-head;
			// System.out.println("head = "+head + ", idx = "+idx + ", minus = "+minus + ", S = "+S);

			if(S-minus >= 0 && idx > head) {

				S-= minus;
				Queue<Integer> q = new ArrayDeque<>();
				for(int i = 0; i < head; i++){
					q.offer(data[i]);
				}
				q.offer(data[idx]);

				for (int i = head; i < N; i++) {
					if(i != idx){
						q.offer(data[i]);
					}
				}
				idx = 0;
				while (!q.isEmpty()) {
					data[idx++] = q.poll();
				}
				// System.out.println(Arrays.toString(data));
			}
			head++;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(data[i]).append(" ");
		}
		System.out.println(sb);
	}
}
