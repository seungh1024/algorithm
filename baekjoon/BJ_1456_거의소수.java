package algo_202405;

import java.io.*;
import java.util.*;

public class BJ_1456_거의소수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());


		long range = 100_000_000_000_000L;
		int r = (int)Math.sqrt(range)+1;

		boolean[] visited = new boolean[r];
		int ac = 0;
		int bc = 0;
		for (int i = 2; i < r; i++) {
			for (int j = i * 2; j < r; j+=i) {
				visited[j] = true;
			}
			if (!visited[i]) {
				long num = i;
				long temp = i;

				long last = num;
				while(true){
					if (num > B/i) {
						// System.out.println(num);
						break;
					}
					num *= temp;
					if(num < A){
						ac++;
					}
					if (num <= B) {
						// System.out.println(num);
						bc++;
					}
					last = num;
				}
			}
		}

		System.out.println(bc-ac);

	}
}
