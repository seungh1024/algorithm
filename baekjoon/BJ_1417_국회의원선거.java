package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_1417_국회의원선거 {
    public static int N,dasom, result;
    public static PriorityQueue<Vote> q;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        q = new PriorityQueue<>();
        dasom = Integer.parseInt(br.readLine());

        for(int i = 1; i < N; i++){
            int input = Integer.parseInt(br.readLine());
            if (input >= dasom) {
                q.offer(new Vote(input));
            }
        }
        result = 0;
        buy();
        System.out.println(result);
    }
    public static class Vote implements Comparable<Vote>{
        int num;
        public Vote(int num){
            this.num = num;
        }
        @Override
        public int compareTo(Vote o){
            return o.num - this.num;
        }
    }

    public static void buy(){
        while(!q.isEmpty()){
            Vote now = q.poll();
//            System.out.println("poll: "+now.num);
            if(now.num >= dasom){
//                System.out.println("now: "+now);
                dasom++;
                now.num--;
                result++;
                q.offer(now);
            }
        }
    }
}
