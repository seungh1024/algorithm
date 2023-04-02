package before230401;

import java.io.*;
import java.util.*;

public class BJ_9251_LCS {
    public static char[] input1;
    public static char[] input2;
    public static int length1,length2;
    public static int[] count;

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        length1 = s.length();
        input1 = s.toCharArray();
        s = br.readLine();
        length2 = s.length();
        input2 = s.toCharArray();

        count = new int[length1];

        for(int i= 0; i < length2; i++){
            char c = input2[i];
            int cnt = 0;
            for(int j = 0; j < length1; j++){
                if(cnt < count[j]){
                    cnt = count[j];
                }else if(c == input1[j]){
                    count[j] = cnt+1;
                }
            }
        }
        int result = 0;
        for(int i = 0; i < length1; i++){
            result = Math.max(result,count[i]);
        }
        System.out.println(result);
    }
}
