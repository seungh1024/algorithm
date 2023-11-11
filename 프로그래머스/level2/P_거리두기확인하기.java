package algo_202311.kakaointern2021;

import java.io.*;
import java.util.*;

public class P_거리두기확인하기 {
    public static void main(String[] args) {
        P_거리두기확인하기 test = new P_거리두기확인하기();
        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };
        int[] result = test.solution(places);
        int[] answer = {1,0,1,1,1};
        for(int i = 0; i <5; i++){
            if(result[i] != answer[i]){
                System.out.println("fail");
                return;
            }
        }
        System.out.println("success");
    }
    public static List<int[]> people;
    public int[] solution(String[][] places) {
        int placeSize = places.length;
        int[] answer = new int[placeSize];
        int idx = 0;
        for(String[] place : places){
            if(isOk(place)){
                answer[idx] = 1;
            }else{
                answer[idx] = 0;
            }
            idx++;
        }
        return answer;
    }

    public static boolean isOk(String[] place){
        int r = place.length;
        int c = place[0].length();
        char[][] data = makeData(place,r,c);
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        for(int[] man : people){
            int x = man[0];
            int y = man[1];
            boolean[][] visited = new boolean[r][c];
            visited[x][y] = true;
            Queue<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{x,y});
            int count = 0;
            while(!q.isEmpty() && count++ < 2){
                int qSize = q.size();
                for(int s = 0; s < qSize; s++){
                    int[] now = q.poll();
                    for(int d = 0; d < 4; d++){
                        int nx = now[0]+dx[d];
                        int ny = now[1]+dy[d];
                        if(isValid(nx,ny,r,c) && !visited[nx][ny]){
                            if(data[nx][ny] == 'O'){
                                q.offer(new int[]{nx,ny});
                                visited[nx][ny] = true;
                            }else if(data[nx][ny] == 'P'){
                                return false;
                            }
                        }
                    }
                }
            }
        }

        return true;

    }



    public static char[][] makeData(String[] place, int r, int c){
        char[][] data = new char[r][c];
        people = new ArrayList<>();
        for(int i = 0; i < r; i++){
            char[] input = place[i].toCharArray();
            for(int j = 0; j < c; j++){
                data[i][j] = input[j];
                if(data[i][j] == 'P'){
                    people.add(new int[]{i,j});
                }
            }
        }

        return data;
    }

    public static boolean isValid(int x, int y, int r, int c){
        if(x>= 0 && x < r && y >= 0 && y < c){
            return true;
        }
        return false;
    }
}
