package algo_202311.kakaorecruitment2023;

import java.util.*;

public class P_개인정보수집유효기간 {
    public static void main(String[] args) {
        P_개인정보수집유효기간 test = new P_개인정보수집유효기간();
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        int[] result = {1,3};
        int[] answer = test.solution(today,terms,privacies);
        if(Arrays.equals(result,answer)) System.out.println("success");
        else System.out.println("fail");
    }

    public int[] solution(String today, String[] terms, String[] privacies) {
        int date = dateChanger(today);

        Map<String,Integer> map = new HashMap<>(); // 약관, 기간 저장
        StringTokenizer st;
        for(String s : terms){
            st = new StringTokenizer(s);
            map.put(st.nextToken(),Integer.parseInt(st.nextToken()));
        }

        List<Integer> list = new ArrayList<>();
        int index = 0;
        int size = 0;
        for(String privacy : privacies){
            String[] split = privacy.split(" ");
            String day = split[0];
            String key = split[1];
            int dayInfo = dateChanger(day);
            index++;
            if(isBreak(date,dayInfo,map.get(key))){
                list.add(index);
                size++;
            }
        }

        int[] answer = new int[size];
        for(int i = 0; i < size; i++){
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static boolean isBreak(int today, int privacy, int term){
        term = term*28;
        // System.out.println("today: "+today + ", privacy: "+(privacy+term));
        if(today >= privacy+term) return true;
        return false;
    }

    public static int dateChanger(String s){
        String[] todayArray = s.split("\\.");
        int sum = 0;
        int[] mul = {12*28,28,1};
        for(int i = 0; i < 3; i++){
            sum += Integer.parseInt(todayArray[i])*mul[i]; //전체 일수
        }

        return sum;
    }
}
