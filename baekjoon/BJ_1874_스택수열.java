package algo_202409;

import java.io.*;
import java.util.*;

public class BJ_1874_스택수열 {
	public static int N;
	public static int[] data;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N];
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(br.readLine());
		}
		int idx = 0;
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if (!stack.isEmpty() && stack.peek() == data[idx]) {
				stack.pop();
				sb.append("-").append("\n");
				idx++;
				i--;
			} else {
				stack.push(i);
				sb.append("+").append("\n");
			}

			if (i == N && !stack.isEmpty()) {
				while(!stack.isEmpty()) {
					if (!stack.isEmpty() && stack.peek() == data[idx]) {
						stack.pop();
						sb.append("-").append("\n");
						idx++;
					} else {
						sb = new StringBuilder("NO");
						break;
					}
				}
			}
		}

		System.out.println(sb);
	}
}
