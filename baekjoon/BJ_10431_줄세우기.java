package algo_202308;

import java.io.*;
import java.util.*;

public class BJ_10431_줄세우기 {
    public static int[] students;
    public static int result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int p = 0; p <P; p++){
            students = new int[20];
            result = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
//            System.out.println("============="+ T + "==============");
            for(int t = 0; t < 20 ; t++){
                int height = Integer.parseInt(st.nextToken());
                move(t,height);
//                System.out.println(Arrays.toString(students));
            }
            sb.append(T).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
    public static void move(int t, int height){
//        System.out.println("t: "+t + ", height: "+height);
        for(int i = 0; i <= t; i++){
            if(students[i] != 0){
                if(students[i] > height){
                    for(int j = t; j > i; j--){
                        students[j] = students[j-1];
                    }
                    students[i] = height;
                    result += (t-i);
//                    result++;
                    break;
                }
            }else if (students[i] == 0){
                students[i] = height;
//                System.out.println("height: "+height);
//                result += (t-i);
                break;
            }
        }
    }
}
