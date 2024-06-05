package algo_202406;

import java.io.*;
import java.util.*;

public class BJ_1302_베스트셀러 {
	public static Map<String,Integer> map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new HashMap<>();
		List<Data> list = new ArrayList<>();
		int index = 0;

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			Integer target = map.get(input);
			if (target == null) {
				list.add(new Data(input,1));
				map.put(input, index++);
			} else {
				list.get(target).add();
			}
		}

		Collections.sort(list,(o1,o2)->{
			if(o2.count == o1.count){
				return o1.s.compareTo(o2.s);
			}
			return o2.count - o1.count;
		});

		System.out.println(list.get(0).s);

	}

	public static class Data{
		String s;
		int count;

		public Data(String s, int count) {
			this.s = s;
			this.count = count;
		}

		public void add() {
			this.count++;
		}

	}
}
