import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[] data;
	public static int[] count;
	public static int[] max;
	public static int size = 100001;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i]	= Integer.parseInt(st.nextToken());

		}
		count = new int[size];
		max = new int[size];

		Stack<Integer> left = new Stack<>();
		left.push(0);
		boolean[] flag = new boolean[size];
		for (int i = 1; i < N; i++) {
			int now = data[i];

			while (!left.isEmpty()) {
				int idx = left.pop();
				int small = data[idx];
				if (small > now) {
					left.push(idx);
					break;
				}
			}

			// System.out.println("left = "+left);
			if (left.size() > 0) {
				count[i] += left.size();
				max[i] = left.peek();
				flag[i] = true;
			}
			left.push(i);
		}
		// for (int i = 0; i < N; i++) {
		// 	System.out.println(max[i]);
		// }

		Stack<Integer> right = new Stack<>();
		right.push(N-1);
		for (int i = N - 2; i >= 0; i--) {
			int now = data[i];

			while (!right.isEmpty()) {
				int idx = right.pop();
				int small = data[idx];
				if (small > now) {
					right.push(idx);
					break;
				}
			}

			if (right.size() > 0) {
				count[i] += right.size();
				if (!flag[i]) {
					max[i] = right.peek();
				} else {
					int a = Math.abs(i - max[i]);
					int b = Math.abs(i-right.peek());
					if (b < a) {
						max[i] = right.peek();
					}
				}
			}
			right.push(i);
		}

		// System.out.println("====");
		// for (int i = 0; i < N; i++) {
		// 	System.out.println(max[i] + ", count = "+count[i]);
		// }
		// System.out.println("====");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			if (count[i] > 0) {
				sb.append(count[i]).append(" ").append(max[i]+1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		}

		System.out.println(sb);
	}
}