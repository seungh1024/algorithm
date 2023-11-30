package algo_202311;

import java.io.*;
import java.util.*;

public class BJ_2268_수들의합7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] fenwick = new long[N+1];
        long[] data = new long[N+1];

        initFenwick(fenwick,data,N);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int check = Integer.parseInt(st.nextToken());
            if(check == 0){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                sb.append(sum(fenwick,Math.min(a,b),Math.max(a,b))).append("\n");
            }else if(check == 1){
                int a = Integer.parseInt(st.nextToken());
                long k = Long.parseLong(st.nextToken());
                modify(fenwick,data,N,a,k);
            }
//            System.out.println(Arrays.toString(fenwick));
        }
        System.out.println(sb);
    }

    public static long sum(long[] fenwick, int a, int b){
//        System.out.println("a: "+a +", b: "+b);
        long sumB = 0;
        while(b > 0){
            sumB+=fenwick[b];
            b -= (b & -b);
        }
        long sumA = 0;
        a--;
        while(a > 0){
            sumA += fenwick[a];
            a -= (a & -a);
        }
//        System.out.println("sumB: "+sumB + ", sumA: "+sumA);

        return sumB-sumA;
    }

    public static void modify(long[] fenwick, long[] data, int N, int a, long k){
        int index = a;
        long minus = data[a];
        data[a] = k;
        while(index <= N){
            fenwick[index] += (k-minus);
            index += (index & -index);
        }
    }

    public static void initFenwick(long[] fenwick, long[] data, int N) {
        for(int i = 1; i <= N; i++){
            int size = i - (i & -i);
            long sum = 0;
            for(int j = i; j > size; j--){
                sum += data[j];
            }
            fenwick[i] = sum;
        }
    }
}
