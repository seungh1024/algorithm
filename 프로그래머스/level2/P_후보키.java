package algo_202402;

import java.util.*;

public class P_후보키 {
	public static void main(String[] args) {
		P_후보키 test = new P_후보키();
		String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
		int answer = test.solution(relation);
		int result = 2;
		if (answer == result) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	public static boolean[] visited;
	public static int result;
	public static String[][] data;
	public static List<String> uniqueCheck;
	public int solution(String[][] relation) {
		result = 0;
		data = relation;
		uniqueCheck = new ArrayList<>();

		int n = relation[0].length;
		visited = new boolean[n];
		for(int i = 1; i <= n; i++){
			combination(n,0,0,i);
		}

		return result;
	}

	public static void combination(int n, int index, int count, int target){
		if(count == target){
			findRelation(n);
			// System.out.println(Arrays.toString(visited));
			return;
		}
		if(index >= n){
			return;
		}

		visited[index] = true;
		combination(n, index+1,count+1,target);
		visited[index] = false;
		combination(n, index+1,count,target);

	}

	public static void findRelation(int n){
		List<Integer> list = new ArrayList<>();
		StringBuilder unique = new StringBuilder();
		for(int i = 0; i < n; i++){
			if(visited[i]){
				list.add(i);
				unique.append(i);
			}
		}


		Set<String> set = new HashSet<>();
		for(String[] tuple : data){
			StringBuilder sb = new StringBuilder();
			for(int s:list){
				sb.append(tuple[s]);
			}
			set.add(sb.toString());
		}
		// System.out.println(set);
		if(data.length == set.size()){
			for(String key : uniqueCheck){
				if(unique.toString().contains(key)){
					return;
				}
				char[] checkList = key.toCharArray();
				int count = 0;
				for(char c : checkList){
					if(unique.toString().contains(c+"")){
						count++;
					}
				}
				if(count == checkList.length){
					return;
				}


			}
			result++;
			uniqueCheck.add(unique.toString());
		}

	}
}
