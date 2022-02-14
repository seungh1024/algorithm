package 22_02_07.Silver 4_10828_스택;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Stack<String> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			if (input.equals("push")) {
				stack.push(st.nextToken());
			} else if (input.equals("pop")) {

				if (!stack.isEmpty()) {
					System.out.println(stack.pop());
				}else {
					System.out.println(-1);
				}
			} else if (input.equals("size")) {
				System.out.println(stack.size());
			} else if (input.equals("empty")) {
				System.out.println(stack.isEmpty()?1:0);
			} else {
				if(!stack.isEmpty()) {
					System.out.println(stack.peek());
				}else {
					System.out.println(-1);
				}
			}
		}
	}
}