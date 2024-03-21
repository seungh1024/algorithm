package algo_202403;

import java.util.*;

public class R_P_표병합 {
	public static int[][] group;
	public static int autoPk;
	public static Map<Integer,String> map;
	public static int N = 51;
	public static int M = 51;

	public String[] solution(String[] commands) {
		group = new int[N][M];
		autoPk = 1;
		map = new HashMap<>();
		for(int i = 1; i < N; i++){
			for(int j = 1; j < M; j++){
				group[i][j] = autoPk++;
			}
		}

		List<String> list = new ArrayList<>();

		for(String s : commands){
			String[] input = s.split(" ");
			if(input[0].equals("UPDATE")){
				if(input.length >3){ // update r c value
					int r = Integer.parseInt(input[1]);
					int c = Integer.parseInt(input[2]);
					update(r,c,input[3]);
				}else{ // update value1 value2
					update(input[1],input[2]);
				}
			}else if(input[0].equals("MERGE")){
				int r1 = Integer.parseInt(input[1]);
				int c1 = Integer.parseInt(input[2]);
				int r2 = Integer.parseInt(input[3]);
				int c2 = Integer.parseInt(input[4]);
				merge(r1,c1,r2,c2);
			}else if(input[0].equals("UNMERGE")){
				int r = Integer.parseInt(input[1]);
				int c = Integer.parseInt(input[2]);
				unmerge(r,c);
			}else if(input[0].equals("PRINT")){
				int r = Integer.parseInt(input[1]);
				int c = Integer.parseInt(input[2]);
				int key = group[r][c];
				String value = map.get(key);
				if(value == null){
					list.add("EMPTY");
				}else{
					list.add(value);
				}
			}
		}

		int size = list.size();
		String[] answer = new String[size];
		for(int i = 0; i < size; i++){
			answer[i] = list.get(i);
		}
		return answer;
	}

	public static void unmerge(int r, int c){
		int target = group[r][c];
		for(int i = 1; i < N; i++){
			for(int j = 1; j < M; j++){
				if(group[i][j] == target){
					group[i][j] = autoPk++;
				}
			}
		}
		group[r][c] = target;
	}

	public static void merge(int r1, int c1, int r2, int c2){
		int g1 = group[r1][c1];
		int g2 = group[r2][c2];

		String value1 = map.get(g1);
		String value2 = map.get(g2);
		int target = g2;
		int change = g1;
		if(value1 == null){ // 1에 값이 아직 없으니까 2의 값을 1로 바꿔줘야 함
			target = g1;
			change = g2;
		}

		for(int i = 1; i < N; i++){
			for(int j = 1; j < M; j++){
				if(group[i][j] == target){
					group[i][j] = change;
				}
			}
		}

		String input = map.get(change);
		if(input != null){
			map.put(target,input);
		}


	}

	public static void update(String value1, String value2){
		for(Map.Entry<Integer,String> entry : map.entrySet()){
			int key = entry.getKey();
			String value = entry.getValue();
			if(value.equals(value1)){
				map.put(key,value2);
			}
		}
	}

	public static void update(int r, int c, String value){
		if(group[r][c] == 0){
			group[r][c] = autoPk++;
		}
		int pk = group[r][c];
		map.put(pk,value);
	}
}
