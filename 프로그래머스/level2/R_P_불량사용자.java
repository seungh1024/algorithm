package algo_202402;

import java.util.*;

public class R_P_불량사용자 {
	private static int[] idLength;
	private static int N,M;
	private static int result;
	private static boolean[] visited;
	private static Set<String> set;

	public int solution(String[] user_id, String[] banned_id) {
		N = user_id.length;
		idLength = new int[N];
		for(int i = 0; i < N; i++){
			idLength[i] = user_id[i].length();
		}

		result = 0;
		visited = new boolean[N];
		M = banned_id.length;
		set = new HashSet<>();
		find(user_id,banned_id,0);

		return set.size();
	}

	private static void find(String[] user_id, String[] banned_id, int index){
		if(index == M){
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < N; i++){
				if(visited[i]){
					sb.append(i);
				}
			}
			set.add(sb.toString());
			return;
		}

		for(int i = 0; i < N; i++){
			if(!visited[i] && isEqual(user_id[i],banned_id[index])){
				visited[i] = true;
				find(user_id,banned_id,index+1);
				visited[i] = false;
			}
		}
	}

	private static boolean isEqual(String s1, String s2){
		int l1 = s1.length();
		int l2 = s2.length();
		if(l1!=l2){
			return false;
		}
		for(int i = 0; i < l1; i++){
			if(s2.charAt(i) == '*'){
				continue;
			}
			if(s1.charAt(i) != s2.charAt(i)){
				return false;
			}
		}

		return true;
	}
}
