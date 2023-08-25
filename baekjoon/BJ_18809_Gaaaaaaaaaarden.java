package algo_202308;

import java.io.*;
import java.util.*;

public class BJ_18809_Gaaaaaaaaaarden {
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static int N,M,G,R;
    public static int[][] data;
    public static ArrayList<int[]> list; // 배양액 위치 저장
    public static int listSize;
    public static boolean[] findVisited;
    public static boolean[] baeyangVisited;
    public static int result;
    public static int[][] baeyangArea;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        data = new int[N][M];
        list = new ArrayList<>();
        listSize = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                int input = Integer.parseInt(st.nextToken());
                data[i][j] = input;
                if(input == 2){
                    listSize++;
                    list.add(new int[]{i,j});
                }
            }
        }

        result = 0;
        findVisited = new boolean[listSize];
        baeyangArea = new int[G+R][2];
        find(0,0);
        System.out.println(result);
    }
    public static void find(int idx, int cnt){ // list중 G+R개 찾기
        if(cnt == G+R){ // G+R개 중 G개 찾아서 거기에 G배양액 넣고 나머지에 R넣음
            int selectIdx = 0;
            for(int i = 0; i < listSize; i++){
                if(findVisited[i]){
                    int[] now = list.get(i);
                    baeyangArea[selectIdx][0] = now[0];
                    baeyangArea[selectIdx][1] = now[1];
                    selectIdx++;
                }
            }
            baeyangVisited = new boolean[G+R];
            baeyang(0,0,G+R);
            return;
        }
        if(idx >= listSize) return;

        if(!findVisited[idx]){
            findVisited[idx] = true;
            find(idx+1,cnt+1);// 선택한 경우
            findVisited[idx] = false;
            find(idx+1,cnt); // 선택 안한 경우
        }
    }

    public static void baeyang(int idx, int cnt, int size){
        if(cnt == G){
            int value = makeFlower(size);
            result = Math.max(result,value);
//            System.out.println("baeyangVisited: "+Arrays.toString(baeyangVisited));
            return;
        }
        if(idx >= size) return;

        if(!baeyangVisited[idx]){
            baeyangVisited[idx] = true;
            baeyang(idx+1,cnt+1,size); // G 선택한 경우
            baeyangVisited[idx] = false;
            baeyang(idx+1,cnt,size); // G 선택 안한경우
        }
    }
    public static int makeFlower(int baeyangSize){
        int[][] copyData = deepCopy();
        Queue<Point> q = new LinkedList<>();
        for(int i = 0; i < baeyangSize; i++){
            int x = baeyangArea[i][0];
            int y = baeyangArea[i][1];
            if(baeyangVisited[i]){ // G 배양
                q.offer(new Point(x,y,-1));
                copyData[x][y] = 0;
            }else{ // R 배양
                q.offer(new Point(x,y,-2));
                copyData[x][y] = 0;
            }
        }

        int count = 0;

        while(!q.isEmpty()){
            ArrayList<Point> changeList = new ArrayList<>(); // 배양 퍼진 후 못가게 만들거임
            int size = q.size();
            for(int s = 0; s < size; s++){
                Point now = q.poll();
                for(int d = 0; d < 4; d++){
                    int nx = now.x+dx[d];
                    int ny = now.y+dy[d];
                    if(nx >=0 && nx < N && ny >= 0 && ny < M && copyData[nx][ny] != 0){
                        if(copyData[nx][ny]  > 0){ // 번식
                            copyData[nx][ny] = now.rg;
                            Point p = new Point(nx,ny,now.rg);
                            changeList.add(p);
                        }else if(copyData[nx][ny] + now.rg == -3){ // 더해서 -3이면 꽃을 피움
                            copyData[nx][ny] =-3; // 번식 못하게 0으로
                            changeList.add(new Point(nx,ny,-3));
                            count++;
                        }
                    }
                }
            }

            for(Point p : changeList){ //한 사이클 퍼트리면 거기는 침범 못하게 0으로 변환
                int x = p.x;
                int y = p.y;
                if(copyData[x][y] == -3){
                    copyData[x][y] = 0;
                }else if(copyData[x][y] == -1 || copyData[x][y] == -2){
                    q.offer(new Point(x,y,copyData[x][y]));
                    copyData[x][y] = 0;
                }
            }
        }
        return count;
    }

    public static int[][] deepCopy(){
        int[][] copy = new int[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                copy[i][j] = data[i][j];
            }
        }
        return copy;
    }

    public static class Point{
        int x,y, rg;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, int rg){
            this.x = x;
            this.y = y;
            this.rg = rg;
        }
    }
}
