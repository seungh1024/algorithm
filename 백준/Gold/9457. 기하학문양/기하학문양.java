

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int mod = 10007;
		int[] rec = new int[50001];
		rec[1] = 1;
		rec[2] = 4;
		for (int i = 3; i <= 50000; i++) {
			rec[i] = rec[i-1]*3%mod + (rec[i-1]-rec[i-2]+mod)%mod;
			rec[i]%=mod;
		}

		int[] cir = new int[50001];
		cir[1] = 1;
		int sum = 1;
		for (int i = 2; i <= 50000; i++) {
			cir[i] = (i*rec[i]+i*2*sum)%mod;
			sum = (sum+rec[i])%mod;
		}
		// System.out.println(Arrays.toString(cir));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(rec[n]).append(" ").append(cir[n]).append("\n");
		}
		System.out.println(sb);
	}
}
