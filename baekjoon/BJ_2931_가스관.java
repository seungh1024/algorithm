package algo_202308;

import java.io.*;
import java.util.*;

public class BJ_2931_가스관 {
    public static int R,C;
    public static char[][] data;
//    public static int mx, my, zx,zy;
    public static int[] dx = {-1,0,1,0}; // 상, 우, 하, 좌
    public static int[] dy = {0,1,0,-1};
    public static char[][] pipes = {{'|','+','1','4'},{'-','+','3','4'},{'|','+','2','3'},{'-','+','1','2'}};
    public static boolean[][] visited;
    public static boolean[] direction;
    public static  int resultX,resultY;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        data = new char[R+1][C+1];
        for(int i = 1; i <= R; i++){
            char[] input = br.readLine().toCharArray();
            for(int j = 1; j <= C; j++){
                data[i][j] = input[j-1];
            }
        }

        visited = new boolean[R+1][C+1];
        direction = new boolean[4];
        resultX = 0;
        resultY = 0;
        for(int  i = 1; i <= R; i++){
            for(int j= 1; j  <= C; j++){
                if(data[i][j] == '.' && !visited[i][j]){
                    visited[i][j] = true;
                    find(i,j);
                }
            }
        }

        printResult();
    }
    public static void find(int sx, int sy){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx,sy});

        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int d = 0; d < 4; d++){
                int nx = now[0]+dx[d];
                int ny = now[1] +dy[d];

                if(nx > 0 && nx <= R && ny > 0 && ny <= C && !visited[nx][ny]){
//                    System.out.println("nx: "+nx + ", ny: "+ny);
                    for(char c : pipes[d]){
                        if(c == data[nx][ny]){
//                            System.out.println("d: "+d+", c: "+c);
//                            System.out.println("nx: "+nx +", ny: "+ny);
                            resultX = now[0];
                            resultY = now[1];
                            direction[d] = true;
//                            break;
                        }
                    }
                    if(data[nx][ny] == '.'){
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
        }
    }

    public static void printResult(){
//        System.out.println(Arrays.toString(direction));
        String result = resultX+" "+resultY+" ";
        if(direction[0] && direction[1]&&direction[2]&&direction[3]){
            result += '+';
        }else if(direction[0] && direction[2]){
            result+='|';
        }else if(direction[1]&&direction[3]){
            result+='-';
        }else if(direction[1] && direction[2]){
            result+='1';
        }else if(direction[0]&&direction[1]){
            result+='2';
        }else if(direction[0]&&direction[3]){
            result+='3';
        }else if(direction[2]&&direction[3]){
            result+='4';
        }
        System.out.println(result);
    }
}
