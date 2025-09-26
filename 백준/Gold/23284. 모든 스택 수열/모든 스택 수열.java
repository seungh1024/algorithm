

import java.io.*;
import java.util.*;

public class Main {

	public static int[] arr;
	public static int[] stack;
	public static List<String> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		stack = new int[N];
		list = new ArrayList<>();
		find(0, 0, 1, N);

		StringBuilder sb = new StringBuilder();
		for (int i = list.size()-1; i >= 0; i--) {

			sb.append(list.get(i)).append("\n");
		}
		System.out.println(sb);

	}

	public static void find(int ai, int si, int num, int N) {
		if (num > N) {
			// System.out.println("ai = "+ai + ", si = "+si);
			// System.out.println("arr = "+Arrays.toString(arr));
			// System.out.println("stack = "+Arrays.toString(stack));
			for (int i = si - 1; i >= 0; i--) {
				arr[ai++] = stack[i];
			}
			// System.out.println("new arr  = "+Arrays.toString(arr));
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				sb.append(arr[i]).append(" ");
			}
			list.add(sb.toString());
			return;
		}

		stack[si] = num;
		find(ai, si + 1, num + 1, N);
		// stack[ai] = 0;

		if (si - 1 >= 0) {
			arr[ai] = stack[si-1];
			stack[si-1] = 0;
			find(ai + 1, si - 1, num, N);
			stack[si-1] = arr[ai];
			arr[ai] = 0;
		}
	}
}
