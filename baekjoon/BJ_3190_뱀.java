package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_3190_뱀 {
    public static int N,K,L;
    public static int[][] data;
    public static int[] dx = {0,1,0,-1}; // 오, 아, 왼, 위 -> 90도씩 오른쪽 회전
    public static int[] dy = {1,0,-1,0};
    public static int[] head = {0,0};
    public static int[] tail = {0,0};
    public static Map<Integer,String> map; // 방향 전환 정보 저장
    public static Queue<int[]> q; // 꼬리 좌표 저장
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new int[N][N];
        K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            data[x][y] = 1; //사과는 1
        }

        map = new HashMap<>();
        L = Integer.parseInt(br.readLine());
        for(int i = 0; i < L; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            map.put(x,st.nextToken());
        }

        data[0][0] = -1; //뱀이 깔려있는 곳
        q = new LinkedList<>();
        int result = move();
        System.out.println(result);
    }

    public static void printData(){
        for(int i = 0; i < N; i++){
            System.out.println(Arrays.toString(data[i]));
        }
    }

    public static int move(){
        int d = 0; // 머리 방향 인덱스
        int cnt = 0;
        while(true){
            cnt++;
            int nx = head[0] + dx[d];
            int ny = head[1] + dy[d];
            if(nx>= 0 && nx <N && ny >= 0 && ny < N && data[nx][ny] != -1){
                head[0] = nx;
                head[1] = ny;
                q.offer(new int[] {nx,ny}); //꼬리가 이동할 위치를 넣어줌
                if(data[nx][ny] == 1){ // 사과 냠
                    data[nx][ny] = -1;
                }else{ // 꼬리 이동!
                    data[nx][ny] = -1; // 머리 위치 체크
                    data[tail[0]][tail[1]] = 0; //기존 꼬리 이동하여 0으로 바꿈
                    int[] now = q.poll();
                    tail[0] = now[0];
                    tail[1] = now[1];
                }
            }else{
                break;
            }
            String s = map.get(cnt);
            if(s != null){
                if(s.equals("D")){
                    d= (d+1)%4;
                }else if(s.equals("L")){
                    d = (d+3)%4;
                }
            }
//            System.out.println("nx: "+nx + ", ny: "+ny);
//            printData();
//            System.out.println("///////////////////////");
        }
        return cnt;
    }
}
