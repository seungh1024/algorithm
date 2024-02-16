package algo_202402;

public class P_유사칸토어비트열 {
	public static void main(String[] args) {
		P_유사칸토어비트열 test = new P_유사칸토어비트열();
		int n = 2;
		int l = 4;
		int r = 17;
		int answer = test.solution(n, l, r);
		int result = 8;
		if (answer == result) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	public int solution(int n, long l, long r) {
		int answer= 0;

		long totalCount = 1;
		long totalOneCount = 1;
		for(int i = 0; i < n; i++){
			totalCount*=5;
			totalOneCount*=4;
		}
		long jumpLeft = totalCount/5*2+1; // 여기부터 시작해서
		long jumpRight = totalCount/5*3; // 여기까진 전부 0임 jumpLeft <= target <= jumpRight
		if(l >= jumpLeft && l <= jumpRight){
			l = jumpLeft;
		}
		if(r >= jumpLeft && r <= jumpRight){
			r = jumpLeft-1;
		}
		l--;
		long mod = totalCount/5;
		long plus = totalOneCount/4;
		int leftCount = 0;
		while(l>=1){

			leftCount += (plus*(l/mod));
			if(l/mod == 2 && l%mod > 0){
				break;
			}
			if(l/mod >= 3){
				leftCount -= plus;
			}
			l %= mod;
			mod /= 5;
			plus /=4;
		}

		mod = totalCount/5;
		plus = totalOneCount/4;
		int rightCount = 0;
		while(r>=1){
			rightCount +=(plus*(r/mod));
			if(r/mod == 2 && r%mod > 0){
				break;
			}
			if(r/mod >=3){
				rightCount -=plus;
			}
			r%=mod;
			mod/=5;
			plus/=4;
		}

		System.out.println("leftCount: "+leftCount);
		System.out.println("rightCount: "+rightCount);


		return rightCount-leftCount;
	}
}
