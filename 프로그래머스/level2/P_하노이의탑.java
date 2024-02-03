package algo_202401;

import java.util.*;

public class P_하노이의탑 {
	public int[][] solution(int n) {
		int[][] answer;
		Queue<int[]> q = new ArrayDeque<>();

		find(q,n,1,2,3);

		answer = new int[q.size()][2];
		int index = 0;
		while(!q.isEmpty()){
			int[] now = q.poll();
			answer[index][0] = now[0];
			answer[index][1] = now[1];
			index++;
		}

		return answer;
	}

	public static void find(Queue<int[]> q, int n, int start, int mid, int end){
		if(n == 1){
			q.offer(new int[]{start,end});
			return;
		}

		find(q,n-1,start,end,mid);
		q.offer(new int[]{start,end});
		find(q,n-1,mid,start,end);
	}
}
