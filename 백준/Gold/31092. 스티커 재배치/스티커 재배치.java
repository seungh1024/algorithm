

import java.io.*;
import java.util.*;

public class Main {
	public static int N,M, K;
	public static Sticker[] stickers;
	public static int[] board;
	public static char[] arr;
	public static int[] minSticker;
	public static long result = Long.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		boolean[] check = new boolean[26];
		minSticker = new int[26];
		Arrays.fill(minSticker, Integer.MAX_VALUE);
		stickers = new Sticker[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			char s = st.nextToken().charAt(0);
			int d = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			stickers[i] = new Sticker(s, d, a);
			check[s-'a'] = true;
			minSticker[s - 'a'] = Math.min(minSticker[s - 'a'], a);
		}
		board = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			board[i] = Integer.parseInt(st.nextToken())-1;
		}

		arr = new char[K];
		arr = br.readLine().toCharArray();

		for(int i = 0; i < K; i++){
			char c = arr[i];
			if (!check[c - 'a']) {
				System.out.println(-1);
				return;
			}
		}

		for (int start = 0; start + K - 1 < N; start++) {
			long cost = 0;

			PriorityQueue<Integer>[] pq = new PriorityQueue[26];
			for (int i = 0; i < 26; i++) {
				pq[i] = new PriorityQueue<>();
			}

			for (int i = start; i < start + K; i++) {
				Sticker sticker = stickers[board[i]];
				char c = arr[i-start];
				if (c != sticker.s) {
					cost+= sticker.d; // 다르면 스티커 일단 뗀다
					if (check[sticker.s - 'a']) {
						pq[sticker.s-'a'].offer(0); // 뗀 건 공짜로 붙일 수 있다.
					}
				}
			}

			for (int i = 0; i < N; i++) {
				if(i >= start && i < start+K) continue;
				Sticker sticker = stickers[board[i]];
				if (check[sticker.s - 'a']) {
					pq[sticker.s - 'a'].offer(sticker.d); // 관련 있으면 우선 떼서 사용할 수 있도록 한다 -> 뗀 비용
				}
			}


			for (int i = start; i < start + K; i++) {
				Sticker sticker = stickers[board[i]];
				char c = arr[i - start];
				if(c == sticker.s) continue;

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
				if (plus != Integer.MAX_VALUE) {
					cost += plus;
				} else {
					break;
				}


				if(cost >= result) break;
			}
			result = Math.min(result, cost);

		}

		System.out.println(result);
	}


	public static class Sticker{
		char s;
		int d;
		int a;

		@Override
		public String toString() {
			return "Sticker{" +
				"s=" + s +
				", d=" + d +
				", a=" + a +
				'}';
		}

		public Sticker(char s, int d, int a) {
			this.s = s;
			this.d = d;
			this.a = a;
		}
	}
}
