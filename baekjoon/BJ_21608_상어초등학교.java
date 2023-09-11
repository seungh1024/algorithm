package algo_202309;

import java.io.*;
import java.util.*;

public class BJ_21608_상어초등학교 {
    public static int[][] classRoom;
    public static int[][] emptySeat; // 인접한 칸 중 비어있는 칸 세는거
//    public static boolean[][] visited;
    public static int[][] students;
    public static int N;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static PriorityQueue<Seat> pq;
    public static HashMap<Integer,Seat> hashMap;
    public static ArrayList<Seat> studentList;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        classRoom = new int[N+1][N+1];
        emptySeat = new int[N+1][N+1];
        students = new int[N+1][N+1];
        studentList = new ArrayList<>();
//        visited = new boolean[N+1][N+1];
        pq = new PriorityQueue<>();
        hashMap = new HashMap<>();
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                for(int d = 0; d < 4; d++){
                    int nx = i+dx[d];
                    int ny = j+dy[d];
                    if(nx>0 && nx <= N && ny > 0 && ny <= N){
//                        System.out.println("x: "+i+", y: "+j +", nx: "+nx +", ny: "+ny);
                        emptySeat[i][j] ++;
                    }
                }
//                pq.offer(new Seat(i,j));
            }
        }

        int length = N*N;
        for(int i = 0; i < length; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            int st1 = Integer.parseInt(st.nextToken());
            int st2 = Integer.parseInt(st.nextToken());
            int st3 = Integer.parseInt(st.nextToken());
            int st4 = Integer.parseInt(st.nextToken());
            find(student,st1,st2,st3,st4);
        }
        int result = makeResult();
        System.out.println(result);
    }
    public static int makeResult(){
        int result = 0;
        for(Seat student :studentList){
            int cnt = 0;
            for(int d = 0; d <4 ;d++){
                int nx = student.x + dx[d];
                int ny = student.y + dy[d];
                if(nx>0 && nx <= N && ny > 0 && ny <= N){
                    int lover = students[nx][ny];
                    if(lover== student.st1 || lover == student.st2 || lover == student.st3 || lover == student.st4){
                        cnt++;
                    }
                }
            }
            if(cnt == 1){
                result++;
            }else if(cnt == 2){
                result+=10;
            }else if(cnt == 3){
                result += 100;
            }else if(cnt == 4){
                result+=1000;
            }
        }
        return result;
    }

    public static void find(int me, int st1, int st2, int st3, int st4){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(st1);
        list.add(st2);
        list.add(st3);
        list.add(st4);

        pq.clear();
        for(int student : list){
            if(hashMap.get(student) != null){
                Seat now = hashMap.get(student);
                for(int d = 0; d <4; d++){
                    int nx = now.x+dx[d];
                    int ny = now.y+dy[d];
                    if(nx> 0 && nx <= N && ny >0 && ny <=N && classRoom[nx][ny] != -1){
                        classRoom[nx][ny]++; //인접한 자리 ++
                    }
                }
            }
        }
        for(int i = 1; i<= N; i++){
            for(int j = 1; j <= N; j++){
                if(students[i][j] == 0){
                    pq.offer(new Seat(i,j));
                }
            }
        }
//        System.out.println("---classroom1-------");
//        for(int i = 0; i <= N; i++){
//            System.out.println(Arrays.toString(classRoom[i]));
//        }
//        System.out.println("---------");

        Seat mySeat = pq.poll();
        for(int d = 0; d < 4; d++){
            int nx = mySeat.x+dx[d];
            int ny = mySeat.y+dy[d];
            if(nx > 0 && nx <= N && ny > 0 && ny <= N){
                emptySeat[nx][ny]--; // 다른 자리 기준 인접한 자리에 사람 앉음 -> 해당 자리의 인접 수 감소
            }
        }
//        System.out.println("============");
//        for(int i = 0; i <= N; i++){
//            System.out.println(Arrays.toString(emptySeat[i]));
//        }
//        System.out.println("--===========");
        students[mySeat.x][mySeat.y] = me;
        studentList.add(new Seat(mySeat.x, mySeat.y,me,st1,st2,st3,st4));
        classRoom[mySeat.x][mySeat.y] = -1;
        hashMap.put(me, new Seat(mySeat.x, mySeat.y));
        for(int student : list){
            if(hashMap.get(student) != null){
                Seat now = hashMap.get(student);
                for(int d = 0; d <4; d++){
                    int nx = now.x+dx[d];
                    int ny = now.y+dy[d];
                    if(nx> 0 && nx <= N && ny >0 && ny <=N && classRoom[nx][ny] != -1){
                        classRoom[nx][ny]--; //인접한 자리 ++
                    }
                }
            }
        }
//        System.out.println("----------");
//        for(int i = 0; i <= N; i++){
//            System.out.println(Arrays.toString(classRoom[i]));
//        }
//        System.out.println("---------");
    }



    public static class Seat implements Comparable<Seat>{
        int x,y,num,st1,st2,st3,st4;

        public Seat(int x, int y){
            this.x = x;
            this.y = y;
        }
        public Seat(int x, int y, int num,int st1, int st2, int st3, int st4){
            this.x = x;
            this.y = y;
            this.num = num;
            this.st1 = st1;
            this.st2 = st2;
            this.st3 = st3;
            this.st4 = st4;
        }

        @Override
        public int compareTo(Seat s){
            if(classRoom[this.x][this.y] == classRoom[s.x][s.y]){
                if(emptySeat[this.x][this.y] == emptySeat[s.x][s.y]){
                    if(this.x == s.x){
                        return this.y-s.y;
                    }else{
                        return this.x-s.x;
                    }
                }else{
                    return emptySeat[s.x][s.y] - emptySeat[this.x][this.y];
                }
            }else {
                return classRoom[s.x][s.y] - classRoom[this.x][this.y];
            }
        }
    }
}
