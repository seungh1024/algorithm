

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		long[] attack = new long[N];
		long[] hp = new long[N];

		for (int i = 0; i < N; i++) {
			attack[i] = Long.parseLong(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			hp[i] = Long.parseLong(st.nextToken());
		}

		Queue<long[]> q = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			q.offer(new long[] {attack[i], hp[i],i+1});
		}

		long attackSum = 0;
		boolean check = false;
		while (true) {
			int size = q.size();
			// System.out.println("size = "+size);
			if(size <= 1) break;

			for (int i = 0; i < size; i++) {
				long[] now = q.poll();
				if (check) {
					attackSum -= now[0];
				}
				now[1] -= attackSum;
				if (now[1] > 0) {
					q.offer(now);
					attackSum += now[0];
				}
				// System.out.println(Arrays.toString(now) + ", attackSum = "+attackSum);
			}
			check = true;
		}

		long[] winner = q.poll();
		System.out.println(winner[2]);
	}
}

