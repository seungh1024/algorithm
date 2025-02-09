import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long K = Long.parseLong(st.nextToken());

		Map<Long, Long> map = new HashMap<>();
		long sum = 0;
		st = new StringTokenizer(br.readLine());
		long result = 0;
		for (long i = 1; i <= N; i++) {
			long input = Long.parseLong(st.nextToken());
			sum += input;

			long temp = sum - i * K;

			Long value = map.get(temp);

			if (value == null) {
				map.put(temp, 1L);
			} else {
				result += value;
				map.put(temp, value + 1L);
			}
		}
		Long value = map.get(0L);

		if (value != null) {
			result += value;
		}

		System.out.println(result);
	}
}