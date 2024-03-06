package algo_202403;

import java.util.*;

public class R_P_후보키 {
	private static Set<String> set; // 후보키 집합
	private static int N,M;
	private static boolean[] visited;
	private static List<Data> list;

	public int solution(String[][] relation) {
		int answer = 0;
		set = new HashSet<>();
		N = relation.length;
		M = relation[0].length;
		visited = new boolean[M];
		list = new ArrayList<>();

		find(0,0,relation);

		Collections.sort(list);

		Set<String> keySet = new HashSet<>();
		int size = list.size();
		boolean[] duplicated = new boolean[size];
		for(int i = 0; i < size; i++){
			// System.out.println(list.get(i));
			if(duplicated[i]) continue;
			// System.out.println(list.get(i));
			String key = list.get(i).key;
			char[] startKey = key.toCharArray();

			for(int j = i+1; j < size; j++){
				int keyCount = 0;
				char[] nextKey = list.get(j).key.toCharArray();
				for(int p = 0; p < list.get(i).length;p++){
					for(int q = 0; q < nextKey.length; q++){
						if(startKey[p] == nextKey[q]){
							keyCount++;
						}
					}
				}
				if(keyCount == list.get(i).length){
					duplicated[j] = true;
				}
			}

		}
		for(int i = 0; i < size; i++){
			if(!duplicated[i]){
				answer++;
			}
		}

		return answer;
	}

	private static void find(int index, int count, String[][] relation){
		if(index == M){
			if(count > 0){
				makeKey(relation,count);
			}

			return;
		}

		find(index + 1, count,relation);
		visited[index] = true;
		find(index + 1, count+1,relation);
		visited[index] = false;
	}

	private static void makeKey(String[][] relation, int count){
		Set<String> check = new HashSet<>();

		for(int i = 0; i < N; i++){
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < M; j++){
				if(visited[j]){
					sb.append(relation[i][j]);
				}
			}
			if(check.contains(sb.toString())){
				return;
			}else{
				check.add(sb.toString());
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++){
			if(visited[i]){
				sb.append(i);
			}
		}
		String key = sb.toString();
		list.add(new Data(key,count));
	}

	private static class Data implements Comparable<Data>{
		String key;
		int length;

		public Data(String key, int length){
			this.key = key;
			this.length = length;
		}

		@Override
		public int compareTo(Data d){
			if(this.length == d.length){
				return key.compareTo(d.key);
			}
			return this.length - d.length;
		}

		@Override
		public String toString(){
			return "key = "+key + ", length = "+length;
		}
	}
}
