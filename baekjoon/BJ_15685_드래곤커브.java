package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_15685_드래곤커브 {
    public static int N;
    public static boolean[][] visited;
    public static int[] dx = {0,-1,0,1};
    public static int[] dy = {1,0,-1,0};
    public static ArrayList<Integer> move;
    public static int size;
    public static int x,y,d,g;
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[101][101];
        for(int n = 0; n < N; n++){
            move = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            visited[x][y] = true;
            x += dx[d];
            y += dy[d];
            visited[x][y] = true;
            move.add(d);
            size = 0;
            for(int i = 0; i < g; i++){
                dragonCurve();
            }
        }
        printResult();
    }
    public static void printResult(){
        int[] cx = {0,0,1,1};
        int[] cy = {0,1,0,1};
        int result = 0;
        for(int i = 0; i < 100; i++){
            for(int j = 0; j  < 100; j++){
                int check = 0;
                for(int d = 0; d < 4; d++){
                    if(!visited[i+cx[d]][j+cy[d]]){
                        break;
                    }else{
                        check++;
                    }
                }
                if(check == 4){
                    result++;
                }
            }
        }
        System.out.println(result);
    }


    public static void dragonCurve(){
        for(int i = size; i >= 0; i--){
            int now = move.get(i);
            now = (now+1)%4;
            x+=dx[now];
            y +=dy[now];
            visited[x][y] = true;
            move.add(now);
            size++;
        }
    }
}
