

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int minus = 0;
		int idx = 0;
		int water = K;
		while (true) {
			idx += A;
			// System.out.println("idx = "+idx + ", minus = "+minus +", water = "+water);
			if (water <= minus) {
				break;
			}
			if (idx >= N) {
				water+=B;
				idx %= N;
			}
			minus++;
		}

		System.out.println(minus);
	}
}
