package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_20055_컨베이어벨트위의로봇 {
    public static int N,K;
    public static int[][] data;
    public static boolean[] robot;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        data = new int[2][N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            data[0][i] = Integer.parseInt(st.nextToken());
        }
        for(int i = N-1; i >= 0; i--){
            data[1][i] = Integer.parseInt(st.nextToken());
        }
//        printData();
        robot = new boolean[N];
        move();

    }
    public static void move(){
        int result = 0;
        while(true){
            result++;
            rotation(); // 1. 회전
            moveRobot();
            putRobot();
//            printData();
            if(countZero() >= K){
                break;
            }
        }
        System.out.println(result);
    }
    public static int countZero(){
        int cnt = 0;
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < N; j++){
                if(data[i][j] == 0){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static void putRobot(){
        if(data[0][0] > 0){
            robot[0] = true;
            data[0][0]--;
        }
    }
    public static void moveRobot(){
        int length = N-1;
        for(int i = length-1; i >= 0; i--){
            if(robot[i] && !robot[i+1] && data[0][i+1] > 0){
                robot[i] = false;
                robot[i+1] = true;
                data[0][i+1]--;
            }
        }
        if(robot[length]){
            robot[length] = false;
        }
    }
    public static void rotation(){
        int length = N-1;
        int left = data[1][0];
        int right = data[0][length];
        for(int i = length; i > 0; i--){
            data[0][i] = data[0][i-1];
            robot[i] = robot[i-1];
        }
        data[0][0] = left;
        robot[0] = false;
        if(robot[length]) robot[length] = false;
        for(int i = 0; i <length; i++){
            data[1][i] = data[1][i+1];
        }
        data[1][length] = right;
    }
    public static void printData(){
        for(int i = 0; i < 2; i++){
            System.out.println(Arrays.toString(data[i]));
        }
        System.out.println(Arrays.toString(robot));
        System.out.println("/////////////////");
    }
}
