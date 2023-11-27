package algo_202311;

import java.io.*;
import java.util.*;

public class BJ_1339_단어수학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] count = new int[26];

        String[] data = new String[N];
        for(int i = 0; i < N; i++){
            data[i] = br.readLine();
            int length = data[i].length();
            int mul = 1;
            for(int j = 1; j < length; j++){
                mul *= 10;
            }
            for(int j = 0; j < length; j++){
                count[data[i].charAt(j)-'A'] += mul;
                mul/=10;
            }
        }

        Queue<Data> pq = new PriorityQueue<>();
        for(int i = 0; i < 26; i++){
            if(count[i]>0){
                char c = (char)(i+'A');
                pq.offer(new Data(c,count[i]));
            }
        }

        Map<Character, Integer> map = new HashMap<>();
        int num = 9;
        while(!pq.isEmpty()){
            Data now = pq.poll();
            map.put(now.c,num--);
        }

        int sum = 0;
        for(int i = 0; i < N; i++){
            int length = data[i].length();
            int mul = 1;
            for(int j = 1; j < length; j++){
                mul*=10;
            }
            for(int j = 0; j < length; j++){
                sum += map.get(data[i].charAt(j))*mul;
                mul /= 10;
            }
        }
        System.out.println(sum);
    }

    public static class Data implements Comparable<Data>{
        char c;
        int value;

        public Data(char c, int value){
            this.c = c;
            this.value = value;
        }

        @Override
        public int compareTo(Data d){
            return d.value - this.value;
        }
    }
}
