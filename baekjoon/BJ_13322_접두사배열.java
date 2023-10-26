package algo_202310;

import java.io.*;
import java.util.*;

public class BJ_13322_접두사배열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int size = input.length();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++){
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}
