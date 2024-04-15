package algo_202403;

public class P_연속펄스부분수열의합 {
	public static int N;

	public long solution(int[] sequence) {
		long answer = 0;

		N = sequence.length;

		long[] plus = new long[N+1];

		plus[1] = sequence[0];

		int p = -1;

		long max = Math.max(0,plus[1]);
		long min = Math.min(0,plus[1]);
		for(int i = 2; i <= N; i++){
			plus[i] = plus[i-1]+((long)sequence[i-1])*p;
			p = p*-1;
			max = Math.max(max,plus[i]);
			min = Math.min(min,plus[i]);
		}

		// System.out.println(Arrays.toString(plus));
		// System.out.println(Arrays.toString(minus));

		answer = Math.abs(max-min);

		return answer;
	}
}
