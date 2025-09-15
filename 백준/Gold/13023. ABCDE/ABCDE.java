import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static List<Integer>[] list;
	public static int[] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}

		data = new int[5];
		int result = 0;
		for (int i = 1; i <= N; i++) {
			if(list[i].isEmpty()) continue;
			data[0] = i;
			if (find(i, 1, 0)) {
				result = 1;
				break;
			}
		}
		System.out.println(result);
	}

	public static boolean find(int now, int idx, int last) {
		if (idx == 5) {
			Set<Integer> set = new HashSet<>();
			for (int num : data) {
				if(set.contains(num)) return false;
				set.add(num);
			}
			return true;
		}

		for (int next : list[now]) {
			if(next == last) continue;
			data[idx] = next;
			if (find(next, idx + 1, now)) {
				return true;
			}
		}

		return false;
	}
}