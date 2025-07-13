

import java.io.*;
import java.util.*;

public class Main {
	public static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int nn = N*N;

		int min = nn/2;
		if (K < min) {
			System.out.println(-1);
			return;
		}

		int[][] data = new int[N][N];

		boolean turn = false;
		int first = 1;
		int fCnt = (nn+1)/2;
		int last = 0;
		int lCnt = nn-fCnt;
		int k = K - (first * fCnt);
		while (k > 0) {
			// System.out.println("k = "+k + ", first = "+first +", last = "+last);
			if (turn) {
				if (k - 2 * fCnt >= 0) {
					k -= (2 * fCnt);
					first += 2;
				} else {
					// first+=2;
					break;
				}
			} else {
				if (k - 2 * lCnt >= 0) {
					k -= (2 * lCnt);
					last += 2;
				} else {
					break;
				}
			}
			turn = !turn;
		}
		// System.out.println("k = "+k);
		k = K;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i % 2 == 0 && j % 2 == 0) {
					data[i][j] = first;
					k -= first;
				} else if (i % 2 == 1 && j % 2 == 1) {
					data[i][j] = first;
					k -= first;
				} else {
					data[i][j] = last;
					k -= last;
				}
			}
		}

		if (k >= 0 && k %2 ==0) {
			// for (int i = 0; i < N; i++) {
			// 	System.out.println(Arrays.toString(data[i]));
			// }
			StringBuilder sb = new StringBuilder();
			if (last < first) {

				for (int i = 0; i < N && k > 0; i++) {
					for (int j = 0; j < N && k > 0; j++) {
						if (i % 2 == 0 && j % 2 == 1) {
							data[i][j] += 2;
							k -= 2;
						} else if (i % 2 == 1 && j % 2 == 0) {
							data[i][j] += 2;
							k -= 2;
						}
					}
				}
			} else {

				for (int i = 0; i < N && k > 0; i++) {
					for (int j = 0; j < N && k > 0; j++) {
						if (i % 2 == 0 && j % 2 == 0) {
							data[i][j]+=2;
							k-=2;
						} else if (i % 2 == 1 && j % 2 == 1) {
							data[i][j]+=2;
							k-=2;
						}
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(data[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
		} else{
			data = new int[N][N];
			first = 1;
			fCnt = nn/2;
			last = 0;
			lCnt = nn - fCnt;
			k = K - (first * fCnt);
			turn = false;
			while (k > 0) {
				if (turn) {
					if (k - 2* fCnt >= 0) {
						k -= (2 * fCnt);
						first += 2;
					} else {
						// first+=2;
						break;
					}
				} else {
					if (k - 2 * lCnt >= 0) {
						k -= (2 * lCnt);
						last += 2;
					} else {
						break;
					}
				}
				turn = !turn;
			}

			// System.out.println("first = " + first + ", last = "+last);
			k = K;
			int minus = first-1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i % 2 == 0 && j % 2 == 1) {
						data[i][j] += first;
						k -= first;
					} else if (i % 2 == 1 && j % 2 == 0) {
						data[i][j] += first;
						k -= first;
					} else {
						data[i][j] += last;
						k -= last;
					}
				}
			}
			// System.out.println("final");
			// System.out.println(first +", "+last);
			// for (int i = 0; i < N; i++) {
			// 	System.out.println(Arrays.toString(data[i]));
			// }

			if (last < first) {
				for (int i = 0; i < N && k > 0; i++) {
					for (int j = 0; j < N && k > 0; j++) {
						if (i % 2 == 0 && j % 2 == 0) {
							data[i][j]+=2;
							k-=2;
						} else if (i % 2 == 1 && j % 2 == 1) {
							data[i][j]+=2;
							k-=2;
						}
					}
				}

			} else {
				for (int i = 0; i < N && k > 0; i++) {
					for (int j = 0; j < N && k > 0; j++) {
						if (i % 2 == 0 && j % 2 == 1) {
							data[i][j]+=2;
							k-=2;
						} else if (i % 2 == 1 && j % 2 == 0) {
							data[i][j]+=2;
							k-=2;
						}
					}
				}
			}

			if (k == 0) {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						sb.append(data[i][j]).append(" ");
					}
					sb.append("\n");
				}
				System.out.println(sb);
			} else {
				System.out.println(-1);
			}

		}



	}
}

// 0 0 0 0
// 0 0 0 0
// 0 0 0 0
// 0 0 0 0

// 3 2 1
// 2 1 2
// 1 2 1

// 2 3 2
// 1 2 1
// 2 1 2

// 22개
// 2 3 2
// 3 2 3
// 2 3 2