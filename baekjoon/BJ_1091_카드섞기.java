package algo_202312;

import java.io.*;
import java.util.*;

public class BJ_1091_카드섞기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] S = new int[N];
        int[] P = new int[N];
        int[] origin = new int[N];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int c = 0;
        int[] card = new int[N];
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st1.nextToken());
            S[i] = Integer.parseInt(st2.nextToken());
            origin[i] = P[i];
            card[i] = c;
            c = (c+1)%3;
        }

        int count = 0;
        int[] temp = new int[N];
        int range = 0;
        while (true) {
            if(Arrays.equals(P,card)) break;
            else if (count > 0 && Arrays.equals(origin, P)) {
                count = -1;
                break;
            }
            count++;
            for (int i = 0; i < N; i++) {
                temp[S[i]] = P[i];
            }
            for (int i = 0; i < N; i++) {
                P[i] = temp[i];
            }
//            System.out.println(Arrays.toString(P));
        }

        System.out.println(count);

    }
}
//[1, 1, 2, 0, 2, 0, 1, 0, 2, 2, 1, 0]