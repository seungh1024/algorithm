package algo_202312.re;

import java.io.*;
import java.util.*;

public class REBJ_10986_나머지합 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] count = new long[M];
        long sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sum += Long.parseLong(st.nextToken());
            int index = (int)(sum%M);
            count[index]++;
        }

        long result = count[0];
        for (int i = 0; i < M; i++) {
            if (count[i] != 0) {
                result += (count[i] * (count[i]-1))/2;
            }
        }
        System.out.println(result);
    }
}
