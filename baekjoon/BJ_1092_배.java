package algo_202312;

import java.io.*;
import java.util.*;

public class BJ_1092_배 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] crane = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            crane[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        int[] box = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(crane);
        Arrays.sort(box);
        if (box[M - 1] > crane[N - 1]) {
            System.out.println(-1);
            return;
        }

        boolean[] visited = new boolean[M];

        int time = 0;
        int index = N-1;
        int count = 0;

        while (count < M) {
            for (int i = M - 1; i >= 0; i--) {
                if (!visited[i] && box[i] <= crane[index]) {
                    visited[i] = true;
                    index--;
                    count++;
                }
                if(index < 0) break;
            }
            time++;
            index = N-1;
//            System.out.println(Arrays.toString(visited));
        }

//        System.out.println(Arrays.toString(crane));
//        System.out.println(Arrays.toString(box));
        System.out.println(time);
    }
}
