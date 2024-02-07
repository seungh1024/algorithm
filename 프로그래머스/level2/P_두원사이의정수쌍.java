package algo_202402;

public class P_두원사이의정수쌍 {
	public static void main(String[] args) {
		P_두원사이의정수쌍 test = new P_두원사이의정수쌍();
		int r1 = 2;
		int r2 = 3;
		long answer = test.solution(r1, r2);
		int result = 20;
		if (answer == result) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	public long solution(int r1, int r2) {
		long answer = 0;

		long r1r1 = (long)r1*(long)r1;
		long r2r2 = (long)r2*(long)r2;

		for(long i = 0; i <= r2; i++){
			double temp = Math.sqrt(r1r1-i*i);
			if(temp - (long)temp > 0){
				temp++;
			}
			long small = (long)temp;
			long big = (long)Math.sqrt(r2r2-i*i);
			if(r1r1-i*i < 0) small = 0;
			answer += (big-small+1);
		}
		answer -=(r2-r1+1);
		answer *= 4;

		return answer;
	}
}
