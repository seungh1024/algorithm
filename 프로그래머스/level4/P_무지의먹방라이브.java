package algo_202311.kakaoblindrecruitment2019;

import java.util.*;

public class P_무지의먹방라이브 {
    public static void main(String[] args) {
        P_무지의먹방라이브 test = new P_무지의먹방라이브();
        int[] food_times = {3, 1, 1, 1, 2, 4, 3};
        long k = 12;
        int result = 6;
        int answer = test.solution(food_times,k);
        if(result == answer) System.out.println("success");
        else System.out.println("fail");
    }

    public int solution(int[] food_times, long k) {

        Queue<Food> pq = new PriorityQueue<>();
        int length = food_times.length;
        int size = length;

        boolean[] visited = new boolean[length];
        for(int i = 0; i < length; i++){
            pq.offer(new Food(i,food_times[i]));
        }

        long minusTime = 0;
        while(!pq.isEmpty()){
            Food food = pq.poll();
            int index = food.index;
            long time = food.time - minusTime;

            if(time*length <= k){
                visited[index] = true;
                k -= time*length;
                length--;
                minusTime += time;
            }else{
                minusTime += k/length;
                k = k%length;
            }
        }

        int answer = 0;
        for(int i = 0; i < size; i++){
            food_times[i] -= minusTime;
            if(food_times[i] > 0 && k >= 0){
                answer = i;
                k--;
            }
        }

        if(k >= 0){
            return -1;
        }

        return answer+1;
    }

    public class Food implements Comparable<Food> {
        int index;
        long time;

        public Food(int index, long time) {
            this.index = index;
            this.time = time;
        }

        @Override
        public int compareTo(Food f) {
            if (this.time == f.time) {
                return this.index - f.index;
            } else if (this.time < f.time) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
