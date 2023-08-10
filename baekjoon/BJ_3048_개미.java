package algo_202308;

import java.io.*;
import java.util.*;

public class BJ_3048_개미 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N1 = Integer.parseInt(st.nextToken());
        int N2 = Integer.parseInt(st.nextToken());

        char[] input1 = br.readLine().toCharArray();
        char[] input2 = br.readLine().toCharArray();

        int length1 = input1.length;
        int length2 = input2.length;
        int[] check1 = new int[length1];
        int[] check2 = new int[length2];
        Arrays.fill(check1,1);
        Arrays.fill(check2,2);

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t <T; t++){
            if(check1[0] ==1 && check2[0]== 2){
                int tmp = check1[0];
                check1[0] = check2[0];
                check2[0] = tmp;

                char c = input1[0];
                input1[0] = input2[0];
                input2[0] = c;

                lineChange(length1,1,input1,check1, 1);
                lineChange(length2,1,input2,check2, 2);
            }else{
                lineChange(length1,0,input1,check1, 1);
                lineChange(length2,0,input2,check2, 2);
            }
//            System.out.println("check1: "+Arrays.toString(check1));
//            System.out.println("check2: "+Arrays.toString(check2));
        }
        StringBuilder sb = new StringBuilder();
        for(int i = length1-1; i >= 0; i--){
            sb.append(input1[i]);
        }
        for(int i = 0; i < length2; i++){
            sb.append(input2[i]);
        }
        System.out.println(sb);
    }

    public static void lineChange(int start, int end, char[] input, int[] check, int num){
        for(int i = start-1; i > end; i--){
           if(check[i] == num && check[i-1] != num){
               int tmp = check[i];
               check[i] = check[i-1];
               check[i-1] = tmp;

               char c = input[i];
               input[i] = input[i-1];
               input[i-1] = c;
               i--;
           }
        }
//        for(int index : moveList){
//            int tmp = check[index];
//            check[index] = check[index+1];
//            check[index+1] = tmp;
//
//            char c = input[index];
//            input[index] = input[index+1];
//            input[index+1] = c;
//        }
    }
}
