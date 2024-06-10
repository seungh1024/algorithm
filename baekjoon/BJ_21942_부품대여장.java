package algo_202406;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class BJ_21942_부품대여장 {
	public static int N;
	public static long F;
	public static int D,H,M;
	public static long[] monthToDay = {0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		String[] L = st.nextToken().split("/");
		D = Integer.parseInt(L[0]);
		String[] HM = L[1].split(":");
		H = Integer.parseInt(HM[0]);
		M = Integer.parseInt(HM[1]);
		F = Long.parseLong(st.nextToken());

		Map<String, LocalDateTime> map = new HashMap<>();

		Map<String, Long> overName = new TreeMap<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String[] YMD = st.nextToken().split("-");
			HM = st.nextToken().split(":");
			String key = st.nextToken() +" " + st.nextToken(); // 물건명 + 이름
			LocalDateTime value = map.get(key);
			int yyyy = Integer.parseInt(YMD[0]);
			int MM = Integer.parseInt(YMD[1]);
			int dd = Integer.parseInt(YMD[2]);
			int hh = Integer.parseInt(HM[0]);
			int mm = Integer.parseInt(HM[1]);

			// 반납 시간
			LocalDateTime time = LocalDateTime.of(yyyy, MM, dd, hh, mm);

			if (value != null) {
				value = value.plusDays(D);
				value = value.plusHours(H);
				value = value.plusMinutes(M);

				if (value.isBefore(time)) {
					long overTime = getOverTime(value,time);
					String name = key.split(" ")[1];
					Long money = overName.get(name);
					if (money == null) {
						overName.put(name, overTime*F);
					} else {
						overName.put(name, money +overTime*F);
					}
				}

				map.remove(key);
			} else {
				map.put(key,time);
			}
		}


		StringBuilder sb = new StringBuilder();
		for(Map.Entry<String,Long> entry : overName.entrySet()){
			sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
		}

		if (sb.length()==0) {
			System.out.println(-1);
		} else {
			System.out.println(sb);
		}



	}

	public static long getOverTime(LocalDateTime start, LocalDateTime end) {

		long left = ((monthToDay[start.getMonthValue()] + start.getDayOfMonth())*24L + start.getHour())*60L+start.getMinute();
		long right = ((monthToDay[end.getMonthValue()] + end.getDayOfMonth())*24L + end.getHour())*60L+end.getMinute();


		return right-left;
	}

	public static class Data{
		String name;
		Long money;

		public Data(String name, Long money){
			this.name = name;
			this.money = money;
		}

		public String getName(){
			return name;
		}

	}
}

// 16 001/00:00 4000
// 2021-01-01 09:12 arduino tony9402
// 2021-12-31 13:24 arduino tony9402
// 2021-01-23 14:04 raspberrypi tony9402
// 2021-02-01 18:21 resistance amsminn
// 2021-02-03 23:14 transistor codethinking
// 2021-02-28 23:55 transistor codethinking
// 2021-02-09 12:45 resistance amsminn
// 2021-02-13 14:37 raspberrypi tony9402
// 2021-01-01 09:12 arduino tony9402
// 2021-01-13 13:24 arduino tony9402
// 2021-02-15 12:12 raspberrypi q540jh
// 2021-02-15 12:13 raspberrypi q540jh
// 2021-01-01 09:12 arduino tony9402
// 2021-01-01 09:13 monitor chansol
// 2021-01-01 09:18 arduino tony9402
// 2021-01-01 09:18 monitor chansol