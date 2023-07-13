package algo_202307;

import java.io.*;
import java.util.*;

public class BJ_2933_미네랄 {
    public static int R,C,N;
    public static char[][] data;
    public static int[] spear = {1,-1};
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static Queue<int[]> q;
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        data = new char[R][C];
        for(int i = 0; i < R; i++){
            char[] input = br.readLine().toCharArray();
            for(int j = 0 ; j < C; j++){
                data[i][j] = input[j];
            }
        }
        N = Integer.parseInt(br.readLine());

        q = new LinkedList<>();
        int check = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            int x = R-num;
            int y =shot(x,check);
            if(y != -1){
                find(x,y);
            }
            check = (check+1)%2;
//            printData();
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                sb.append(data[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);

    }

    public static void find(int x, int y){
        for(int d = 0; d < 4; d++){
            int nx = x+dx[d];
            int ny = y+dy[d];
            if(nx >= 0 && nx <R && ny >= 0 && ny < C && data[nx][ny] == 'x'){ // 부순거 주변에 연결된 것이 있다면
//                System.out.println("!!");
                makeBlock(nx,ny);
            }
        }
    }
    public static void makeBlock(int x, int y){
//        System.out.println("x: "+x + ", y: "+y);
        visited = new boolean[R][C];
        visited[x][y] = true;
        int[] first = {x,y};
        q.offer(first);
        ArrayList<int[]> block = new ArrayList<>();
        block.add(first);
        boolean bottom = false;
        while(!q.isEmpty()){
            int[] now = q.poll();

            for(int d = 0; d < 4; d++){
                int nx = now[0]+dx[d];
                int ny = now[1]+dy[d];
                if(nx >= 0 && nx <R && ny >= 0 && ny < C && !visited[nx][ny] && data[nx][ny] == 'x'){
                    int[] input = {nx,ny};
                    q.offer(input);
                    block.add(input);
                    visited[nx][ny] = true;
                    if(nx == R-1) {
//                        System.out.println(nx + ", "+ny);
//                        System.out.println("x: "+ x+ ", y: "+y);
                        q.clear();
                        return;
                    }
                }

            }
        }
        down(block);
    }
    public static void down(ArrayList<int[]> block){
        int length = R;

        for(int[] b : block){
            int cnt = 0;
            int x = b[0];
            int y = b[1];
//            System.out.println("x: "+x + ", y: "+y);

            for(int i = x+1; i < R; i++){
                if(data[i][y] == 'x' && !visited[i][y] || cnt >=length){
                    break;
                }
                cnt++;
            }
            length = Math.min(length,cnt);
        }

//        System.out.println("length: "+length);
        for(int[] b :block){
            int x = b[0];
            int y = b[1];
            data[x][y] = '.';
        }
        for(int[] b :block){
            int x = b[0];
            int y = b[1];
            data[x+length][y] = 'x';
        }
    }

    public static int shot(int x, int check){
//        System.out.println("x:"+x+", check: "+check);
        int y = 0;
        if(check == 1){
            y = C-1;
        }
        for(int j = 0; j < C; j++){
            if(data[x][y] == 'x'){
                data[x][y] = '.';
                return y;
            }
            y += spear[check];
        }
        return -1;
    }

    public static void printData(){
        System.out.println("=================");
        for(int i = 0; i < R; i++){
            System.out.println(Arrays.toString(data[i]));
        }
        System.out.println("=================");
    }
}

//12 24
//........................
//........................
//..........xxxxxxxxxxx...
//..........x.........x...
//..........x.........x...
//..........x.........x...
//..........x.........x...
//..........xxxxxxxxxxx...
//..............x.........
//..............x.........
//..............x.........
//..............x.........
//2
//10