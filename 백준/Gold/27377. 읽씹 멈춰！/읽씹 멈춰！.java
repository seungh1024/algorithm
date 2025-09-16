

import java.util.*;
import java.io.*;

public class Main {
	public static long N;
	public static long s, t;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			N = Long.parseLong(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			s = Long.parseLong(st.nextToken());
			t = Long.parseLong(st.nextToken());

			long time = 0;
			while(N>0){
				if (N % 2 == 0) {
					if (N / 2 * s > 0) {
						time += Math.min(N / (long)2 * s, t);
					} else {
						time += t;
					}
					N/=2;
				} else {
					N--;
					time+=s;
				}
				// System.out.println("N = "+N +", time = "+time);
			}
			sb.append(time).append("\n");
		}
		System.out.println(sb);



	}
}
