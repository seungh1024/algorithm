import java.io.*;
import java.util.*;

public class BJ_3055_탈출 {
    public static int N,M;
    public static char[][] data;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static int[] D;
    public static int[] S;
    public static Queue<int[]> water;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data = new char[N][M];
        water = new LinkedList<>();

        for(int i = 0; i < N; i++){
            data[i] = br.readLine().toCharArray();
            for(int j = 0; j < M; j++){
                if(data[i][j] == '*'){
                    water.offer(new int[]{i,j});
                }
                else if(data[i][j] == 'D'){
                    D = new int[]{i, j};
                }
                else if(data[i][j] == 'S'){
                    S = new int[]{i,j};
                }
            }
        }

        bfs();
    }

    public static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{S[0],S[1]});
        int nx,ny,size;
        int result = 0;

        while(!queue.isEmpty()){

            int[] flood;
            if(!water.isEmpty()){
                size = water.size();
                for(int i = 0; i < size; i++){
                    flood = water.poll();
                    for(int d = 0; d < 4; d++){
                        nx = flood[0] + dx[d];
                        ny = flood[1] + dy[d];
                        if(nx >= 0 && nx < N && ny >= 0 && ny < M && (data[nx][ny] == '.' || data[nx][ny] == 'S')){
                            data[nx][ny] = '*';
                            water.offer(new int[]{nx,ny});
//                            System.out.println("Water : "+nx + ", "+ ny + " data now : "+data[nx][ny]);
//                            printD();
                        }
                    }
                }
            }

            result ++;
            size = queue.size();
            for(int i = 0; i <size; i++){
                int[] now = queue.poll();
                for(int d = 0; d < 4; d++){
                    nx = now[0] +dx[d];
                    ny = now[1] + dy[d];
                    if(nx>=0 && nx < N && ny >=0 && ny < M){
                        if(data[nx][ny] == '.'){
                            queue.offer(new int[]{nx,ny});
                            data[nx][ny] = 'S';
//                            System.out.println("S : "+nx + ", "+ ny);
//                            printD();
                        }
                        else if(data[nx][ny] == 'D'){
                            System.out.println(result);
                            return;
                        }
                    }
                }
            }


        }
        System.out.println("KAKTUS");
    }

    public static void printD(){
        for(int i = 0; i <N; i++){
            System.out.println(Arrays.toString(data[i]));
        }
    }
}
