package algo_202312;

import java.io.*;
import java.util.*;

public class BJ_2212_센서 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[] data = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(data);
//        System.out.println(Arrays.toString(data));

        if (K == 1) {
            System.out.println(data[N - 1] - data[0]);
            return;
        } else if (K >= N) {
            System.out.println(0);
            return;
        }

        PriorityQueue<Data> pq = new PriorityQueue<>();
        for (int i = 1; i < N; i++) {
            pq.offer(new Data(i - 1, i, data[i] - data[i - 1]));
        }
        PriorityQueue<Integer> indexes = new PriorityQueue<>();
        for (int i = 1; i < K; i++) {
            Data now = pq.poll();
            indexes.offer(now.li);
            indexes.offer(now.ri);
        }

        int left = 0;
        int right = 0;
        int result = 0;
        while (!indexes.isEmpty()) {
            right = indexes.poll();
            result += data[right]-data[left];
            left = indexes.poll();
        }
        result += data[N-1] - data[left];
        System.out.println(result);

    }

    public static class Data implements Comparable<Data> {
        int li, ri; // left index, right index
        int length; // right - left;

        public Data(int li, int ri, int length) {
            this.li = li;
            this.ri = ri;
            this.length =  length;
        }

        @Override
        public int compareTo(Data data) {
            return data.length - this.length; // length 큰거부터 출력
        }

    }

}
