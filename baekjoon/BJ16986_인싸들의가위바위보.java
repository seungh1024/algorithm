package algo_202405;

import java.io.*;
import java.util.*;

public class BJ16986_인싸들의가위바위보 {
	public static int N,K;
	public static int[][] win;

	public static int[][] value;
	public static int[] hand;
	public static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		win = new int[N+1][N+1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				win[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		value = new int[3][20];
		for (int i = 1; i <= 2; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 20; j++) {
				value[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		hand = new int[N];
		visited = new boolean[N+1];
		boolean result = find(0);
		if (result) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	public static boolean find(int index) {
		if (index >= N) {
			// row, col , win count
			int[] jw = {0,0,0};
			int[] kh = {1,0,0};
			int[] mh = {2,0,0};

			for (int i = 0; i < N; i++) {
				value[0][i] = hand[i];
			}

			int[] now = jw;
			Queue<int[]> pq = new ArrayDeque<>();
			pq.offer(kh);
			pq.offer(mh);

			boolean flag = false;
			int winCount = 0;
			while (!pq.isEmpty()) {
				int[] next = pq.poll();
				// System.out.println("now = "+Arrays.toString(now));
				// System.out.println("next = "+Arrays.toString(next));
				if (now[1] >= 20 || next[1] >= 20 || (now[0] == 0 && now[1] >= N) || (next[0] == 0 && next[1] >= N)) {
					break;
				}

				int nowValue = value[now[0]][now[1]];
				int nextValue = value[next[0]][next[1]];
				// System.out.println("nowValue = "+nowValue);
				// System.out.println("nextValue = "+nextValue);

				if (win[nowValue][nextValue] == 2) {
					now[1]++;
					next[1]++;
					now[2]++;
					pq.offer(next);
					// System.out.println("now win = " + Arrays.toString(now));
				} else if(win[nowValue][nextValue] == 1){
					now[1]++;
					next[1]++;
					if (now[0] > next[0]) { // now 승
						now[2]++;
						pq.offer(next);
						// System.out.println("now win = " + Arrays.toString(now));
					} else { // next 승
						next[2]++;
						int[] temp = new int[3];
						for (int i = 0; i < 3; i++) {
							temp[i] = now[i];
						}
						pq.offer(temp);
						now = next;
						// System.out.println("next win = " + Arrays.toString(now));
					}
				} else {
					now[1]++;
					next[1]++;
					next[2]++;
					int[] temp = new int[3];
					for (int i = 0; i < 3; i++) {
						temp[i] = now[i];
					}
					pq.offer(temp);
					now = next;
					// System.out.println("next win = " + Arrays.toString(now));
				}

				if (now[2] >= K) {
					if (now[0] == 0) {
						flag = true;
					}
					break;
				}

			}




			if (flag ) {
				// System.out.println(Arrays.toString(hand));
				return true;
			}
			// System.out.println("======fail======");


			return false;
		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				hand[index] = i;
				if (find(index + 1)) {
					return true;
				}
				visited[i] = false;
			}
		}

		return false;
	}

}
