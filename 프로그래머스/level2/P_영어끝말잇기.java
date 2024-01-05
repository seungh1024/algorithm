package algo_202401;

import java.util.*;

public class P_영어끝말잇기 {
	public static void main(String[] args) {
		P_영어끝말잇기 test = new P_영어끝말잇기();
		int n = 3;
		String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		int[] result = test.solution(n, words);
		if (Arrays.equals(result, new int[] {3, 3})) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	public int[] solution(int n, String[] words) {
		int[] answer = new int[2];

		Set<String> set = new HashSet<>();

		char last = words[0].charAt(words[0].length()-1);
		char first = 'a';
		int length = words.length;
		set.add(words[0]);
		for(int i = 1; i < length; i++){
			String s = words[i];
			first = s.charAt(0);
			if(last != first || set.contains(s)){
				answer[0] = i%n+1;
				answer[1] = i/n +1;
				break;
			}else{
				set.add(s);
			}

			last = s.charAt(s.length()-1);
		}

		return answer;
	}
}
