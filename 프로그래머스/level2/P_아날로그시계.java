package algo_202402;

public class P_아날로그시계 {
	public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
		int answer = 0;

		int left = getCount(h1,m1,s1);
		int right = getCount(h2,m2,s2);

		System.out.println("right: "+right + ", left: "+left);
		answer = right-left;
		if((h1==0||h1==12)&&m1==0&&s1==0){
			answer++;
		}

		return answer;
	}

	private static int getCount(int h, int m, int s){
		double hDegree = (h%12)*30 + m/2.0 + s/120.0;
		double mDegree = m*6.0 + s/10.0;
		double sDegree = s*6.0;

		int count = 0;
		count += (h*60+m)*2;
		count -= h;

		if(h >= 12){
			count -=2;
		}

		if(sDegree >= mDegree){
			count++;
		}
		if(sDegree >= hDegree){
			count++;
		}

		return count;
	}
}
