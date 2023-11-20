package algo_202311.kakaointern2019;

import java.util.*;

public class P_튜플 {
    public static void main(String[] args) {
        P_튜플 test = new P_튜플();
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        int[] result = {2,1,3,4};
        int[] answer = test.solution(s);

        if(Arrays.equals(result,answer)){
            System.out.println("success");
        }else{
            System.out.println("fail");
        }
    }

    public int[] solution(String s) {

        char[] array = s.toCharArray();

        StringBuilder sb = new StringBuilder();
        int length = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(char c : array){
            int num = c-'0';

            if(num >= 0 && num < 10){
                sb.append(num);
                length++;
            }

            if((c == ',' || c == '}') && length > 0){
                int key = Integer.parseInt(sb.toString());
                if(!map.containsKey(key)){
                    map.put(key, 1);
                }else{
                    map.put(key,map.get(key)+1);
                }
                length = 0;
                sb = new StringBuilder();
            }
        }

        Queue<Data> pq = new PriorityQueue<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            pq.offer(new Data(entry.getKey(), entry.getValue()));
        }

        int size = pq.size();
        int[] answer = new int[size];
        for(int i = 0; i < size; i++){
            answer[i] = pq.poll().key;
        }

        return answer;
    }

    public static class Data implements Comparable<Data>{
        int key, value;

        public Data(int key, int value){
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Data d){
            return d.value - this.value;
        }
    }
}

