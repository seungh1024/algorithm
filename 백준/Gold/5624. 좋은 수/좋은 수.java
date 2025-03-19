

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] data = new int[N];
		
		Set<Integer> set = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		set.add(data[0] + data[0]);
		
		

		int result = 0;
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (set.contains(data[i] - data[j])) {
					result++;
					break;
				}
			}

			for (int j = 0; j <= i; j++) {
				set.add(data[i] + data[j]);
			}
		}
		System.out.println(result);
	}
}
