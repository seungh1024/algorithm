

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long a = 1;
		long mod = 998_244_353;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		st = new StringTokenizer(br.readLine());
		long range= R*C;
		for (long i = R + 1; i <= range; i++) {
			a *= i;
			a %= mod;
		}

		System.out.println(a);
	}
}
