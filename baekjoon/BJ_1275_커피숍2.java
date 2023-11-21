package algo_202311;

import java.util.*;
import java.io.*;

public class BJ_1275_커피숍2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수의 개수
        int Q = Integer.parseInt(st.nextToken()); // 턴
        long[] data = new long[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            data[i] = Long.parseLong(st.nextToken());
        }

        long[] sectionSum = new long[N+1];
        initSectionSum(data, sectionSum, N);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(getSectionSum(Math.min(x,y),Math.max(x,y),sectionSum)).append("\n");
            changeValue(a,b,data,sectionSum,N);
        }
        System.out.println(sb);
    }

    public static long getSectionSum(int x, int y, long[] sectionSum){
        long result = 0;
        while(y > 0){
            result += sectionSum[y];
            y -= (y&-y);
        }
        x--;
        long minus = 0;
        while(x > 0){
            minus += sectionSum[x];
            x -= (x&-x);
        }
        return result - minus;
    }

    public static void changeValue(int a, int b, long[] data, long[] sectionSum, int N) {
        long origin = data[a];
        data[a] = b;
        long plusValue = b-origin;
        while(a <= N){
            sectionSum[a] += plusValue;
            a += (a&-a);
        }
    }

    public static void initSectionSum(long[] data, long[] sectionSum, int N){
        for(int i = 1; i <= N; i++){
            int size = i - (i & -i);
            long sum = 0;
            for(int j = i; j > size; j--){
                sum+= data[j];
            }
            sectionSum[i] = sum;
        }
    }
}
