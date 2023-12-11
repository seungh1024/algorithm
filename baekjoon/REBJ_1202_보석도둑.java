package algo_202312.re;

import java.io.*;
import java.util.*;

public class REBJ_1202_보석도둑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Data[] data = new Data[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            data[i] = new Data(m,v);
        }
        Arrays.sort(data);

        Queue<Integer> pq = new PriorityQueue<>((o1,o2)->{
            return o2-o1; //큰거 먼저 나오게
        });
        int[] backpack = new int[K];
        for (int i = 0; i < K; i++) {
            backpack[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(backpack);


        long result = 0;
        int index = 0;
        for (int i = 0; i < K; i++) {
            int m = backpack[i];
            while (index<N) {
                Data now = data[index];
//                System.out.println("now.m: "+now.m +", now.v: "+now.v);
                if (now.m > m) {
                    break;
                }
                index++;
                pq.offer(now.v);
            }
            if (!pq.isEmpty()) {
                result += (long)pq.poll();
            }
        }
        System.out.println(result);
    }

    public static class Data implements Comparable<Data> {

        int m,v; //m = 무게, v = 가격

        public Data(int m, int v) {
            this.m = m;
            this.v = v;
        }

        @Override
        public int compareTo(Data d) {
            return this.m-d.m;
        }

    }


}
