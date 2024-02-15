package algo_202402;

import java.util.*;


public class P_단체사진찍기 {
	public static void main(String[] args) {
		P_단체사진찍기 test = new P_단체사진찍기();
		int n = 2;
		String[] data = {"N~F=0", "R~T>2"};
		int answer = test.solution(n, data);
		int result = 3648;
		if (answer == result) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}

	}
	private static char[] member = {'A','C','F','J','M','N','R','T'};
	private static boolean[] check = new boolean[8];
	private static char[] line;
	private static char[][] condition;
	private static int result,test;

	public int solution(int n, String[] data) {
		int answer = 0;
		result = 0;
		test = 0;
		line = new char[8];
		condition = new char[n][5];
		for(int i = 0; i < n; i++){
			char[] input = data[i].toCharArray();
			for(int j = 0; j < 5; j++){
				condition[i][j] = input[j];
			}
			// System.out.println(Arrays.toString(condition[i]));
		}

		makeLine(0,8,n);
		// isValid(n);
		return result;
	}

	public static void makeLine(int index, int range, int n){
		if(index == range){
			if(isValid(n)){
				result++;
			}
			return;
		}

		for(int i = 0; i < 8; i++){
			if(!check[i]){
				line[index] = member[i];
				check[i] = true;
				makeLine(index+1,range,n);
				check[i] = false;
			}
		}
	}

	public static boolean isValid(int n){
		for(int i = 0; i < n; i++){
			char leftFriend = condition[i][0];
			char rightFriend = condition[i][2];
			char con = condition[i][3];
			int num = condition[i][4]-'0';

			// System.out.println("leftF: "+leftFriend+ ", rightF: "+rightFriend + ", con: "+ con + ", num: "+num);

			int left = 0;
			int right = 0;
			for(int j = 0; j < 8; j++){
				if(line[j] == leftFriend){
					left = j;
				}else if(line[j] == rightFriend){
					right = j;
				}
			}

			int range = Math.abs(right-left)-1;


			if(con == '='){
				if(range != num){
					return false;
				}
			}else if(con == '<'){
				if(!(range < num)){
					return false;
				}
			}else if(con == '>'){
				if(!(range > num)){
					return false;
				}
			}

		}
		return true;
	}
}
