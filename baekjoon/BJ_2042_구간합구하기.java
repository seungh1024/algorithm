package algo_202311;

import java.io.*;
import java.util.*;

public class BJ_2042_구간합구하기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long[] data = new long[N+1];
        long[] sectionSum = new long[N+1];
        for(int i = 1; i <= N; i++){
            data[i] = Long.parseLong(br.readLine());
        }

        initSectionSum(data, sectionSum, N);

        StringBuilder sb = new StringBuilder();
        int length = M+K;
        for(int i = 0; i < length; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a == 1){
                long c = Long.parseLong(st.nextToken());
                changeSectionSum(b,c,sectionSum, data, N);
            }else if(a == 2){ // 구간합 출력
                int c = Integer.parseInt(st.nextToken());
                sb.append(sectionSum(b,c,sectionSum)).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static long sectionSum(int start, int end, long[] sectionSum){
        long sum = 0;
        while(end > 0){
            sum += sectionSum[end];
            end -= (end & -end);
        }
        long minus = 0;
        start--;
        while(start > 0){
            minus += sectionSum[start];
            start -= (start &-start);
        }
        return sum-minus;
    }
    public static void changeSectionSum(int index, long number, long[] sectionSum, long[] data, int N){
        long origin = data[index];
        data[index] = number;
        long minus = number - origin;
        while(index <= N){
            sectionSum[index] += minus;
            index +=  (index & -index);
        }
//        System.out.println(Arrays.toString(sectionSum));
    }
    public static void initSectionSum(long[] data, long[]sectionSum, int N){
        for (int i = 1; i <= N; i++) {
            int length = i-(i & -i);
            long sum = 0;
            for(int j = i; j > length; j--){
                sum += data[j];
            }
            sectionSum[i] = sum;
        }
//        System.out.println(Arrays.toString(sectionSum));
    }
}
