package algo_202406;

import java.io.*;
import java.util.*;

public class BJ_15659_연산자끼워넣기3 {
	public static int N;
	public static int[] data;
	public static int[] operator;
	public static int[] line;
	public static boolean[] visited;

	public static int max,min;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		operator = new int[4];
		st = new StringTokenizer(br.readLine());
		int index = 0;
		for (int i = 0; i < 4; i++) {
			int value = Integer.parseInt(st.nextToken());
			for (int j = 0; j < value; j++) {
				operator[i] ++;
			}
		}

		line = new int[N-1];
		visited = new boolean[4];
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		per(0);
		System.out.println(max);
		System.out.println(min);
	}

	public static void per(int index) {
		if (index >= N-1) {

			Deque<Integer> deque = new ArrayDeque<>();
			int d = 0;
			deque.offerLast(data[d++]);

			List<Integer> op = new ArrayList<>();
			// *와 /를 먼저 연산
			for (int i = 0; i < N - 1; i++) {
				if (line[i] == 2) { // x
					int left = deque.pollLast();
					int right = data[d++];
					deque.offerLast(left*right);
				} else if (line[i] == 3) { // /
					int left = deque.pollLast();
					int right = data[d++];
					deque.offerLast(left/right);
				} else {
					deque.offerLast(data[d++]);
					op.add(line[i]);
				}
			}

			// System.out.println(op);
			// System.out.println("deque = "+deque);
			int size = op.size();
			for (int i = 0; i < size; i++) {
				if (op.get(i) == 0) {
					int left = deque.pollFirst();
					int right = deque.pollFirst();
					deque.offerFirst(left+right);
				} else if (op.get(i) == 1) {
					int left = deque.pollFirst();
					int right = deque.pollFirst();
					deque.offerFirst(left-right);
				}
				// System.out.println("? = "+deque);
			}

			int result = deque.poll();
			// System.out.println("result = "+result);
			min = Math.min(min, result);
			max = Math.max(max, result);


			return;
		}

		for (int i = 0; i < 4; i++) {
			if (operator[i] > 0) {
				// visited[i] = true;
				operator[i]--;
				line[index] = i;
				per(index+1);
				// visited[i] = false;
				operator[i]++;
			}
		}
	}
}
