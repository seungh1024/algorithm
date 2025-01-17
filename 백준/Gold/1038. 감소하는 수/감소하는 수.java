import java.io.*;
import java.util.*;

public class Main {
	public static Set<Long> set;
	public static boolean[] visited;
	public static int[] data;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		visited = new boolean[10];
		data = new int[10];
		set = new TreeSet<>();
		find(0);
		List<Long> list = new ArrayList<>(set);
		// System.out.println(list);
		Long result = -1L;
		// System.out.println(list.size());
		if (list.size() > N) {
			result = list.get(N);
		}
		// Long result = list.get(N);
		System.out.println(result);
		// for (int i = 0; i <= 18; i++) {
		// 	System.out.println(list.get(i));
		// }
	}

	public static void find(int idx) {
		long sum = data[0];
		long mul = 10;
		boolean flag = false;
		// System.out.println(Arrays.toString(data));
		for (int i = 1; i < idx; i++) {
			if (data[i - 1] < data[i]) {
				sum += data[i] * mul;
				mul *= 10;
			} else {
				break;
			}
		}
		set.add(sum);

		if (idx == 10) {
			return;
		}

		for (int i = 0; i <= 9; i++) {
			if(visited[i] ||  (idx > 0 && data[idx-1] >= i)) continue;
			visited[i] = true;
			data[idx] = i;
			find(idx+1);
			visited[i] = false;
		}
	}
}