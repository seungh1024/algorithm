package algo_202311;

import java.io.*;
import java.util.*;

public class BJ_1202_보석도둑 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Data[] data = new Data[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            data[i] = new Data(m,v);
        }
        Arrays.sort(data);


        int[] C = new int[K];
        for(int i = 0; i < K; i++){
            int input = Integer.parseInt(br.readLine());
            C[i] = input;
        }
        Arrays.sort(C);


        Queue<Integer> pq = new PriorityQueue<>((now,input)->{
            return input - now;
        });

        int index = 0;
        int size = 0;
        long result = 0;
        for(int i = 0; i < K; i++){
            int weight = C[i];
            while(index < N && data[index].weight <=weight){
                pq.offer(data[index].value);
                index++;
                size++;
            }
            if(size > 0){
                result += pq.poll();
                size--;
            }
        }
        System.out.println(result);
    }



    public static class Data implements Comparable<Data> {
        int weight;
        int value;

        public Data(int weight, int value){
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Data d){
            return this.weight - d.weight;
        }

        @Override
        public String toString(){
            return "weight: "+weight + ", value: "+value ;
        }
    }
}
//9 5
//4 5
//4 9
//4 10
//8 55
//14 20
//9 15
//8 55
//8 5
//11 54
//10
//5
//4
//15
//20