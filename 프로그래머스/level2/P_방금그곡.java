package algo_202401;

import java.util.*;

public class P_방금그곡 {
	public static void main(String[] args) {
		P_방금그곡 test = new P_방금그곡();
		String m = "ABCDEFG";
		String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
		String answer = test.solution(m, musicinfos);
		String result = "HELLO";
		if (answer.equals(result)) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	public String solution(String m, String[] musicinfos) {
		String answer = "(None)";

		// Map<String,String> map = new HashMap<>();
		String[] tone = {"C#","D#","F#","G#","A#", "C","D","E","F","G","A","B"};
		String[] change = {"a","b","c","d","e","f","g","h","i","j","k","l"};

		for(int i = 0; i < 12; i++){
			m = m.replace(tone[i],change[i]);
		}
		// System.out.println(m);

		int maxPlayTime = 0;
		for(String input : musicinfos){
			String[] info = input.split(",");
			String[] start = info[0].split(":");
			String[] end = info[1].split(":");
			int startTime = Integer.parseInt(start[0])*60+Integer.parseInt(start[1]);
			int endTime = Integer.parseInt(end[0])*60+Integer.parseInt(end[1]);
			int playTime = endTime-startTime;
			for(int i = 0; i < 12; i++){
				info[3] = info[3].replace(tone[i],change[i]);
			}

			int length = info[3].length();
			StringBuilder sb = new StringBuilder();
			if(length <= playTime){
				int size = 0;
				while(size < playTime){
					size += length;
					sb.append(info[3]);
				}
			}else{
				for(int i = 0; i < playTime; i++){
					sb.append(info[3].charAt(i));
				}
			}

			if(sb.toString().contains(m)){
				int totalPlayTime = sb.length();
				if(maxPlayTime < playTime){
					maxPlayTime = playTime;
					answer = info[2];
				}

			}
		}

		return answer;
	}
}
