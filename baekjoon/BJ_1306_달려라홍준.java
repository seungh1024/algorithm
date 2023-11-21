package algo_202311;

import java.io.*;
import java.util.*;

public class BJ_1306_달려라홍준 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 칸수
        int M = Integer.parseInt(st.nextToken()); // 시야
        st = new StringTokenizer(br.readLine());
        int[] data = new int[N+1];
        for(int i = 1; i <= N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        int[] botToTopMax = new int[N+1];
        int[] topToBotMax = new int[N+1];
        initMax(data,botToTopMax, topToBotMax, N);

        int plusValue = M-1;
        StringBuilder sb = new StringBuilder();
        for(int i = M; i + plusValue <= N; i++){
            int start = i - plusValue;
            int end = i + plusValue;
            sb.append(getMax(start,end,data,botToTopMax,topToBotMax,N)).append(" ");
        }
        System.out.println(sb);
    }

    public static int getMax(int start, int end, int[] data, int[] botToTopMax, int[] topToBotMax, int N) {
        int max = 0;

        int now = start;
        int range = now + (now &-now);
        while(range <= end){
            max = Math.max(max, botToTopMax[now]);
            now = range;
            range = now + (now & -now);
        }
        max = Math.max(max, data[now]);

        now = end;
        range = now - (now & -now);
        while(range >= start){
            max = Math.max(max, topToBotMax[now]);
            now = range;
            range = now - (now & -now);
        }

        return max;
    }
    public static void initMax(int[] data, int[]botToTopMax, int[] topToBotMax, int N){
        for(int i = 1; i <= N; i++){
            int size = i - (i & -i);
            int max = 0;
            for(int j = i; j > size; j--){
                max = Math.max(max,data[j]);
            }
            topToBotMax[i] = max;
        }

        for(int i = N; i > 0; i--){
            int size = Math.min(i + (i & -i), N+1);
            int max = 0;
            for(int j = i; j <size; j++){
                max = Math.max(max,data[j]);
            }
            botToTopMax[i] = max;
        }
//        System.out.println(Arrays.toString(botToTopMax));
//        System.out.println(Arrays.toString(topToBotMax));
    }
}
