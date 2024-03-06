package algo_202403;

import java.util.*;

public class R_P_등산코스정하기 {
	public static List<Data>[] list;
	public static boolean[] endPoint;
	public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {

		list = new ArrayList[n+1];
		for(int i = 1; i <= n; i++){
			list[i] = new ArrayList<>();
		}
		for(int[] path : paths){
			int from = path[0];
			int to = path[1];
			int intensity = path[2];
			list[from].add(new Data(to,intensity));
			list[to].add(new Data(from,intensity));
		}
		endPoint = new boolean[n+1];
		for(int summit : summits){
			endPoint[summit] = true;
		}
		int[] answer = find(n,gates);
		return answer;
	}

	public static int[] find(int n, int[] gates){
		int[] result = new int[2];

		boolean[] startPoint = new boolean[n+1];
		Queue<Data> pq = new PriorityQueue<>();
		for(int gate : gates){
			pq.offer(new Data(gate,0));
			startPoint[gate] = true;
		}
		boolean[] visited = new boolean[n+1];

		int intensity = Integer.MAX_VALUE;
		int end = Integer.MAX_VALUE;
		while(!pq.isEmpty()){
			Data now = pq.poll();
			if(endPoint[now.to]){
				if(intensity > now.intensity){
					end = now.to;
					intensity = now.intensity;
				}else if(intensity == now.intensity && end > now.to){
					end = now.to;
				}
				continue;
			}

			if(visited[now.to]) continue;
			visited[now.to] = true;

			for(Data next : list[now.to]){
				if(!visited[next.to] && !startPoint[next.to]){
					pq.offer(new Data(next.to,Math.max(now.intensity,next.intensity)));
				}
			}

		}
		result[0] = end;
		result[1] = intensity;
		return result;
	}

	public static class Data implements Comparable<Data>{
		int to;
		int intensity;

		public Data(int to, int intensity){
			this.to = to;
			this.intensity = intensity;
		}

		@Override
		public int compareTo(Data d){
			return this.intensity - d.intensity;
		}
	}
}
