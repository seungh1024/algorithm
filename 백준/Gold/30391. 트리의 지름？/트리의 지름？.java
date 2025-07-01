

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int num = 1;
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= K; i++) {
			sb.append(num).append(" ").append(i + 1).append("\n");
			q.offer(i+1);
		}
		num = K+2;

		while (num <= N) {
			int now = q.poll();

			// System.out.println("now = "+now +", num = "+num);
			if (num + K-2 <= N) {
				int range = num + K - 2;
				while (num <= range) {
					q.offer(num);
					sb.append(now).append(" ").append(num++).append("\n");
				}

			} else {
				while (num <= N) {
					q.offer(num);
					sb.append(now).append(" ").append(num++).append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}

 //    1
 //  2 3 4
 // 5 6