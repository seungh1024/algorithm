import java.io.*;
import java.util.*;

public class Main {
	public static Stack<Integer> stack;
	public static boolean[] visited;
	public static int N;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		if (input.length() <= 9) {
			N = input.length();
		} else {
			N = (input.length()-9)/2+9;
		}

		visited = new boolean[N + 1];
		stack = new Stack<>();
		find(input);

	}

	public static boolean find(String s) {
		if (s.equals("")) {
			for (int i : stack) {
				System.out.print(i + " ");
			}
			return true;
		}
		for (int i = 1; i <= 2; i++) {
			if(s.length() < i) continue;
			String sub = s.substring(0, i);
			int num = Integer.parseInt(sub);
			if (num <= N && !visited[num]) {
				visited[num] = true;
				stack.push(num);
				if (find(s.substring(i))) {
					return true;
				}
				visited[num] = false;
				stack.pop();
			}
		}

		return false;
	}
}