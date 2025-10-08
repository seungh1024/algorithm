

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static List<Data> data;
	public static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		// Map<Integer, Integer> map = new HashMap<>();
		Set<Integer> set = new HashSet<>();
		arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			int v = Integer.parseInt(st.nextToken());
			// map.compute(v, (key, value) -> value == null ? 1 : value + 1);
			arr[i] = v;
			if (!set.contains(v)) {
				set.add(v);
				data.add(new Data(i, v));
			}
		}
		if (N == 1) {
			System.out.println(1);
			return;
		}
		if (set.size() == 1) {
			System.out.println(-1);
			return;
		}


		// for (int i = 1; i <= N; i++) {
		// 	Integer value = map.get(arr[i]);
		// 	if (value == 1) {
		// 		data.add(new Data(i, arr[i]));
		// 	} else if (value > 1 && i > 1) {
		// 		data.add(new Data(i, arr[i]));
		// 		map.remove()
		// 	}
		// }
		// System.out.println(data);

		find();

	}

	public static void find() {
		int start = 0;
		int end = data.size();

		while (start < end) {
			int mid = (start + end) / 2;

			if (canWin(data.get(mid))) {
				end = mid;
			} else {
				start = mid+1;
			}
		}
		if (start == data.size()) {
			System.out.println(-1);
			return;
		}

		if (start < data.size()) {

			StringBuilder sb = new StringBuilder();
			for (int i = start; i < data.size(); i++) {
				sb.append(data.get(i).idx).append(" ");
			}
			System.out.println(sb);
		} else {
			System.out.println(-1);
		}

	}

	public static boolean canWin(Data target) {
		// System.out.println(target);
		for(int i = 1; i <= N; i++){
			if(i <=target.idx) continue;
			if (arr[i] >= target.value + (i - 2)) {
				return false;
			}
		}
		return true;
	}

	public static class Data{
		int idx;
		int value;

		@Override
		public String toString() {
			return "Data{" +
				"idx=" + idx +
				", value=" + value +
				'}';
		}

		public Data(int idx, int value) {
			this.idx = idx;
			this.value = value;
		}
	}
}
