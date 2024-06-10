package algo_202406;

import java.io.*;
import java.util.*;

public class BJ_2015_수들의합4 {
	public static int N;
	public static long K;
	public static long[] data;
	public static long result;
	public static Map<Long,Long> map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Long.parseLong(st.nextToken());
		data = new long[N+1];
		map = new HashMap<>();
		map.put(0L,1L);

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			long input = Long.parseLong(st.nextToken());
			data[i] =  input + data[i-1];

			Long value = map.get(data[i]-K);
			if (value != null) {
				result += value;
			}

			value = map.get(data[i]);
			// if (data[i] == K) {
			// 	if (value != null) {
			// 		result += value;
			// 		map.put(data[i], value + 1);
			// 	} else {
			// 		result ++;
			// 		map.put(data[i],1L);
			// 	}
			// }else{
			// }
			if (value != null) {
				map.put(data[i], value + 1);
			} else {
				map.put(data[i], 1L);
			}

			// System.out.println("data[i] = "+data[i] + ", result = "+result);
		}


		System.out.println(result);
	}
}
