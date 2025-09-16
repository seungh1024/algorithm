

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] data = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		int S = Integer.parseInt(br.readLine());

		List<Integer> list = new ArrayList<>();
		int range = 10;
		while (true) {
			int max = 0;
			int idx = -1;
			int cnt = 0;
			int maxCnt = 0;
			for (int i = 0; i < N; i++) {
				if(data[i] == 0) continue;
				if (data[i] > max) {
					max = data[i];
					idx = i;
					maxCnt = Math.max(maxCnt, cnt);
				}
				cnt++;
				if(cnt > S) break;
			}
			if (maxCnt > S) {
				max = 0;
				idx = -1;
				for (int i = 0; i < S; i++) {
					if (data[i] > max) {
						max = data[i];
						idx = i;
					}
				}

				break;
			}
			if(idx == -1) break;
			S-=maxCnt;
			list.add(data[idx]);
			data[idx] = 0;
		}
		for (int i = 0; i < N; i++) {
			if (data[i] != 0) {
				list.add(data[i]);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i : list) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}
}
