package algo_202307;

import java.io.*;
import java.util.*;

public class BJ_13459_구슬탈출 {
    public static int N,M;
    public static char[][] data;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static Goal goal;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data = new char[N][M];
        Point start = new Point();
        for(int i = 0; i < N; i++){
            char[] input = br.readLine().toCharArray();
            for(int j = 0; j < M; j++){
                if(input[j] == 'B'){
                    data[i][j] = '.';
                    start.bx = i;
                    start.by = j;
                } else if(input[j] == 'R'){
                    data[i][j] = '.';
                    start.rx = i;
                    start.ry = j;
                }else if(input[j] == 'O'){
                    goal = new Goal(i,j);
                    data[i][j] = input[j];
                }else{
                    data[i][j] = input[j];
                }
            }
        }
        move(start);
    }
    public static void move(Point start){
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        int result = 0;
        boolean[][][][] visited = new boolean[N][M][N][M];
        visited[start.rx][start.ry][start.bx][start.by] = true;
        for(int i = 0; i < 10; i++){
            int size = q.size();
            for(int j = 0; j < size; j++){
                Point now = q.poll();
                int rx = now.rx;
                int ry = now.ry;
                int bx = now.bx;
                int by = now.by;
                for(int d = 0; d <4; d++){
                    int nrx = rx;
                    int nry = ry;
                    int nbx = bx;
                    int nby = by;
                    boolean bbreak = false;
                    boolean rbreak = false;
                    boolean bcheck = false;
                    boolean rcheck = false;
                    int idx = 0;
                    while(true){
                        int nx = nrx+dx[d];
                        int ny = nry+dy[d];
//                        System.out.println("d: "+d);
//                        System.out.println("nrx: "+nrx + ", nry: "+nry);
                        if(!(nx == nbx && ny == nby) && data[nx][ny] == '.'){
                            nrx = nx;
                            nry = ny;
                        }else if(data[nx][ny] == 'O'){
//                            nrx = 0;
//                            nry = 0;
//                            System.out.println("?");
                            rbreak = true;
                        }
                        if((nx == nbx && ny==nby) || data[nx][ny] == '#'){
                            rcheck = true;
                        }else{
                            rcheck = false;
                        }

                        nx = nbx+dx[d];
                        ny = nby+dy[d];
//                            System.out.println("nbx: "+nx + ", nby: "+ ny);
                        if(!(nx == nrx && ny == nry) && data[nx][ny] == '.'){
                            nbx = nx;
                            nby = ny;
                        }else if(data[nx][ny] == 'O'){
//                            nbx = 0;
//                            nby = 0;
                            bbreak = true;
                        }
                        if((nx == nrx && ny == nry) || data[nx][ny] =='#'){
                            bcheck = true;
                        }else{
                            bcheck = false;
                        }

                        if(rbreak && !bbreak){
                            while(true){
                                if(data[nbx][nby] == 'O'){
//                                    System.out.println(0);
                                    break;
                                }else if(data[nbx][nby] == '#'){
                                    System.out.println(1);
                                    return;
                                }
                                nbx += dx[d];
                                nby += dy[d];
                            }
                            break;
                        }else if(bbreak){
//                            System.out.println(0);
                            break;
                        }

                        if(bcheck && rcheck){ //둘 다 못움직이면
                            break;
                        }
                    }
                    if(!visited[nrx][nry][nbx][nby] && !rbreak && !bbreak){
//                        System.out.println("Queue : "+ nrx + ", nry: "+nry + ", nbx: "+nbx + ", nby: "+nby);
                        q.offer(new Point(nrx,nry,nbx,nby));
                        visited[nrx][nry][nbx][nby] = true;
                    }
                }
//                System.out.println("========");
            }
        }
        System.out.println(result);
    }

    public static class Point{
        int rx,ry,bx,by;
        public Point(){};
        public Point(int rx, int ry, int bx, int by){
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
        }
        public String toString(){
            return "rx: "+this.rx +  ", ry: "+this.ry + ", bx: "+bx + ", by: "+by;
        }

    }
    public static class Goal{
        int x,y;
        public Goal(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}
//#######
//#...O.#
//#.....#
//#.....#
//#.B...#
//#..R..#
//#######
//6 7
//#######
//#R....#
//#.###.#
//#....##
//#..#BO#
//#######