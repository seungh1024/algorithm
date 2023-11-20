package algo_202311.kakaointern2019;

import java.util.*;

public class P_징검다리건너기 {
    public static void main(String[] args) {
        P_징검다리건너기 test = new P_징검다리건너기();
        int[] stones = {2,4,5,3,2,1,4,2,5,1};
        int k = 3;
        int result = 3;
        int answer = test.solution(stones, k);
        if(result == answer) System.out.println("success");
        else System.out.println("fail");
    }

    public int solution(int[] stones, int k) {
        int answer = 0;

        Queue<Data> pq = new PriorityQueue<>();
        int length = stones.length;
        int[] l = new int[length]; // 현재 기준 왼쪽 징검다리 인덱스
        int[] r = new int[length]; // 현재 기준 오른쪽 징검다리 인덱스
        for(int i = 0; i < length; i++){
            pq.offer(new Data(i,stones[i]));
            l[i] = i-1;
            r[i] = i+1;
        }


        int minusValue = 0;
        int value = 0;

        while(!pq.isEmpty()){
            Data now = pq.poll(); // 가장 작은 값의 돌
            value = now.value-minusValue;
            answer+= value;
            minusValue += value;


            int left = l[now.index];
            int right = r[now.index];

            if(right-left > k) break;

            if(right < length){
                l[right] = left;
            }
            if(left >= 0){
                r[left] = right;
            }
        }

        return answer;
    }

    public static class Data implements Comparable<Data>{
        int index, value;

        public Data(int index, int value){
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Data d){
            if(this.value == d.value){
                return this.index - d.index;
            }
            return this.value- d.value;
        }
    }
}
