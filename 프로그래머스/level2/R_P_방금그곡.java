package algo_202403;

import java.util.*;

public class R_P_방금그곡 {
	private static Map<String,String> map;
	private static String[] melody = {"C#","D#","F#","G#","A#"};
	public String solution(String m, String[] musicinfos) {
		String answer = "(None)";

		initMap();
		for(String mel : melody){
			m = m.replace(mel,map.get(mel));
		}

		int length = musicinfos.length;
		Data[] datas = new Data[length];
		for(int i = 0; i < length; i++){
			String musicinfo = musicinfos[i];
			String[] info = musicinfo.split(",");
			Data input = new Data(info[0],info[1],info[2],info[3]);
			datas[i] = input;
		}

		int maxTime = 0;
		for(int i = 0; i < length; i++){
			Data now = datas[i];
			if(m.contains(now.info) || now.info.contains(m)){
				if(now.time > maxTime){
					answer = now.name;
					maxTime = now.time;
				}
			}
		}

		return answer;
	}

	public static class Data{
		int time;
		String name;
		String info;

		public Data(String startTime, String endTime, String name, String info){
			this.time = makeTime(startTime,endTime);
			this.name = name;
			this.info = makeInfo(info);
		}

		private int makeTime(String start, String end){
			String[] startInfo = start.split(":");
			String[] endInfo = end.split(":");

			int startTotal = Integer.parseInt(startInfo[0])*60 + Integer.parseInt(startInfo[1]);
			int endTotal = Integer.parseInt(endInfo[0])*60 + Integer.parseInt(endInfo[1]);

			return endTotal-startTotal;

		}

		private String makeInfo(String info){
			StringBuilder sb = new StringBuilder();
			char[] array = info.toCharArray();
			int length = array.length;
			int index = 0;

			for(int i = 0; i < this.time; i++){
				// #은 한 음으로 봐야하니 반복문 횟수에 포함시키지 않음
				if(array[index] == '#'){
					i--;
				}
				sb.append(array[index]);
				index = (index+1)%length;
			}
			// 마지막에 잘릴 수 있는 # 처리
			if(array[index] == '#'){
				sb.append(array[index]);
			}

			String totalInfo = sb.toString();
			for(String m : melody){
				totalInfo = totalInfo.replace(m,map.get(m));
			}

			return totalInfo;
		}

		@Override
		public String toString(){
			return "time = " +time + ", name = " + name + ", info = " + info;
		}

	}

	private static void initMap(){
		map = new HashMap<>();
		int length = melody.length;
		for(int i = 0; i < length; i++){
			map.put(melody[i],i+"");
		}
	}
}
