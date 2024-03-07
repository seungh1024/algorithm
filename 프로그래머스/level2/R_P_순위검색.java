package algo_202403;

import java.util.*;

public class R_P_순위검색 {
	private static Map<String,List<Integer>> map;
	private static String[][] queryData = {
		{"cpp","java","python"},
		{"backend","frontend"},
		{"junior" , "senior"},
		{"chicken", "pizza"}
	};
	public int[] solution(String[] info, String[] query) {
		initMap(info);
		for(Map.Entry<String,List<Integer>> entry : map.entrySet()){
			List<Integer> list = entry.getValue();
			Collections.sort(list);
		}
		int length = query.length;
		int[] answer = new int[length];
		for(int i = 0; i < length; i++){
			answer[i] = doQuery(query[i]);
		}
		return answer;
	}

	private static int doQuery(String input){
		String[] data = input.split(" and ");
		String[] last = data[3].split(" ");
		String[] total = new String[4];
		for(int i = 0; i < 3; i++){
			total[i] = data[i];
		}
		total[3] = last[0];
		int score = Integer.parseInt(last[1]);

		int[] result = new int[1];
		findPerson(0,total,result,score,"");
		// System.out.println("result = "+result[0]);
		return result[0];
	}

	private static void findPerson(int index, String[] total, int[] result, int score, String key){
		if(index == 4){
			List<Integer> list = map.get(key);
			if(list != null){
				// System.out.println(list);
				result[0] += countPerson(list,score);
				// countPerson(list,score);
				// int count = 0;
				// int size = list.size();
				// for(int i = 0; i < size; i++){
				//     if(list.get(i) >= score){
				//         result[0]+=(size-i);
				//         break;
				//     }
				// }
			}

			return;
		}

		if(total[index].equals("-")){
			for(String s : queryData[index]){
				findPerson(index+1,total,result,score,key+s);
			}
		}else{
			findPerson(index+1,total,result,score,key+total[index]);
		}
	}

	private static int countPerson(List<Integer> list, int score){
		int start = 0;
		int end = list.size()-1;

		while(start <= end){
			int mid = (start+end)/2;

			if(list.get(mid) >= score){
				end = mid-1;
			}else{
				start = mid+1;
			}
		}
		// System.out.println(list);
		// System.out.println("score = "+score);
		// System.out.println("start = "+start + ", end = "+end);

		return list.size()-(start);
	}

	private static void initMap(String[] info){
		map = new HashMap<>();
		for(String in : info){
			String[] data = in.split(" ");
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < 4; i++){
				sb.append(data[i]);
			}
			String key = sb.toString();
			int value = Integer.parseInt(data[4]);

			List<Integer> list = map.get(key);
			if(list == null){
				List<Integer> newList = new ArrayList<>();
				newList.add(value);
				map.put(key,newList);
			}else{
				list.add(value);
				map.put(key,list);
			}
		}
	}
}
