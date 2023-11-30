package algo_202311;

import java.io.*;
import java.util.*;

public class BJ_10868_최솟값 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        int[] data = new int[N+1];
        for(int i = 1; i <= N; i++){
            data[i] = Integer.parseInt(br.readLine());
        }
        int[] lrFenwick = new int[N+1]; // 왼쪽에서 시작해서 오른쪽으로 합
        int[] rlFenwick = new int[N+1]; // 오른쪽에서부터 시작해서 오른쪽으로 합
        initFenwick(lrFenwick,rlFenwick,data, N);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int result = find(lrFenwick,rlFenwick,data,a,b,N);
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static int find(int[]lrFenwick, int[] rlFenwick, int[] data, int a, int b, int N) {
        int start = a;
        int range = start + (start & -start);
        int min = Integer.MAX_VALUE;
        while(range <= b){
            min = Math.min(min, rlFenwick[start]);
            start = range;
            range = start + (start & -start);
        }
        min = Math.min(min,data[start]);

        int end = b;
        range = end - (end & -end);
        while(range >= start){
            min = Math.min(min,lrFenwick[end]);
            end = range;
            range = end - (end & -end);
        }

        return min;
    }

    private static void initFenwick(int[] lrFenwick,int[]rlFenwick,int[] data, int N) {
        for(int i = 1; i <= N; i++){
            int size = i - (i & -i);
            int min = Integer.MAX_VALUE;
            for(int j = i; j > size; j--){
                min = Math.min(min,data[j]);
            }
            lrFenwick[i] = min;
        }

        for(int i = N; i > 0; i--){
            int size = i + (i& -i);
            if(size > N) size = N+1;
            int min = Integer.MAX_VALUE;
            for(int j = i; j < size; j++){
                min = Math.min(min,data[j]);
            }
            rlFenwick[i] = min ;
        }
    }
}
