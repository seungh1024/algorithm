package algo_202402;

import java.util.PriorityQueue;
import java.util.Queue;

public class P_요격시스템 {
	public static void main(String[] args) {
		P_요격시스템 test = new P_요격시스템();
		int[][] targets = {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}};
		int answer = test.solution(targets);
		int result = 3;
		if (answer == result) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}

	public int solution(int[][] targets) {
		int answer = 0;

		Queue<Data> pq = new PriorityQueue<>();
		for (int[] target : targets) {
			pq.offer(new Data(target[0], target[1]));
		}

		int start = -1;
		int end = 0;

		while (!pq.isEmpty()) {
			Data now = pq.poll();
			// System.out.println(now);

			if (now.start >= end && end != 0) {
				answer++;
				start = -1;
			}

			if (start == -1) { // 새로 그룹을 만들어야 하는 경우
				start = now.start;
				end = now.end;
			} else { // 기존 그룹에서 합치는 경우
				start = Math.max(start, now.start);
				end = Math.min(end, now.end);
			}
		}
		if (start != -1)
			answer++;
		return answer;
	}

	public static class Data implements Comparable<Data> {
		int start, end;

		public Data(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Data d) {
			return this.end - d.end;
		}

		@Override
		public String toString() {
			return ", key: " + start + ", value: " + end;
		}
	}
}
