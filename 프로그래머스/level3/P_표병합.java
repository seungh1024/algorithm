package algo_202311.kakaorecruitment2023;

import java.util.*;

public class P_표병합 {
    public static void main(String[] args) {
        P_표병합 test = new P_표병합();
        String[] commands = {"UPDATE 1 1 menu", "MERGE 1 1 1 2", "MERGE 1 1 1 3", "MERGE 1 1 1 4", "MERGE 1 2 1 3", "UPDATE 1 1 hansik", "PRINT 1 1", "PRINT 1 2", "PRINT 1 3", "PRINT 1 4"};
        String[] result = {"hansik", "hansik", "hansik", "hansik"};
        String[] answer = test.solution(commands);

        int length = result.length;
        for(int i = 0; i < length; i++){
            if(!result[i].equals(answer[i])){
                System.out.println("fail");
                return;
            }
        }
        System.out.println("success");
    }

    public static String[][] data;
    public static int[][] check;
    public static int group;
    public String[] solution(String[] commands) {
        // String[] answer = {};

        data = new String[51][51];
        check = new int[51][51];
        group = 0;
        int printSize = 0;
        Queue<String> q = new ArrayDeque<>();

        for(String command : commands){
            String[] input = command.split(" ");
            int length = input.length;
            String s = input[0];

            if(s.equals("UPDATE")){
                if(length > 3){ // 1번 명령어
                    int r = Integer.parseInt(input[1]);
                    int c = Integer.parseInt(input[2]);
                    update(r,c,input[3]);
                }else{
                    update(input[1],input[2]);
                }

            }else if(s.equals("MERGE")){
                int r1 = Integer.parseInt(input[1]);
                int c1 = Integer.parseInt(input[2]);
                int r2 = Integer.parseInt(input[3]);
                int c2 = Integer.parseInt(input[4]);
                if((r1==r2)&&(c1==c2)) continue;
                merge(r1,c1,r2,c2);
            }else if(s.equals("UNMERGE")){
                int r = Integer.parseInt(input[1]);
                int c = Integer.parseInt(input[2]);
                unmerge(r,c);
            }else if(s.equals("PRINT")){
                int r = Integer.parseInt(input[1]);
                int c = Integer.parseInt(input[2]);
                printSize++;
                if(data[r][c] == null){
                    q.offer("EMPTY");
                }else{
                    q.offer(data[r][c]);
                }

            }
            // System.out.println(Arrays.toString(input));
            // printData();
        }

        String[] answer = new String[printSize];
        for(int i = 0; i < printSize; i++){
            answer[i] = q.poll();
        }
        return answer;
    }

    // 1번 명령어
    public static void update(int r, int c, String value){
        int sell = check[r][c];
        if(sell == 0){
            group++;
            check[r][c] = group;
            data[r][c] = value;
            return;
        }
        for(int i = 1; i <= 50; i++){
            for(int j = 1; j <= 50; j++){
                if(sell == check[i][j]){
                    data[i][j] = value;
                }
            }
        }
    }

    // 2번 명령어
    public static void update(String s1, String s2){
        for(int i = 1; i <= 50; i++){
            for(int j = 1; j <= 50; j++){
                if(s1.equals(data[i][j])){
                    data[i][j] = s2;
                }
            }
        }
    }

    //3번 명령어
    public static void merge(int r1, int c1, int r2, int c2){
        group ++;
        int v1 = check[r1][c1];
        int v2 = check[r2][c2];

        if(check[r1][c1] == 0){
            check[r1][c1] = group;
            v1 = group;
        }
        if(check[r2][c2] == 0){
            check[r2][c2] = group;
            v2 = group;
        }

        String change = null;
        if(data[r1][c1] != null){
            change = data[r1][c1];
        }else{
            change = data[r2][c2];
        }
        for(int i = 1; i <= 50; i++){
            for(int j =1 ; j <= 50; j++){
                if(check[i][j] == v1 || check[i][j] == v2){
                    check[i][j] = group;
                    data[i][j] = change;
                }
            }
        }

    }

    //4번 명령어
    public static void unmerge(int r, int c){
        int v = check[r][c];
        String change = data[r][c];

        for(int i = 1; i <= 50; i++){
            for(int j = 1; j <= 50; j++){
                if(check[i][j] == v){
                    check[i][j] = 0;
                    data[i][j] = null;
                }
            }
        }
        data[r][c] = change;
        group++;
        check[r][c] = group;
    }

    public static void printData(){
        System.out.println("====== data=======");
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= 4; i++){
            for(int j = 1; j <= 4; j++){
                sb.append(data[i][j]).append(" ");
            }
            sb.append("\n");
            // System.out.println(Arrays.toString(check[i]));
        }
        System.out.println(sb);
        System.out.println("====== end ======");

        System.out.println("====== check=======");
        sb = new StringBuilder();
        for(int i = 1; i <= 4; i++){
            for(int j = 1; j <= 4; j++){
                sb.append(check[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        System.out.println("====== end ======");
    }
}
