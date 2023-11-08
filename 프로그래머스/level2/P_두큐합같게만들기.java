package algo_202311;

import java.io.*;
import java.util.*;

public class P_두큐합같게만들기 {
    public static void main(String[] args) {
        P_두큐합같게만들기 test = new P_두큐합같게만들기();
        int[] queue1 = {3,2,7,2};
        int[] queue2 = {4,6,5,1};
        //result = 2
        int answer = test.solution(queue1,queue2);
        System.out.println(answer);
    }
    public int solution(int[] queue1, int[] queue2) {

        long sum1 = 0;
        long sum2 = 0;
        int length = queue1.length;
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        for(int i = 0; i < length; i++){
            sum1 += queue1[i];
            sum2 += queue2[i];
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }

        int answer = find(q1, q2, sum1, sum2, length);

        return answer;
    }

    public static int find(Queue<Integer> q1, Queue<Integer> q2, long sum1, long sum2, int length){

        int count = 0;
        while(true){
            if(sum1 > sum2){
                int now = q1.poll();
                q2.offer(now);
                sum1 -= now;
                sum2 += now;
            }else if(sum1 < sum2){
                int now = q2.poll();
                q1.offer(now);
                sum2 -= now;
                sum1 += now;

            }else if(sum1 == sum2){
                break;
            }

            if(count >= 3*length){
                count = -1;
                break;
            }
            count++;
        }
        return count;
    }
}
