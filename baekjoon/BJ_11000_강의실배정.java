package algo_202311;

import java.io.*;
import java.util.*;

public class BJ_11000_강의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        Data[] data = new Data[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            data[i] = new Data(s,t);
        }

        Arrays.sort(data);
        int result = 0;
        Queue<Integer> pq = new PriorityQueue<>();
        pq.offer(data[0].end);

        for(int i = 1; i < N; i++){
            int end = pq.poll();
            if(end > data[i].start){
                pq.offer(end);
            }
            pq.offer(data[i].end);
        }

        System.out.println(pq.size());

    }

    public static class Data implements Comparable<Data>{
        int start,end;

        public Data(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Data d){
            return this.start - d.start;
        }

        @Override
        public String toString(){
            return "start: "+start +", end: "+end;
        }
    }
}

//8
//1 8
//9 16
//3 7
//8 10
//10 14
//5 6
//6 11
//11 12