package algo_202406;

import java.io.*;
import java.util.*;

public class BJ_21943_연산최대로 {
	public static int N;
	public static int[] data;
	public static int P,Q;
	public static boolean[] visited;
	public static int result;
	public static int[] line;
	public static boolean[] check;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		P = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		visited = new boolean[N];
		visited[N-1] = true;
		check = new boolean[N];
		line = new int[N];
		result = 0;
		per(0);
		System.out.println(result);
	}

	public static void per(int index) {
		if (index >= N) {
			find(0,0);
		}

		for (int i = 0; i < N; i++) {
			if (!check[i]) {
				check[i] = true;
				line[index] = data[i];
				per(index+1);
				check[i] = false;
			}
		}
	}

	public static void find(int index, int count) {
		if (count == Q) {
			Stack<Integer> stack = new Stack<>();

			int sum = 0;
			for (int i = 0; i < N; i++) {
				sum += line[i];
				if (visited[i]) {
					stack.push(sum);
					sum = 0;
				}
			}
			if (sum != 0) {
				stack.push(sum);
			}
			// System.out.println(stack);

			while (stack.size() > 1) {
				int num1 = stack.pop();
				int num2 = stack.pop();
				stack.push(num1*num2);
			}

			result = Math.max(result,stack.pop());


			return;
		}

		if (index >= N-1) {
			return;
		}


		visited[index] = true;
		find(index+1,count+1);
		visited[index] = false;
		find(index+1,count);
	}
}
