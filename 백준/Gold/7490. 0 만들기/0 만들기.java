
import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static char[] arr;
	public static char[] data = {'+', '-', ' '};
	public static List<StringBuilder> list;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new char[N-1];
			list = new ArrayList<>();
			find(0);
			Collections.sort(list);
			for (StringBuilder s : list) {
				sb.append(s).append("\n");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void find(int idx) {
		if (idx == N - 1) {
			StringBuilder sb = new StringBuilder();
			Deque<Integer> dq = new ArrayDeque<>();
			for (int i = 1; i <= N; i++) {
				dq.offer(i);
			}

			sb.append(dq.peek());

			for (int i = 0; i < N - 1; i++) {
				sb.append(arr[i]).append(i+2);
			}


			int i = 0;
			Stack<Integer> stack = new Stack<>();
			stack.push(dq.poll());
			while (!dq.isEmpty()) {
				if (arr[i] != ' ') {
					stack.push(dq.poll());
				} else {
					int last = stack.pop();
					last*=10;
					last+=dq.poll();
					stack.push(last);
				}
				i++;
			}
			while (!stack.isEmpty()) {
				dq.offerFirst(stack.pop());
			}
			for (int j = 0; j < N - 1; j++) {
				if(arr[j] == ' ')continue;
				int a = dq.poll();
				int b = dq.poll();

				if (arr[j] == '+') {
					dq.offerFirst(a + b);
				} else {
					dq.offerFirst(a - b);
				}
			}

			if (dq.peek() == 0) {
				list.add(sb);
			}



			return;
		}

		for (char c : data) {
			arr[idx] = c;
			find(idx + 1);
		}
	}
}
