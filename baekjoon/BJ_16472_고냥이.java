package algo_202410;

import java.io.*;
import java.util.*;

public class BJ_16472_고냥이 {
	public static int N;
	public static char[] data;
	public static Map<Character,Integer> map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = br.readLine().toCharArray();
		map = new HashMap<>();

		int left = 0;
		int right = 1;
		map.put(data[0],1);

		int result = 0;
		while (left < right) {
			if(right < data.length){
				Integer value = map.get(data[right]);
				if (value == null) {
					map.put(data[right], 1);
				} else {
					map.put(data[right], value + 1);
				}
				right++;
			}

			if (map.size() <= N) {
				result = Math.max(result, right-left);
			} else {
				while (left < right && map.size() > N) {
					Integer value = map.get(data[left]);
					value--;
					if (value == 0) {
						map.remove(data[left]);
					} else {
						map.put(data[left],value);
					}
					left++;
					result = Math.max(result, right-left);
				}
			}

			if (right == data.length && map.size() <= N) {
				break;
			}
		}

		System.out.println(result);
	}
}
