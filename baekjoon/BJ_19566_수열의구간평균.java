package algo_202412;

import java.io.*;
import java.util.*;

public class BJ_19566_수열의구간평균 {
	public static long N, K;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		K = Long.parseLong(st.nextToken());

		long sum = 0;
		long count = 0;
		st = new StringTokenizer(br.readLine());
		Map<Long, Long> map = new HashMap<>();
		for (long i = 1; i <= N; i++) {
			long input = Long.parseLong(st.nextToken());
			sum += input;
			long value = sum - i*K; // 이 값이 0이라는 것은 혼자서도 부분합이 된다는 의미임. 하나 추가했는데 K가 되니까
			Long cnt = map.get(value);
			if (cnt == null) {
				map.put(value, 1L);
			} else {
				count += cnt;
				map.put(value,cnt + 1L);
			}
			// System.out.println("i = "+i + ", cnt = "+cnt);
		}

		// System.out.println(map);
		Long value = map.get(0L);
		if (value != null) {
			count += value;
		}
		System.out.println(count);

	}
}
