package algo_202311.kakaointern2019;

import java.util.*;

public class P_호텔방배정 {
    public static void main(String[] args) {
        P_호텔방배정 test = new P_호텔방배정();
        long k = 10;
        long[] room_number = {1,3,4,1,3,1};
        long[] result = {1,3,4,2,5,6};
        long[] answer = test.solution(k, room_number);
        if(Arrays.equals(result,answer)) System.out.println("success");
        else System.out.println("fail");
    }

    public long[] solution(long k, long[] room_number) {

        Map<Long, Long> map = new HashMap<>();
        Queue<Long> q = new ArrayDeque<>();
        int length = room_number.length;
        long[] answer = new long[length];
        int index = 0;
        for(long num : room_number){
            if(!map.containsKey(num)){
                map.put(num,num+1);
                answer[index] = num;
                index++;
            }else{
                long findNumber = num;
                while(true){
                    long value = map.get(findNumber); // 다음 방 번호
                    q.offer(findNumber);
                    if(!map.containsKey(value)){ // 연쇄적으로 더이상 찾지 못하는 경우
                        long insertValue = value+1;
                        map.put(value,insertValue);
                        answer[index] = value;
                        index++;
                        while(!q.isEmpty()){
                            long now = q.poll();
                            map.put(now,insertValue);
                        }
                        break;
                    }
                    findNumber = value;
                }
            }
        }

        return answer;
    }
}
