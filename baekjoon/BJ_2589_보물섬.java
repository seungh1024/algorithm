package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_2589_보물섬 {
    public static int N,M,result;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static char[][] data;
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data = new char[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++){
            char[] input = br.readLine().toCharArray();
            for(int j = 0; j < M; j++){
                data[i][j] = input[j];
                if(input[j] == 'W'){
                    visited[i][j] = true;
                }
            }
        }

        result = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j]){
                    find(i,j);
                    visited[i][j] = true;
                }
            }
        }

        System.out.println(result);


    }
    public static void find(int a, int b){
        int cnt = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {a,b});
        boolean[][] check = new boolean[N][M];
        check[a][b] = true;
        int x,y,nx,ny;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0; s < size; s++){
                int[] now = q.poll();
                x = now[0];
                y = now[1];
//                System.out.println("x: "+x + " ,y: "+y +" ,cnt: "+cnt);
                for(int d = 0; d <4; d++){
                    nx = x+dx[d];
                    ny = y+dy[d];
                    if(nx >= 0 && nx < N && ny >= 0 && ny < M && !check[nx][ny] && data[nx][ny] == 'L'){
                        q.offer(new int[] {nx,ny});
                        check[nx][ny] = true;
                    }
                }
            }
//            System.out.println(cnt);
            cnt ++;

        }

        result = Math.max(result,cnt-1);
    }
}
//5 7
//WLLWWWW
//LLLWWWW
//LWLWLWW
//LWLLLLL
//WWLWLWW

//5 7
//WWWWWWW
//WWWWWWW
//WWWLWWW
//WWWWWWW
//WWWWWWW