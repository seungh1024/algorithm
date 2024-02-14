package algo_202402;

import java.util.*;

public class P_순위검색 {
	public static void main(String[] args) {
		P_순위검색 test = new P_순위검색();
		String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210",
			"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
			"python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200",
			"cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100",
			"- and - and - and - 150"};
		int[] answer = test.solution(info, query);
		int[] result = {1,1,1,1,2,4};
		if (Arrays.equals(answer, result)) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	private static Map<String,List<Integer>> map;
	public int[] solution(String[] info, String[] query) {
		initMap(info);


		int queryLength = query.length;
		int[] answer = new int[queryLength];
		for(int i = 0; i < queryLength; i++){
			String[] input = query[i].replace(" and ","").split(" ");
			List<Integer> value = map.get(input[0]);
			if(value == null) continue;

			int size = value.size();
			int start = findIndex(value,Integer.parseInt(input[1]),size);

			answer[i] = size-start;
		}

		return answer;
	}

	public static int findIndex(List<Integer> info, int point, int length){
		int result = 0;

		int start = 0;
		int end = length;
		while(start<end){
			int mid = (start+end)/2;

			if(info.get(mid) < point){
				start = mid+1;
			}else{
				end = mid;
			}
		}

		return start;
	}

	public static void initMap(String[] info){
		map = new HashMap<>();

		int infoLength = info.length;
		for(int i = 0; i < infoLength; i++){
			String[] input = info[i].split(" ");
			String[] lan = {input[0],"-"};
			String[] job = {input[1],"-"};
			String[] car = {input[2], "-"};
			String[] food = {input[3],"-"};
			int ll = lan.length;
			int jl = job.length;
			int cl = car.length;
			int fl = food.length;
			for(int q = 0; q < ll; q++){
				for(int w = 0; w < jl; w ++){
					for(int e = 0; e < cl; e++){
						for(int r = 0; r < fl; r++){
							StringBuilder sb = new StringBuilder();
							sb.append(lan[q]).append(job[w]).append(car[e]).append(food[r]);
							List<Integer> data = map.get(sb.toString());
							if(data == null){
								data = new ArrayList<>();
							}
							data.add(Integer.parseInt(input[4]));
							map.put(sb.toString(),data);
						}
					}
				}
			}
		}

		for(Map.Entry<String,List<Integer>> entry : map.entrySet()){
			List<Integer> value = entry.getValue();
			Collections.sort(value);
			map.put(entry.getKey(),value);
		}
	}
}
