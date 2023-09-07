package algo_202309;

import java.io.*;
import java.util.*;

public class BJ_17142_연구소3 {
    public static int N,M;
    public static int[][] data;
    public static ArrayList<Virus> virus;
    public static int size;
    public static boolean[] visited;
    public static int totalCount;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static int result;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data = new int[N][N];
        virus = new ArrayList<>();
        size = 0;
        totalCount = 0;
        for(int i = 0; i < N; i++){
            st= new StringTokenizer(br.readLine());
            for(int j = 0;j < N; j++){
                data[i][j] = Integer.parseInt(st.nextToken());
                if(data[i][j] == 2){
                    virus.add(new Virus(i,j));
                    size++;
                }
                if(data[i][j] == 0){
                    totalCount++;
                }
            }
        }
//        System.out.println(size);
//        System.out.println("total count: "+totalCount);
        result = N*N;
        visited = new boolean[size];
        find(0,0);
        if(result == N*N){
            System.out.println(-1);
        }else{
            System.out.println(result);
        }
    }
    public static void find(int idx, int cnt){
        if(cnt == M){
            spread();
            return;
        }
        for(int i = idx; i <size; i++){
            visited[i] = true;
            find(i+1,cnt+1);
            visited[i] = false;
        }
//        if(idx >= size) return;
//        visited[idx] = true;
//        find(idx+1,cnt+1);
//        visited[idx] = false;
//        find(idx+1,cnt);
    }
    public static void spread(){
        int[][] copy = copyData();
        Queue<Virus> q = new LinkedList<>();
        for(int i = 0; i < size; i++){
            if(visited[i]){
                Virus choose = virus.get(i);
                q.offer(new Virus(choose.x,choose.y));
                copy[choose.x][choose.y] = 3;
//                System.out.println("x: " +choose.x+", y: "+choose.y);
            }
        }
//        System.out.println("choose================");
        int localCount = 0;
        int time = 0;
        while(!q.isEmpty()){
//            System.out.println(localCount);
            if(localCount == totalCount){
//                System.out.println("localCount : "+localCount + ", time : "+time);
//                for(int i = 0; i < N; i++){
//                    System.out.println(Arrays.toString(copy[i]));
//                }
                result = Math.min(result,time);
                break;
            }
            int size = q.size();
            time++;
            for(int s = 0; s < size; s++){
                Virus now = q.poll();
                for(int d = 0; d < 4; d++){
                    int nx = now.x+dx[d];
                    int ny = now.y+dy[d];
                    if(nx>=0 && nx < N && ny >= 0 && ny < N){
                        if(copy[nx][ny] == 0){
                            copy[nx][ny] = 3;
                            q.offer(new Virus(nx,ny));
                            localCount++;
                        }else if(copy[nx][ny] == 2){
                            copy[nx][ny] = 3;
                            q.offer(new Virus(nx,ny));
                        }
                    }
                }
            }
        }

    }
    public static int[][] copyData(){
        int[][] copy = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                copy[i][j] = data[i][j];
            }
        }
        return copy;
    }
    public static class Virus{
        int x,y;
        public Virus(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
