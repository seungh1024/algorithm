package algo_202403;

public class P_기지국설치 {
	public int solution(int n, int[] stations, int w) {
		int answer = 0;

		int point = 1;
		int range = 2*w+1;
		for(int station : stations){
			int noSignal = (station-w)-point;
			point = station+w+1;

			if(noSignal <= 0) continue;

			answer += ((noSignal+range-1)/range);
		}
		int noSignal = (n+1)-point;
		if(noSignal > 0){
			answer += ((noSignal+range-1)/range);
		}

		return answer;
	}
}
