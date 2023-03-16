import java.io.*;
import java.util.*;

public class BJ_7569_토마토 {
    public static int N,M,H;
    public static int[][][] box;
    public static int total;
    public static int[] dh = { 0,0,0,0,1,-1};
    public static int[] dx = {0,0,1,-1,0,0};
    public static int[] dy = {1,-1,0,0,0,0};
    public static Queue<Tomato> queue;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int[H][N][M];
        queue = new LinkedList<>();

        for(int i = 0; i < H; i++){
            for(int j = 0; j < N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < M; k++){
                    int a = Integer.parseInt(st.nextToken());
                    box[i][j][k] = a;
                    if(a == 0) total++;
                    else if(a == 1){
                        queue.offer(new Tomato(i,j,k));
                    }
                }
            }
        }

        if(total == 0){
            System.out.println(0);
        }else{
            find();
        }
    }

    public static void find(){
        int result = 0;
        int size;
        int nh,nx,ny;

        while(!queue.isEmpty()){
            size = queue.size();
            int cnt = 0;
            for(int s = 0; s < size; s++){
                Tomato now = queue.poll();
                for(int i = 0; i < 6; i++){
                    nh = now.h+dh[i];
                    nx = now.x + dx[i];
                    ny = now.y +dy[i];
                    if(nh >= 0 && nh < H && nx >=0 && nx < N && ny >=0 && ny <M && box[nh][nx][ny] == 0){
                        box[nh][nx][ny] = 1;
                        queue.offer(new Tomato(nh,nx,ny));
                        total --;
                        cnt ++;
                    }
                }
            }
            result ++;
//            System.out.println(cnt + ", "+ result);
        }

        if(total > 0){
            System.out.println(-1);
        }else{
            System.out.println(result-1);
        }
    }

    public static class Tomato{
        int h,x,y;

        public Tomato(int h, int x, int y){
            this.h = h;
            this.x = x;
            this.y = y;
        }
    }
}
