package algo_202311;

import java.io.*;
import java.util.*;

public class BJ_2357_최솟값과최댓값펜윅 {
    public static int[] data;
    public static int[] maxFenwick;
    public static int[] minFenwick;
    public static int[] maxReverseFenwick;
    public static int[] minReverseFenwick;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        data = new int[N+1];
        for (int i = 1; i <= N; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }

        maxFenwick = new int[N+1];
        minFenwick = new int[N+1];
        maxReverseFenwick = new int[N+1];
        minReverseFenwick = new int[N+1];
        initFenwick(N);


        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(getMin(a,b)).append(" ").append(getMax(a,b)).append("\n");
        }
        System.out.println(sb);
    }

    public static int getMax(int start, int end){
        int index = start;
        int range = index + (index & -index);
        int max = 0;
        while(range <= end){
            max = Math.max(max, maxReverseFenwick[index]);
            index = index + (index & -index);
            range = index + (index & -index);
        }
        max = Math.max(max, data[index]);

        index = end;
        range = end - (end & -end);
        while(range >= start){
            max = Math.max(max, maxFenwick[index]);
            index = index - (index & -index);
            range = index - (index & -index);
        }

        return max;
    }

    public static int getMin(int start, int end){
        int index = start;
        int range = index + (index & -index);
        int min = Integer.MAX_VALUE;
        while(range <= end){
            min = Math.min(min, minReverseFenwick[index]);
            index = index + (index & -index);
            range = index + (index & -index);
        }
        min = Math.min(min, data[index]);

        index = end;
        range = end - (end & -end);
        while(range >= start){
            min = Math.min(min, minFenwick[index]);
            index = index - (index & -index);
            range = index - (index & -index);
        }

        return min;
    }

    public static void initFenwick(int N){
        for(int i = 1; i <= N; i++){
            int size = i - (i & -i);
            int max = 0;
            int min = Integer.MAX_VALUE;
            for(int j = i; j > size; j--){
                max = Math.max(max,data[j]);
                min = Math.min(min,data[j]);
            }
            maxFenwick[i] = max;
            minFenwick[i] = min;
        }

        for(int i = N; i > 0; i--){
            int size = i + (i & -i);
            if(size > N) size = N+1;
            int max = 0;
            int min = Integer.MAX_VALUE;
            for(int j = i; j < size; j++){
                max = Math.max(max,data[j]);
                min = Math.min(min,data[j]);
            }
            maxReverseFenwick[i] = max;
            minReverseFenwick[i] = min;
        }
    }
}
