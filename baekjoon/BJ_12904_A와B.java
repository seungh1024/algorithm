package algo_202312;

import java.io.*;
import java.util.*;

public class BJ_12904_A와B {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        char[] T = br.readLine().toCharArray();
        int left = 0, right = T.length-1;
        boolean check = true;
        int sl = S.length()-1;

        while (sl < right - left) {
            if (check) { // 오른쪽에서 다가옴
                if (T[right] == 'A') {
                    right--;
                }
                else if (T[right] == 'B') {
                    right --;
                    check = false;
                }
            } else { // 왼쪽에서 다가옴
                if (T[left] == 'A') {
                    left++;
                }
                else if (T[left] == 'B') {
                    left ++;
                    check = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if (check) {
            for (int i = left; i <= right; i++) {
                sb.append(T[i]);
            }
        } else {
            for (int i = right; i >= left; i--) {
                sb.append(T[i]);
            }
        }
        int result = 0;
        if (S.equals(sb.toString())) {
            result = 1;
        }
        System.out.println(result);
    }
}
