package algo_202403;

import java.util.*;

public class P_모두0으로만들기 {
	public static List<Integer>[] list;
	public static int N;
	public static boolean[] visited;
	public static long result;
	public static int[] aa;

	public long solution(int[] a, int[][] edges) {
		long answer = -1;
		N = a.length;
		list = new ArrayList[N];
		for(int i = 0; i < N; i++){
			list[i] = new ArrayList<>();
		}
		for(int[] e : edges){
			int from = e[0];
			int to = e[1];
			list[from].add(to);
			list[to].add(from);
		}
		visited = new boolean[N];
		visited[0] = true;
		aa = a;
		long value = find(0);
		if(value == 0L){
			answer = result;
		}
		// long test = 0L;
		// for(int i = 0; i <= 300000;i++){
		//     test += 1_000_000L;
		//     test -= 1_000_000L;
		// }
		// System.out.println(test);
		return answer;
	}

	public static long find(int index){
		// System.out.println("index = "+index);
		boolean check = false;
		long count = 0L;
		for(int next : list[index]){
			if(!visited[next]){
				check = true;
				visited[next] = true;
				long value = find(next);
				if(value < 0L){
					result = result - value;
				}else if(value > 0L){
					result = result + value;
				}

				count += value; // runtime error..?

			}
		}

		if(check){
			return (long)(count + (long)aa[index]);
		}else{
			return (long)aa[index];
		}
	}
}
