package algo_202310;

import java.io.*;
import java.util.*;

public class BJ_28438_행렬연산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] row = new int[N+1];
        int[] col = new int[M+1];

        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());
            int value = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            if (value == 1) {
                row[r] += u;
            } else {
                col[r] += u;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
            for (int j = 1; j <= M; j++) {
                sb.append(row[i]+col[j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
