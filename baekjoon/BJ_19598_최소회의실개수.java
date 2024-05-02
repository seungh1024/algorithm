package algo_202404;

import java.io.*;
import java.util.*;
public class BJ_19598_최소회의실개수 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 기본 입력 데이터는 시작이 빠른게 먼저 나옴
		Queue<int[]> data = new PriorityQueue<>((o1,o2)->{
			return o1[0] - o2[0];
		});
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int emd = Integer.parseInt(st.nextToken());

			data.offer(new int[] {start, emd});
		}

		// 끝이 빠른게 먼저
		Queue<int[]> room = new PriorityQueue<>((o1,o2)->{
			return o1[1] - o2[1];
		});

		while (!data.isEmpty()) {
			int[] now = data.poll();
			if (!room.isEmpty()) {
				int[] last = room.poll();
				// System.out.println("now = "+Arrays.toString(now));
				// System.out.println("last = "+Arrays.toString(last));
				if (last[1] <= now[0]) { // 이어붙임
					last[1] = now[1];
					room.offer(last);
				} else {
					room.offer(last);
					room.offer(now);
				}
			} else {
				room.offer(now);
			}
		}

		System.out.println(room.size());
	}
}
