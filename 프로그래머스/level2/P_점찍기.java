package algo_202402;

public class P_점찍기 {
	public static void main(String[] args) {
		P_점찍기 test = new P_점찍기();
		int k = 2;
		int d = 4;
		long answer = test.solution(k, d);
		long result = 6;
		if (answer == result) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	public long solution(int k, int d) {
		long answer = 0;

		long max = (long)d*(long)d;
		long count = 0;
		for(long i = 0; i <= d; i+=k){
			long length = (long)(Math.sqrt(max-(i*i)));
			// System.out.println(length);
			answer += length/k;
			count++;
		}
		return answer+count;
	}
}
