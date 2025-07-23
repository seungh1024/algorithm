

import java.io.*;
import java.util.*;

public class Main {
	public static int R, C;
	public static String[] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		StringBuilder[] sbarr = new StringBuilder[C];
		for (int i = 0; i < C; i++) {
			sbarr[i] = new StringBuilder();
		}
		for (int i = 0; i < R; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				sbarr[j].append(input[j]);
			}
		}

		data = new String[C];
		for (int i = 0; i < C; i++) {
			data[i] = sbarr[i].toString();
		}

		// System.out.println(Arrays.toString(data));
		int result = 0;
		boolean check = false;
		for (int i = 0; i < R; i++) {
			Set<String> set = new HashSet<>();
			for (int j = 0; j < C; j++) {
				data[j] = data[j].substring(1);
				set.add(data[j]);
			}
			// System.out.println(Arrays.toString(data));

			if (set.size() != C) {
				break;
			}
			result++;
		}

		System.out.println(result);
	}
}
