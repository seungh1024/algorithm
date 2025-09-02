

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] count = new int[100001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			count[num]++;
		}

		long result = 0;
		for (int i = 100000; i > 0; i--) {
			if(count[i] == 0) continue;
			while (count[i] > 0) {
				long cnt = 1;
				count[i]--;
				for (int j = i - 1; j > 0; j--) {
					if (count[j] <= 0) {
						break;
					}
					count[j]--;
					cnt++;
				}
				result += cnt*((long)i);
			}
		}

		System.out.println(result);
	}
}
