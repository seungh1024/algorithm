package algo_202312.re;

import java.io.*;
import java.util.*;

public class REBJ_1306_달려라홍준 {
    public static int N,M;
    public static int[] fenwick;
    public static int[] reverseFenwick;
    public static int[] data;

    public static void main(String[] args) throws IOException {
        init();
        int length = N-M+1;
        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= length; i++) {
            int left = i-(M-1);
            int right = i+(M-1);
            int result = getMax(left, right);
            sb.append(result).append(" ");
        }
        System.out.println(sb);
    }
    public static int getMax(int start, int end) {
        int result = 0;

        int range = start + (start & -start);
        while (range <= end) {
            result = Math.max(result, reverseFenwick[start]);
            start = range;
            range = start + (start & -start);
        }
        result = Math.max(result,data[start]);

//        start++;
        range = end - (end & -end);
        while (range >= start) {
            result = Math.max(result,fenwick[end]);
            end = range;
            range = end - (end & -end);
        }
        return result;
    }

    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        data = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        fenwick = new int[N+1];
        for(int index = 1; index <= N; index++) {
            int size = index - (index & -index);
            int max = 0;
            for (int i = index; i > size; i--) {
                max = Math.max(max,data[i]);
            }
            fenwick[index] = max;
        }
//        System.out.println(Arrays.toString(fenwick));

        reverseFenwick = new int[N+1];
        for (int index = N; index > 0; index--) {
            int size = index + (index & -index);
            if(size >= N) size = N+1;
            int max = 0;
            for (int i = index; i < size; i++) {
                max = Math.max(max,data[i]);
            }
            reverseFenwick[index] = max;
        }
//        System.out.println(Arrays.toString(reverseFenwick));
    }
}
