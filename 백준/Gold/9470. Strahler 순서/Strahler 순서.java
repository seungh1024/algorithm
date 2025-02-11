import java.io.*;
import java.util.*;

public class Main {
	public static int K,M, P;
	public static int[] count;
	public static int[] maxInput;
	public static int[] inputCount;
	public static List<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());

			count = new int[M + 1];
			maxInput = new int[M + 1];
			inputCount = new int[M + 1];

			list = new ArrayList[M + 1];
			for (int i = 1; i <= M; i++) {
				list[i] = new ArrayList<>();
			}
			for (int i = 0; i < P; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				list[from].add(to);
				count[to]++;
			}

			int result = find();
			sb.append(K).append(" ").append(result).append("\n");
		}
		System.out.println(sb);


	}
	public static int find() {
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= M; i++) {
			if (count[i] == 0) {
				q.offer(i);
				maxInput[i] = 1;
			}
		}

		// System.out.println(q);
		// System.out.println(Arrays.toString(maxInput));

		int last = 0;
		while(!q.isEmpty()) {
			int now = q.poll();

			last = now;

			for (int next : list[now]) {
				count[next]--;
				if (maxInput[next] < maxInput[now]) {
					maxInput[next] = maxInput[now];
					inputCount[next] = 1;
				}else if(maxInput[next] == maxInput[now]){
					inputCount[next]++;
				}

				if (count[next] == 0) {
					if (inputCount[next] >= 2) {
						maxInput[next] ++;
					}
					q.offer(next);
				}
			}
		}

		return maxInput[last];
	}


}