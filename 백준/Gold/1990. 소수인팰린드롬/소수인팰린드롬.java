import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		boolean[] visited = new boolean[b + 1];

		for (int i = 2; i <= b; i++) {
			if(visited[i]) continue;
			for (int j = i*2; j <= b; j += i) {
				visited[j] = true;
			}

		}

		StringBuilder sb = new StringBuilder();
		for (int i = a; i <= b; i++) {
			if (!visited[i]) {
				if (check(i)) {
					sb.append(i).append("\n");
				}
			}
		}
		sb.append(-1);
		System.out.println(sb);

	}

	public static boolean check(int i) {
		String s = i + "";

		int left = 0;
		int right = s.length()-1;

		// System.out.println(s);
		while (left < right) {
			// System.out.println("left = "+left + ", right = "+right);
			if (s.charAt(left++) != s.charAt(right--)) {
				return false;
			}
		}

		return true;

	}
}