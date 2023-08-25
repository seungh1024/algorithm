package algo_202308;

import java.io.*;
import java.util.*;

public class BJ_15653_구슬탈출4 {
    public static int N,M;
    public static char[][] data;
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1}; // 상 우 하 좌
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data = new char[N][M];
        Ball ball = new Ball();
        for(int i = 0; i < N; i++){
            char[] input = br.readLine().toCharArray();
            for(int j = 0; j < M; j++){
                if(input[j] == 'R'){
                    ball.rx = i;
                    ball.ry = j;
                    data[i][j] = '.';
                }else if(input[j] == 'B'){
                    ball.bx = i;
                    ball.by = j;
                    data[i][j] = ',';
                }else{
                    data[i][j] = input[j];
                }
            }
        }
        findHole(ball);

    }
    public static void findHole(Ball ball){
        Queue<Ball> q = new LinkedList<>();
        HashMap<Integer,Integer> visited = new HashMap<>();
        q.offer(ball);
        visited.put(ball.rx*1000+ball.ry*100+ball.bx*10+ball.by,0);
        int result = 0;
        while(!q.isEmpty()){
            int qSize = q.size();
            result++;
            for(int s = 0; s <qSize; s++){
                Ball now = q.poll();
//                System.out.println(now);
                for(int d = 0; d < 4; d++){
                    int rx = now.rx;
                    int ry = now.ry;
                    int bx = now.bx;
                    int by = now.by;
                    boolean[] holeCheck = new boolean[2];
                    int[] red = moveBall(rx,ry,d,holeCheck,0);
                    int[] blue = moveBall(bx,by,d,holeCheck,1);

                    if(holeCheck[1]){
                        continue;
                    }else if(holeCheck[0] && !holeCheck[1]){
                        System.out.println(result);
                        return;
                    }

//                    System.out.println("red: "+Arrays.toString(red));
//                    System.out.println("blue: "+Arrays.toString(blue));
                    if(red[0] == blue[0] && red[1] == blue[1]){
                        int redSum = now.rx+now.ry;
                        int blueSum = now.bx+now.by;
                        if(d==0 || d == 3){
                            if(blueSum > redSum){
                                blue[0]-=dx[d];
                                blue[1]-=dy[d];
                            }else{
//                                System.out.println("?");
                                red[0]-=dx[d];
                                red[1]-=dy[d];
                            }
                        }else if(d == 1 || d == 2){
                            if(blueSum < redSum){
                                blue[0]-=dx[d];
                                blue[1]-=dy[d];
                            }else{
                                red[0]-=dx[d];
                                red[1]-=dy[d];
                            }
                        }
                    }
                    int visitNum = red[0]*1000+red[1]*100+blue[0]*10+blue[1];
                    if(visited.get(visitNum) == null){
                        visited.put(visitNum,0);
                        q.offer(new Ball(red[0],red[1],blue[0],blue[1]));
                    }
                }

            }
        }
        System.out.println(-1);

    }
    public static int[] moveBall(int x, int y, int d, boolean[] holeCheck, int index){
        while(true){
            x += dx[d];
            y += dy[d];
            if(x> 0 && x < N-1 && y > 0 && y < M-1 && data[x][y] != '#'){
                if(data[x][y] == 'O'){
                    holeCheck[index] = true;
                    break;
                }
            }else{
                x -= dx[d];
                y -= dy[d];
                break;
            }
        }
        return new int[]{x,y};
    }

    public static class Ball{
        int rx,ry,bx,by;
        public Ball(){}
        public Ball(int rx, int ry, int bx, int by){
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
        }

        @Override
        public String toString(){
            return "rx: "+rx +", ry: "+ry +", bx: "+bx + ", by: "+by;
        }
    }
}
