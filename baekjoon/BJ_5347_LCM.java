package algo_202403;

import java.io.*;
import java.util.*;

public class BJ_5347_LCM {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			long num = 2;
			long value = 1;
			int range=  0;
			while (true) {
				// System.out.println(num);
				if(a < num && b < num){
					break;
				}
				if (a % num == 0 && b % num == 0) {
					value *= num;
					a /= num;
					b /= num;
				} else {
					num++;
				}
			}
			// System.out.println("======");
			value *= (long)a*(long)b;
			sb.append(value).append("\n");

		}
		System.out.println(sb);
	}
}
