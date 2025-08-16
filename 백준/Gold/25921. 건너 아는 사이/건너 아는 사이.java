

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long sum = 0;
		boolean[] visited = new boolean[N + 1];
		int range = (int)Math.sqrt(N);
		for (int i = 2; i <= range; i++) {
			for (int j = i+i; j <= N; j += i) {
				if (!visited[j]) {
					
					visited[j] = true;
					sum +=i;
				}
			}
		}
		for (int i = 2; i <= N; i++) {
			if(!visited[i]){
				sum += i;
			}
		}
		System.out.println(sum);
	}
}
