

import java.io.*;
import java.util.*;

public class Main {
	public static int N,M, K;
	public static Sticker[] stickers;
	public static int[] minSticker;
	public static int[] board;
	public static char[] data;
	public static int result = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		stickers = new Sticker[M];
		minSticker = new int[26];
		Arrays.fill(minSticker, Integer.MAX_VALUE);
		boolean[] check = new boolean[26];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			char c = st.nextToken().charAt(0);
			int d = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			stickers[i] = new Sticker(c, d, a);
			check[c-'a'] = true;
			minSticker[c - 'a'] = Math.min(minSticker[c - 'a'], a);
		}

		board = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			board[i] = Integer.parseInt(st.nextToken()) - 1;
		}

		data = br.readLine().toCharArray();

		for (int i = 0; i < K; i++) {
			char c = data[i];
			if (!check[c - 'a']) {
				System.out.println(-1);
				return;
			}
		}

		for (int start = 0; start + K - 1 < N; start++) {
			int cost = 0;

			PriorityQueue<Integer>[] pq = new PriorityQueue[26];
			for (int i = 0; i < 26; i++) {
				pq[i] = new PriorityQueue<>();
			}

			for (int i = start; i < start + K; i++) {
				Sticker sticker = stickers[board[i]];
				char c = data[i-start];
				if (c != sticker.c) {
					cost += sticker.d;
					pq[sticker.c - 'a'].offer(0);
				}
			}

			for (int i = 0; i < N; i++) {
				if(i >= start && i < start+K) continue;
				Sticker sticker = stickers[board[i]];
				pq[sticker.c - 'a'].offer(sticker.d);
			}

			for (int i = start; i < start + K; i++) {
				Sticker sticker = stickers[board[i]];
				char c = data[i - start];
				if(c == sticker.c) continue;

				int idx = c-'a';
				int plus = minSticker[idx];
				if (!pq[idx].isEmpty()) {
					int v = pq[idx].poll();
					if (v <= plus) {
						plus = v;
					} else {
						pq[idx].offer(v);
					}
				}
				cost += plus;

				if (cost >= result) {
					break;
				}
			}
			result = Math.min(result, cost);
		}

		System.out.println(result);

	}

	public static class Sticker{
		char c;
		int d;
		int a;

		public Sticker(char c, int d, int a) {
			this.c = c;
			this.d = d;
			this.a = a;
		}
	}
}
