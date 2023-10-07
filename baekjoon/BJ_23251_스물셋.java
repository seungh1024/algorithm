package algo_202310;

import java.io.*;
import java.util.*;

public class BJ_23251_스물셋 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine());
            sb.append(k * 23).append("\n");
        }
        System.out.println(sb);
    }
}