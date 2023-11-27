package algo_202311;

import java.io.*;
import java.util.*;

public class BJ_1715_카드정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());

        Queue<Long> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++){
            pq.offer(Long.parseLong(br.readLine()));
        }

        if(N == 1) {
            System.out.println(0);
            return;
        }

        long sum = 0;
        while(N > 1){
            long a = pq.poll();
            long b = pq.poll();
            long input = a+b;
            sum += (input);
            pq.offer(input);
            N--;
        }


        System.out.println(sum);
    }
}
