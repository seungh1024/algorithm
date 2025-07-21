

import java.io.*;
import java.util.*;

public class Main {
	public static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		boolean[] visited = new boolean[N + 1];

		int range = (int)Math.sqrt(N)+1;
		long sum = 0;
		for (int i = 2; i < range; i++) {
			for (int j = i * 2; j <= N; j += i) {
				if(visited[j]) continue;
				visited[j] = true;
				sum += i;
			}
		}

		for (int i = 2; i <= N; i++) {
			if (!visited[i]) {
				sum += i;
			}
		}
		System.out.println(sum);
	}

}