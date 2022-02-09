package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Algo_9375_패션왕신해빈 {
	public static Map<String,Integer> map; //옷 종류 사용 여부
//	public static String[][] data;
//	public static int result;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int result = 1;
			map = new HashMap<>();
			int n = Integer.parseInt(br.readLine());
//			data = new String[n][2];
			//데이터 입력
			for(int j = 0; j < n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String d1 = st.nextToken();
				String d2 = st.nextToken();
//				data[j] = new String[] {d1,d2};
//				System.out.println(Arrays.toString(data[j]));
				if(map.get(d2)!=null) {
					map.put(d2, map.get(d2)+1);
				}else {
					map.put(d2, 1);
				}
				
			}//end 입력
			Collection<Integer> count = map.values();
			for(int c : count) {
				result = result*(c+1);
			}
//			System.out.println(map.values());
			
//			com(0,0);
			System.out.println(result-1);//모두 false인 경우를 빼
		}//end 테스트 반복
	}
	
//	//length = data 의 길이
//	public static void com(int index,int cnt) {
//		if(cnt >= map.size() || index == data.length) {
//			result ++;
//			return;
//		}
//		if(!map.get(data[index][1])) {//사용하지 않았다면
//			map.put(data[index][1], true);//사용중으로 만들고
//			com(index+1,cnt+1);
//			map.put(data[index][1], false);
//		}
//		
//		com(index+1,cnt);
//		
//	}

}
