package algo_202403;

import java.util.*;

public class R_P_코딩테스트공부 {
	public static int maxAlp, maxCop;
	public static int N;
	public static int[][] datas;

	public int solution(int alp, int cop, int[][] problems) {
		int answer = 0;
		maxAlp = 0;
		maxCop = 0;
		N = problems.length;
		datas = new int[N+2][5];


		for(int i = 0; i < N; i++){
			datas[i] = problems[i];
			maxAlp = Math.max(maxAlp,datas[i][0]);
			maxCop = Math.max(maxCop,datas[i][1]);
		}
		datas[N] = new int[]{0,0,0,1,1};
		datas[N+1] = new int[]{0,0,1,0,1};
		if(alp > maxAlp){
			alp = maxAlp;
		}
		if(cop > maxCop){
			cop = maxCop;
		}
		boolean[][] visited = new boolean[maxAlp+1][maxCop+1];

		int[][] costCheck = new int[maxAlp+1][maxCop+1];

		for(int i = 0; i <= maxAlp; i++){
			Arrays.fill(costCheck[i],Integer.MAX_VALUE);
		}
		costCheck[alp][cop] = 0;

		Queue<Data> pq = new PriorityQueue<>();
		pq.offer(new Data(alp,cop,0));

		while(!pq.isEmpty()){
			Data now = pq.poll();

			if(now.alp == maxAlp && now.cop == maxCop){
				break;
			}

			int minAlp = Math.min(now.alp,maxAlp);
			int minCop = Math.min(now.cop,maxCop);

			if(visited[minAlp][minCop]) continue;
			visited[minAlp][minCop] = true;



			for(int[] data : datas){
				if(data[0] > minAlp || data[1] > minCop) continue;
				int nextAlp = Math.min(maxAlp,minAlp+data[2]);
				int nextCop = Math.min(maxCop,minCop+data[3]);
				if(!visited[nextAlp][nextCop] && costCheck[nextAlp][nextCop] > costCheck[minAlp][minCop]+data[4]){
					costCheck[nextAlp][nextCop] = costCheck[minAlp][minCop]+data[4];
					pq.offer(new Data(nextAlp,nextCop,costCheck[nextAlp][nextCop]));
				}
			}
		}


		// for(int i = 0; i <= maxAlp; i++){
		//     System.out.println(Arrays.toString(costCheck[i]));
		// }

		answer = costCheck[maxAlp][maxCop];


		return answer;
	}

	public static class Data implements Comparable<Data>{
		int alp;
		int cop;
		int time;

		public Data(int alp, int cop, int time){
			this.alp = alp;
			this.cop = cop;
			this.time = time;
		}

		@Override
		public int compareTo(Data data){
			return this.time-data.time;
		}
	}
}
