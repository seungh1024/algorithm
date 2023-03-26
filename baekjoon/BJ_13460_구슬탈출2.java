import java.io.*;
import java.util.*;

public class BJ_13460_구슬탈출2 {
    public static int N,M;
    public static char[][] data;
    public static boolean blueIn, redIn, redFirst,blueFirst;
    public static int startRx, startRy, startBx, startBy;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data = new char[N][M];
        for(int i = 0; i < N; i++){
            char[] input = br.readLine().toCharArray();
            for(int j = 0;j < M; j++){
                data[i][j] = input[j];
                if(input[j] == 'R'){
                    startRx = i;
                    startRy = j;
                    data[i][j] = '.';
                }
                else if(input[j] == 'B'){
                    startBx = i;
                    startBy = j;
                    data[i][j] = '.';
                }
            }
//            System.out.println(Arrays.toString(data[i]));
        }

        find();
    }
    public static void find(){
        Queue<Ball> q = new LinkedList<>();
        q.offer(new Ball(startRx,startRy,startBx,startBy));
        int t =1;
        while(t <= 10){
            int size = q.size();
//            System.out.println(size + ", t: "+t );
            for(int s = 0; s < size; s++){
                Ball now = q.poll();
                for(int d = 0; d <4; d++){
                    int[] nextR = move(now.rx,now.ry,now.bx,now.by,d,true);
                    int[] nextB = move(now.bx,now.by,now.rx,now.ry,d,false);
                    if(blueIn){
//                        System.out.println("blue In");
                        redIn = false;
                        blueIn = false;
                        continue;
                    }else if(redIn){
//                        System.out.println("red In");
                        System.out.println(t);
                        return;
                    }

                    if(nextR[0] == nextB[0] && nextR[1] == nextB[1]){
//                        System.out.println("same " + redFirst + ", "+blueFirst);
                        if(redFirst){
                            nextB[0] -= dx[d];
                            nextB[1] -= dy[d];
//                            System.out.println("move B: "+nextB[0] + " , " +nextB[1]);
                        }else if(blueFirst){
                            nextR[0] -= dx[d];
                            nextR[1] -= dy[d];
                        }
                    }
                    redFirst = false;
                    blueFirst = false;
                    if(now.rx == nextR[0] && now.ry ==nextR[1] && now.bx == nextB[0] && now.by == nextB[1]) continue;
                    q.offer(new Ball(nextR[0],nextR[1],nextB[0],nextB[1]));
                }
            }
            t++;
        }
        System.out.println(-1);
    }

    // check -> true = red, false = blue
    public static int[] move(int x, int y,int tx, int ty, int d, boolean check){
        while(true){
            x+=dx[d];
            y+=dy[d];
//            System.out.println("x: "+x + ", y: "+y);
            if(data[x][y] == '#'){
//                System.out.println("out");
                x-=dx[d];
                y-=dy[d];
                return new int[]{x,y};
            }
            else if(data[x][y] == 'O'){
//                System.out.println("goal");
                if(check) redIn = true;
                else blueIn = true;
                return null;
            }
            else if(x == tx && y == ty){
                if(check) blueFirst = true;
                else redFirst = true;
            }
        }
    }


    public static class Ball{
        int rx,ry,bx,by;
        public Ball(int rx, int ry, int bx, int by){
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
        }
    }
}
