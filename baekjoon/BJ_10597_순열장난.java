package algo_202403;

import java.io.*;
import java.util.*;

public class BJ_10597_순열장난 {
	public static int N;
	public static int end;
	public static boolean[] visited;
	public static Stack<Integer> stack;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		String input = br.readLine();
		N = input.length();
		if (N <= 9) {
			end = N;
		} else {
			end = (N-9)/2+9;
		}

		visited = new boolean[end+1];
		stack = new Stack<>();

		find(input);
	}

	public static boolean find(String s) {
		if (s.equals("")) {
			for (int i : stack) {
				System.out.print(i +" ");
			}
			return true;
		}

		for (int i = 1; i <= 2; i++) {
			if(s.length() < i) continue;
			int num = Integer.parseInt(s.substring(0, i));
			if (num <= end && !visited[num]) {
				visited[num] = true;
				stack.push(num);
				boolean result = find(s.substring(i));
				if (result) {
					return true;
				}
				visited[num] = false;
				stack.pop();
			}
		}


		return false;
	}
}
