package algo_202312.re;

import java.io.*;
import java.util.*;

public class REBJ_1339_단어수학 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] count = new int[26];
        int N = Integer.parseInt(br.readLine());
        String[] input = new String[N];
        for (int i = 0; i < N; i++) {
            input[i] = br.readLine();
            char[] array = input[i].toCharArray();
            int length = array.length;
            int mul = 1;
            for (int j = 1; j < length; j++) {
                mul *= 10;
            }
            for (char c : array) {
                count[c-'A'] += mul;
                mul /= 10;
            }
        }

        Queue<int[]> pq = new PriorityQueue<>((o1,o2)->{
            return o2[1] - o1[1];
        });
        int[] value = new int[26];
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                pq.offer(new int[]{i,count[i]});
            }
        }
        int num = 9;
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int index = now[0];
            value[index] = num;
            if (num > 0) {
                num--;
            }
        }

        int result = 0;
        for (String s : input) {
            char[] array = s.toCharArray();
            int length = array.length;
            int mul = 1;
            for (int j = 1; j < length; j++) {
                mul*=10;
            }
            for (char c : array) {
                result += value[c-'A']*mul;
                mul/=10;
            }
        }
        System.out.println(result);

    }
}
