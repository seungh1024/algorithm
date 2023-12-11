package algo_202312.re;

import java.io.*;
import java.util.*;

public class REBJ_11000_강의실배정 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Data> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.offer(new Data(start,end));
        }

        long result = 0;
        Queue<Integer> endQ = new PriorityQueue<>();
        while (!pq.isEmpty()) {
            Data now = pq.poll();
//            System.out.println("now.start: "+now.start + ", now.end: "+now.end);
            if (!endQ.isEmpty()) {
                int v = endQ.peek();
                if (v <= now.start) {
                    endQ.poll();
                } else {
                    result++;
                }
            }else{
                result++;
            }
            endQ.offer(now.end);
        }
        System.out.println(result);
    }

    public static class Data implements Comparable<Data> {

        int start,end;

        public Data(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Data d) {
            return this.start - d.start;
        }
    }

}
