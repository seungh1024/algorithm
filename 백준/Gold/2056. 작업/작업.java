import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[] time;
	public static int[] count;
	public static List<Integer>[] list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		time = new int[N+1];
		count = new int[N+1];
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			time[i] = t;
			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; j++) {
				int value = Integer.parseInt(st.nextToken());
				list[value].add(i);
				count[i]++;
			}
		}

		find();
	}

	public static void find() {
		Queue<Data> q = new ArrayDeque<>();
		int[] minCost = new int[N+1];
		// Arrays.fill(minCost, Integer.MAX_VALUE);

		for (int i = 1; i <= N; i++) {
			if(count[i] == 0){
				q.offer(new Data(i,time[i]));
			}
		}

		int result = 0;
		while(!q.isEmpty()){
			Data now = q.poll();
			// System.out.println("now = "+now +", result = "+result) ;

            result = Math.max(result,now.cost);

			for (int next : list[now.to]) {
				if(count[next] > 0){
					count[next]--;
				}
				minCost[next] = Math.max(minCost[next],now.cost+time[next]);
				if(count[next] == 0){
					q.offer(new Data(next,minCost[next]));
				}
			}
		}

		System.out.println(result);
	}

	public static class Data{
		int to;
		int cost;

		public Data(int to, int cost){
			this.to = to;
			this.cost = cost;
		}

		public String toString(){
			return "to = "+to + ", cost = "+cost;
		}
	}

}