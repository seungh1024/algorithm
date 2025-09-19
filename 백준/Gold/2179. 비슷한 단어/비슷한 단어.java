

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Data>[] list = new ArrayList[26];
		for (int i = 0; i < 26; i++) {
			list[i] = new ArrayList<>();
		}




		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			int idx = s.charAt(0)-'a';

			list[idx].add(new Data(i, s));
		}

		String a="";
		String b="";
		int minIdx = Integer.MAX_VALUE;
		for (int i = 1; i <= 100; i++) {
			int cnt = 0;
			boolean flag = false;
			for (int j = 0; j < 26; j++) {
				if(list[j].size() < 2) continue;
				cnt++;

				Map<String, Integer> map = new HashMap<>();
				for (Data data : list[j]) {
					String s = data.s;
					if(s.length()<i) continue;
					String sub = s.substring(0, i);
					map.compute(sub, (k, v) -> v == null ? 1 : v + 1);
				}

				List<Data> temp = new ArrayList<>();
				for (Data data : list[j]) {
					String s = data.s;
					if(s.length() < i) continue;
					String sub = s.substring(0, i);
					if (map.get(sub) >= 2) {
						temp.add(data);
					}
				}
				list[j] = temp;

				if (list[j].size() >= 2) {
					for (int k = 0; k < list[j].size(); k++) {
						Data data = list[j].get(k);
						if (!flag) {
							minIdx = data.idx;
							a = data.s;
							b = list[j].get(k+1).s;
							flag = true;
						} else if (minIdx > data.idx && k + 1 < list[j].size()) {
							minIdx = data.idx;
							a = data.s;
							b = list[j].get(k+1).s;
						}
					}
				}
				// System.out.println(temp);
				// System.out.println("a = "+a +", b = "+b);
			}
			if (cnt == 0) {
				break;
			}
		}

		System.out.println(a);
		System.out.println(b);
	}

	public static class Data{
		int idx;
		String s;

		public Data(int idx, String s) {
			this.idx = idx;
			this.s = s;
		}

		@Override
		public String toString() {
			return "Data{" +
				"idx=" + idx +
				", s='" + s + '\'' +
				'}';
		}

	}
}
