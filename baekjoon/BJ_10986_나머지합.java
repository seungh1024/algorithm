package algo_202312;

import java.io.*;
import java.util.*;

public class BJ_10986_나머지합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] data = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            data[i] = Long.parseLong(st.nextToken());
        }
        long[] sectionSum = new long[N];
        int[] mCount = new int[M];

        sectionSum[0] = data[0];
        mCount[(int)(sectionSum[0]%M)]++;
        for (int i = 1; i < N; i++) {
            sectionSum[i] += (sectionSum[i-1]+data[i]);
            int index = (int)(sectionSum[i]%M);
            mCount[index]++;
        }
//        System.out.println(Arrays.toString(mCount));

        long result = mCount[0];
        for(int i = 0; i < M; i++){
            if (mCount[i] >= 2) {
                long plus = 1;
                plus = plus * mCount[i] * (mCount[i]-1) / 2;
                result+=plus;
            }
        }
        System.out.println(result);
    }
}
