

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[] input;
	public static boolean[] check;
	public static int[] data;
	public static boolean[] operator;
	public static int P,Q;
	public static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		data = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		P = Integer.parseInt(st.nextToken()); // 더하기가 true
		Q = Integer.parseInt(st.nextToken());

		operator = new boolean[P + Q];
		check = new boolean[N];
		per(0);
		System.out.println(result);
	}

	public static void per(int idx) {
		if (idx == N) {
			find(0, 0);
			return;
		}
		for (int i = 0; i < N; i++) {
			if(check[i]) continue;
			check[i] = true;
			data[idx] = input[i];
			per(idx+1);
			check[i] = false;
		}
	}

	public static void find(int idx, int cnt) {
		if (cnt == P) {
			Queue<Integer> q = new ArrayDeque<>();
			for (int i = 1; i < N; i++) {
				q.offer(data[i]);
			}
			Stack<Integer> stack = new Stack<>();
			stack.push(data[0]);

			int oi = 0;
			while (!q.isEmpty()) {
				int now = q.poll();
				if (operator[oi]) { // +연산자 있는 경우
					int last = stack.pop();
					stack.push(now + last);
				} else {
					stack.push(now);
				}
				oi++;
			}

			// System.out.println(Arrays.toString(operator));
			// System.out.println(stack);

			while (stack.size() > 1) {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(a * b);
			}

			result = Math.max(result, stack.pop());

			return;
		}
		if(idx >= P+Q)return;

		operator[idx] = true;
		find(idx + 1, cnt + 1);
		operator[idx] = false;
		find(idx + 1, cnt);
	}
}
