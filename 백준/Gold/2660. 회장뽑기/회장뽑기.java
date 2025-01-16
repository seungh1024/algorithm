import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static List<Integer>[] list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			if (from == -1 && to == -1) {
				break;
			}

			list[from].add(to);
			list[to].add(from);
		}

		List<Integer> people = new ArrayList<>();
		int min = Integer.MAX_VALUE;

		for (int i = 1; i <= N; i++) {
			int point = find(i);
			if (min > point) {
				min = point;
				people = new ArrayList<>();
				people.add(i);
			} else if (min == point) {
				people.add(i);
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(min).append(" ").append(people.size()).append("\n");
		for (int i : people) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}

	public static int find(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N + 1];
		q.offer(start);
		visited[start]= true;

		int point = -1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				int now = q.poll();

				for (int next : list[now]) {
					if (!visited[next]) {
						visited[next] = true;
						q.offer(next);
					}
				}
			}
			point++;
		}

		return point;
	}

}