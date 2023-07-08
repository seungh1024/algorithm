package algo_202307;

import java.io.*;
import java.util.*;

public class BJ_2174_로봇시뮬레이션 {
    public static int A,B, N,M;
    public static int[] dx = {0,-1,0,1};
    public static int[] dy = {1,0,-1,0};
    public static ArrayList<Robot> robots;
    public static boolean[][] check;
    public static int[][] number;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        check = new boolean[B+1][A+1];
        number = new int[B+1][A+1];
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        robots = new ArrayList<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int x= Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            int d = 0;
            if(s.equals("S")){
                d = 1;
            }else if(s.equals("W")){
                d = 2;
            }else if(s.equals("N")){
                d = 3;
            }
            robots.add(new Robot(y,x,d));
            check[y][x] = true;
            number[y][x] = i+1;
        }
//        printData();
        for(int i = 0; i < M; i++){
            st= new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            int t = Integer.parseInt(st.nextToken());
            if(move(r,s,t)){
                return;
            }
        }
        System.out.println("OK");
//        printData();
    }
    public static void printData(){
        System.out.println("//////////////");
        for(int i = 0; i <= B; i++){
            System.out.println(Arrays.toString(number[i]));
        }
        System.out.println("=============");
        for(int i = 0; i <= B; i++){
            System.out.println(Arrays.toString(check[i]));
        }
        System.out.println("/////////////");
    }
    public static boolean move(int r, String s, int t){
        Robot robot = robots.get(r-1);
        if(s.equals("L")){
            robot.d = (robot.d + (4-(t%4)))%4;
//            System.out.println("L");
//            System.out.println(robot.d);
        }else if(s.equals("R")){
            robot.d = (robot.d + t)%4;
//            System.out.println("R");
//            System.out.println(robot.d);
        }else if(s.equals("F")){
            for(int i = 0; i < t; i++){
                int x = robot.x +dx[robot.d];
                int y = robot.y +dy[robot.d];
                if(x <=0 || x > B || y <= 0 || y > A){
                    System.out.println("Robot " + r + " crashes into the wall");
                    return true;
                }
//                System.out.println("x: "+x+", y: "+y);
                if(check[x][y]){
                    System.out.println("Robot "+r+" crashes into robot " +number[x][y]);
                    return true;
                }
                check[robot.x][robot.y] = false;
                check[x][y] = true;
                number[x][y] = number[robot.x][robot.y];
                number[robot.x][robot.y] = 0;
                robot.x = x;
                robot.y = y;
            }
        }
        return false;
    }

    public static class Robot{
        int x,y,d;
        public Robot(int x, int y,int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
