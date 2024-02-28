package algo_202402;

public class R_P_마법의엘리베이터 {
	private static int result;
	public int solution(int storey) {
		result = Integer.MAX_VALUE;
		findValue(storey,10,0);
		return result;
	}

	private static void findValue(int storey, int mod, int sum){
		if(storey <= 0){
			result = Math.min(result,sum);
			return;
		}
		int value = storey % mod;
		storey -= value;
		value = value / (mod/10);
		findValue(storey,mod*10,sum+value); // 빼고 진행
		findValue(storey + mod, mod * 10, sum + 10 - value);// 더하고 진행
	}
}
