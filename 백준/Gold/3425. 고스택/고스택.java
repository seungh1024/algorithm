import java.io.*;
import java.util.*;

public class Main {
	public static long max = 1_000_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			List<String> list = new ArrayList<>();
			while (true) {
				String command = br.readLine();
				if (command.equals("QUIT")) {
					System.out.println(sb);
					return;
				} else if (command.equals("END")) {
					break;
				}
				list.add(command);
			}

			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				Stack<Long> stack = new Stack<>();
				Long num = Long.parseLong(br.readLine());
				stack.push(num);

				boolean flag = false;
				for (String s : list) {
					// System.out.println("command = "+ s + ", stack = "+stack);
					if (!run(s, stack)) {
						// sb.append("ERROR");
						flag = true;
						break;
					}
				}
				if (!flag && stack.size() == 1) {
					sb.append(stack.pop());
				} else {
					sb.append("ERROR");
				}
				sb.append("\n");
			}
			br.readLine();
			sb.append("\n");
		}

	}

	public static boolean run(String command, Stack<Long> stack) {
		long v1, v2, result;

		switch (command) {
			case "POP":
				if (isError(stack, 1)) {
					return false;
				}
				stack.pop();
				break;
			case "INV":
				if (isError(stack, 1)) {
					return false;
				}
				stack.push(-stack.pop());
				break;
			case "DUP":
				if (isError(stack, 1)) {
					return false;
				}
				stack.push(stack.peek());
				break;
			case "SWP":
				if (isError(stack, 2)) {
					return false;
				}
				v1 = stack.pop();
				v2 = stack.pop();
				stack.push(v1);
				stack.push(v2);
				break;
			case "ADD":
				if (isError(stack, 2)) {
					return false;
				}
				v1 = stack.pop();
				v2 = stack.pop();
				result = v1+v2;
				if (Math.abs(result) > max) {
					return false;
				}
				stack.push(result);
				break;
			case "SUB":
				if (isError(stack, 2)) {
					return false;
				}
				v1 = stack.pop();
				v2 = stack.pop();
				result = v2 - v1;
				if (Math.abs(result) > max) {
					return false;
				}
				stack.push(result);
				break;
			case "MUL":
				if (isError(stack, 2)) {
					return false;
				}
				v1 = stack.pop();
				v2 = stack.pop();
				result = v1 * v2;
				if (Math.abs(result) > max) {
					return false;
				}
				stack.push(result);
				break;
			case "DIV":
				if (isError(stack, 2)) {
					return false;
				}
				v1 = stack.pop();
				v2 = stack.pop();
				if (v1 == 0) {
					return false;
				}
				result = Math.abs(v2) / Math.abs(v1);
				if (!((v1 > 0 && v2 > 0) || (v1 < 0 && v2 < 0))) {
					result = -result;
				}
				stack.push(result);
				break;
			case "MOD":
				if (isError(stack, 2)) {
					return false;
				}
				v1 = stack.pop();
				v2 = stack.pop();
				if (v1 == 0) {
					return false;
				}

				result = Math.abs(v2) % v1;
				if (v2 < 0 && result >0) {
					result = -result;
				}
				stack.push(result);
				break;
			default:
				String[] split = command.split(" ");
				long x = Long.parseLong(split[1]);
				stack.push(x);
				break;
		}

		return true;
	}

	public static boolean isError(Stack<Long> stack, int size) {
		if (stack.size() < size) {
			return true;
		}

		return false;
	}
}