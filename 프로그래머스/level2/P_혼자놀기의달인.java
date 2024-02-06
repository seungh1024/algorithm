package algo_202402;

import java.util.*;

public class P_혼자놀기의달인 {
	public static void main(String[] args) {
		P_혼자놀기의달인 test = new P_혼자놀기의달인();
		int[] cards = {8,6,3,7,2,5,1,4};
		int answer = test.solution(cards);
		int result = 12;
		if (answer == result) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	public static int[] parent;
	public int solution(int[] cards) {
		int answer = 0;
		int length = cards.length;
		for(int i = 0; i < length; i++){
			cards[i]--;
		}
		parent = new int[length];
		for(int i = 0; i < length; i++){
			parent[i] = i;
		}

		for(int i = 0; i < length; i++){
			if(cards[i] != cards[cards[i]]){
				union(cards[i],cards[cards[i]]);
			}
		}
		for(int i = 0; i < length; i++){
			getParent(i);
		}

		int[] count = new int[length];
		for(int i = 0; i < length; i++){
			count[parent[i]]++;
		}
		Arrays.sort(count);
		// System.out.println(Arrays.toString(parent));
		// System.out.println(Arrays.toString(count));

		return count[length-1]*count[length-2];
	}

	public static int getParent(int i){
		if(i == parent[i]){
			return i;
		}
		return parent[i] = getParent(parent[i]);
	}

	public static void union(int a, int b){
		int pa = getParent(a);
		int pb = getParent(b);

		if(pa <= pb){
			parent[pb] = pa;
		}else{
			parent[pa] = pb;
		}
	}
}
