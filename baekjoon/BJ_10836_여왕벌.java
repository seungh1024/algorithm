package algo_202312;

import java.io.*;
import java.util.*;

public class BJ_10836_여왕벌 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); //격자 가로,세로 크기
        int N = Integer.parseInt(st.nextToken()); //날짜 수

        int size= 2*M-1;
        int[] count = new int[size];
        for (int i = 0; i < N; i++) {
            int index = 0;
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            index += a;
            for(int j = 0; j < b; j++){
                count[index]++;
                index++;
            }
            for(int j = 0; j < c; j++){
                count[index]+=2;
                index++;
            }
        }
//        System.out.println(Arrays.toString(count));

        int[][] data = new int[M][M];
        int index = 0;
        int x = M-1;
        for (int i = x; i > 0; i--) {
            data[i][0] = count[index++]+1;
        }
        for (int i = 0; i < M; i++) {
            data[0][i] = count[index++]+1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            sb.append(data[0][i]).append(" ");
        }
        sb.append("\n");
        for(int i = 1; i < M; i++){
            sb.append(data[i][0]).append(" ");
            for (int j = 1; j < M; j++) {
                data[i][j] = data[i-1][j];
                sb.append(data[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
