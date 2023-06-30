package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_20058_마법사상어와파이어스톰 {
    public static int N,Q,L,n;
    public static int[][] data;
    public static int[][] copy;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        n = 1;
        for(int i = 0; i < N; i++){
            n *= 2;
        }
        data = new int[n][n];
        copy = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < Q; i++){
            L = Integer.parseInt(st.nextToken());
            move();
        }
        makeResult();
    }

    public static void makeResult(){
        int result = 0;
        int max = 0;
        boolean[][] visited = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(data[i][j] > 0){
                    result+=data[i][j];
                    if(!visited[i][j]){
                        max = Math.max(max,bfs(i,j,visited));
                    }
                }
            }
        }
        System.out.println(result);
        System.out.println(max);
//        printData();
    }
    public static void printData(){
        System.out.println("----------------");
        for(int i = 0; i < n; i++){
            System.out.println(Arrays.toString(data[i]));
        }
        System.out.println("----------------");
    }
    public static int bfs(int x, int y,boolean[][] visited){
        int cnt = 0;
        Queue<int[]> q = new LinkedList<>();
//        boolean[][] visited =new boolean[n][n];
        visited[x][y] = true;
        q.offer(new int[]{x,y});
        while(!q.isEmpty()){
            int[] now = q.poll();
            cnt++;
            for(int d = 0; d < 4; d++){
                int nx = now[0]+dx[d];
                int ny = now[1]+dy[d];
                if(nx>=0 && nx < n && ny >=0 && ny < n && !visited[nx][ny] && data[nx][ny] != 0){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny});
                }
            }
        }

        return cnt;
    }

    public static void move(){
        int l = 1;
        for(int i = 0; i < L; i++){
            l*=2;
        }
        for(int i = 0; i < n; i += l){
            for(int j = 0; j < n; j+=l){
                rotate(i,j,l);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                data[i][j] = copy[i][j];
            }
        }
        melt();
//        printData();
    }

    public static void melt(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(data[i][j] <= 0) continue;
                int cnt = 0;
                for(int d = 0; d < 4; d++){
                    int nx = i+dx[d];
                    int ny = j+dy[d];
                    if(nx>=0 && nx < n && ny >= 0 && ny < n && data[nx][ny] != 0){
                        cnt++;
                    }
                }
                if(cnt <3){
//                    data[i][j]--;
//                    visited[i][j] = true;
//                    list.add(new int[]{i,j});
                    copy[i][j]--;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                data[i][j] = copy[i][j];
            }
        }


    }

    public static void rotate(int x, int y, int l){
        int a = l-1;
        for(int i = 0; i < l; i++){
            for(int j = 0; j < l; j++){
                int nx = j+x;
                int ny = i+y + a;
//                System.out.println("x: "+(i+x)+", y: "+(j+y) + ", nx: "+ nx +", ny: "+ny);
                copy[nx][ny] = data[i+x][j+y];
            }
            a-=2;
        }
//        System.out.println("====================");
//        for(int i = 0; i < l; i++){
//            for(int j = 0; j < l; j++){
//                data[i+x][j+y] = copy[i+x][j+y];
//            }
//        }
    }
}
