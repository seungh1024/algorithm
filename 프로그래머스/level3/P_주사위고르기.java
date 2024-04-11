package algo_202403;

import java.util.*;

public class P_주사위고르기 {
	public static boolean[] visited;
	public static int N;
	public static int min;
	public static int[] result;
	public static Set<String> set;

	public int[] solution(int[][] dice) {
		int[] answer = {};
		N = dice.length;
		visited = new boolean[N];
		min = 0;
		result = new int[N/2];
		set = new HashSet<>();

		find(0,0,dice);
		for(int i = 0; i < N/2; i++){
			result[i]++;
		}
		answer = result;
		// System.out.println(set);
		return answer;
	}

	public static void find(int index, int count, int[][] dice){
		if(count == N/2){ // n/2개 선택 완료
			int size = N/2;
			int[] A = new int[size];
			int[] B = new int[size];
			int ai = 0;
			int bi = 0;
			StringBuilder ak = new StringBuilder();
			StringBuilder bk = new StringBuilder();
			// System.out.println(Arrays.toString(visited));
			for(int i = 0; i < N; i++){
				if(visited[i]){
					A[ai++] = i;
					ak.append(i);
				}else{
					B[bi++] = i;
					bk.append(i);
				}
			}
			if(set.contains(ak.toString()) || set.contains(bk.toString())){
				return;
			}
			set.add(ak.toString());
			set.add(bk.toString());

			List<Integer> la = new ArrayList<>();
			List<Integer> lb = new ArrayList<>();
			getScore(0,size,0,0,A,B,dice,la,lb);
			Collections.sort(la);
			Collections.sort(lb);

			int win = 0;
			int lose = 0;
			Map<Integer,int[]> map = new HashMap<>();
			int listSize = la.size();
			for(int i = 0; i < listSize; i++){
				int a = la.get(i);
				int resultIndex = lower(a,lb,listSize);

				win +=(resultIndex);
				resultIndex = upper(a,lb,listSize);
				lose += (listSize-resultIndex);
			}

			if(min < win){
				min = win;
				result = A;
			}
			if(min < lose){
				min = lose;
				result = B;
			}

			return;
		}
		if(index >= N){
			return;
		}

		visited[index] = true;
		find(index+1,count+1,dice);
		visited[index] = false;
		find(index+1,count,dice);
	}

	public static int lower(int num, List<Integer>list , int size){
		int start = 0;
		int end = size;

		while(start < end){
			int mid = (start+end)/2;

			if(list.get(mid) >= num){
				end = mid;
			}else{
				start = mid+1;
			}
		}

		return start;
	}

	public static int upper(int num, List<Integer> list, int size){
		int start = 0;
		int end = size;

		while(start < end){
			int mid = (start+end)/2;

			if(list.get(mid) > num){
				end = mid;
			}else{
				start = mid+1;
			}
		}
		return start;
	}

	public static void getScore(int index, int size, int num1, int num2, int[] array1, int[] array2, int[][] dice, List<Integer> list1, List<Integer> list2){
		if(index == size){
			list1.add(num1);
			list2.add(num2);
			return;
		}

		int d1 = array1[index];
		int d2 = array2[index];
		for(int i = 0; i < 6; i++){
			getScore(index+1,size,num1+dice[d1][i], num2 +dice[d2][i],array1,array2,dice,list1,list2);
		}
	}
}
