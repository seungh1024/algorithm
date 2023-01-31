import java.io.*;
import java.util.*;

public class BJ_1713_후보추천하기 {
    public static int N,M;
    public static boolean[] visited;
    public static int[] totalCnt;
    public static int[] totalOld;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        totalCnt = new int[101];
        visited = new boolean[101];
        totalOld = new int[101];
        int old = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int now;
        for(int i = 0; i < M; i++){
            now = Integer.parseInt(st.nextToken());
            if(old < N && !visited[now]){
                old ++;
                totalCnt[now] ++;
                visited[now] = true;
                totalOld[now] = old;
            }
            else if(old < N && visited[now]){
                totalCnt[now] ++;
            }
            else if(old >= N){ //N명 이상 추천에 들어간 경우
                if(visited[now]){// 이미 방문한 경우 카운트만 증가
                    totalCnt[now] ++;
                }
                else if(!visited[now]){// 추천되지 않은 경우 추천된 것 중에 가장 추천을 덜 받고 가장 오래된 것을 꺼내야 함
//                    System.out.println("?");
//                    System.out.println(Arrays.toString(visited));
                    findNum();
                    old++;
                    totalCnt[now] ++;
                    visited[now] = true;
                    totalOld[now] = old;
//                    System.out.println(Arrays.toString(visited));
//                    System.out.println(Arrays.toString(totalOld));
                }
            }
        }

        for(int i = 0; i < 101; i++){
            if(visited[i]){
                System.out.print(i + " ");
            }
        }


    }

    public static void findNum(){

        int num = 0, cnt = 0, old = 0;
        for(int i = 0; i < 101; i++){ // 추천된 사람을 찾음
            if(visited[i]){ // 추천된 경우
                if(num == 0){ //처음 찾은 경우
                    num = i;
                    cnt = totalCnt[i];
                    old = totalOld[i];
                }
                else{ // 먼저 저장한 학생이 있는 경우
                    if(cnt >totalCnt[i]){ // 저장한 추천수가 비교하는 것보다 크다면 작은 것을 퇴출해야 함
                        num = i;
                        cnt = totalCnt[i];
                        old = totalOld[i];
                    }
                    else if(cnt == totalCnt[i]){ // 저장한 추천수가 비교하는 것과 같은 경우. 저장한 추천수가 큰 경우는 값 변경 필요 없음
                        if(old > totalOld[i]){ //저장한 학생이 최근에 추천 받은 경
                            num = i;
                            cnt = totalCnt[i];
                            old = totalOld[i];
                        }
                    }
                }
            }
        }

        visited[num] = false; // 추천에서 제거
        totalCnt[num] = 0;

    }


}
