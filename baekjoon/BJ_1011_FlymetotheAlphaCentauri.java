package algo_202411;

import java.io.*;
import java.util.*;

public class BJ_1011_FlymetotheAlphaCentauri {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			int distance = to-from;

			int sqrt = (int)Math.sqrt(distance);
			if (sqrt * sqrt == distance) {
				sb.append(sqrt * 2 - 1);
			} else if (distance <= sqrt * sqrt + sqrt) {
				sb.append(sqrt * 2 );
			} else {
				sb.append(sqrt * 2 + 1);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
