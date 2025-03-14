import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		Stack<int[]> stack = new Stack<>();
		int[] left = new int[N];
		int[] leftIdx = new int[N];
		stack.push(new int[] {0, data[0]});
		for (int i = 1; i < N; i++) {
			while (!stack.isEmpty() && stack.peek()[1] <= data[i]) {
				stack.pop();
			}
			left[i] = stack.size();
			if (!stack.isEmpty()) {
				leftIdx[i] = stack.peek()[0]+1;
			}
			stack.push(new int[] {i, data[i]});
		}

		// System.out.println(Arrays.toString(left));

		int[] right = new int[N];
		int[] rightIdx = new int[N];
		stack = new Stack<>();
		stack.push(new int[] {N - 1, data[N - 1]});
		for (int i = N-1; i >= 0; i--) {
			while (!stack.isEmpty() && stack.peek()[1] <= data[i]) {
				stack.pop();
			}

			right[i] = stack.size();
			if (!stack.isEmpty()) {
				rightIdx[i] = stack.peek()[0]+1;
			}
			stack.push(new int[] {i, data[i]});
		}

		// System.out.println(Arrays.toString(right));
		int[] idx = new int[N];
		for (int i = 0; i < N; i++) {
			boolean flag = false;
			if (leftIdx[i] == 0 && rightIdx[i] != 0) {
				idx[i] = rightIdx[i];
				flag = true;
			} else if (leftIdx[i] != 0 && rightIdx[i] == 0) {
				idx[i] = leftIdx[i];
				flag = true;
			}

			if(flag) continue;


		 	if (Math.abs(leftIdx[i] - i-1) <= Math.abs(rightIdx[i] - i-1)) {
				idx[i] = leftIdx[i];
			} else {
				idx[i] = rightIdx[i];
			}
		}
		// System.out.println(Arrays.toString(leftIdx));
		// System.out.println(Arrays.toString(rightIdx));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			if (left[i] + right[i] == 0) {
				sb.append(0);
			} else {
				sb.append(left[i] + right[i]).append(" ").append(idx[i]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
