import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Map<Long, Long> map = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		long sum = 0;
		long result = 0;
		for (long i = 1; i <= N; i++) {
			int input = Integer.parseInt(st.nextToken());
			sum += input;

			long key = sum - (i * K);
			Long value = map.get(key);

			if (value != null) {
				result += value;
				map.put(key, value + 1);
			} else {
				map.put(key, 1L);
			}
		}

		if (map.containsKey(0L)) {
			result += map.get(0L);
		}

		System.out.println(result);

	}
}
