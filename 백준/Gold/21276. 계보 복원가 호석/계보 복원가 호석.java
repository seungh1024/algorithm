import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static Map<String,Integer> map;
	public static String[] name;
	public static List<Integer>[] list;
	public static int[] count;
	public static List<String>[] child;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new TreeMap<>();
		name = new String[N + 1];
		list = new ArrayList[N + 1];
		child = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
			child[i] = new ArrayList<>();
		}
		count = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			String s = st.nextToken();
			map.put(s, i);
			name[i] = s;
		}

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = map.get(st.nextToken());
			int b = map.get(st.nextToken());
			count[a]++;
			list[b].add(a);
		}

		find();


	}

	public static void find() {
		StringBuilder sb = new StringBuilder();

		Queue<Integer> q = new ArrayDeque<>();
		List<String> parent = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			if (count[i] == 0) {
				q.offer(i);
				parent.add(name[i]);
			}
		}
		Collections.sort(parent);
		sb.append(q.size()).append("\n");
		for (String s : parent) {
			sb.append(s).append(" ");
		}
		sb.append("\n");


		while (!q.isEmpty()) {
			int now = q.poll();

			for (int next : list[now]) {
				if (count[next] == 1) {
					child[now].add(name[next]);
				}
				count[next] --;
				if(count[next] != 0) continue;

				q.offer(next);
			}
		}

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			sb.append(key).append(" ").append(child[value].size());
			if (child[value].size() > 0) {
				Collections.sort(child[value]);
				for (String s : child[value]) {
					sb.append(" ").append(s);
				}
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}



}