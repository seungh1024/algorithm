package algo_202311.kakaorecruitment2023;

import java.util.*;

public class P_미로탈출명령어 {
    public static void main(String[] args) {
        P_미로탈출명령어 test = new P_미로탈출명령어();
        int n =3;
        int m = 4;
        int x = 2;
        int y = 3;
        int r = 3;
        int c = 1;
        int k = 5;
        String result = "dllrl";
        String answer = test.solution(n, m, x, y, r, c, k);
        if(result.equals(answer)) System.out.println("success");
        else System.out.println("fail");
    }

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "impossible";

        StringBuilder sb = new StringBuilder();

        while(Math.abs(x-r)+Math.abs(y-c) < k){
            if(x+1 <=n){
                x++;
                k--;
                sb.append("d");
            }else if(y-1 >0){
                y--;
                k--;
                sb.append("l");
            }else if(y-1 <= 0){
                y++;
                k--;
                sb.append("r");
            }
        }


        int xSize = Math.abs(r-x);
        int ySize = Math.abs(c-y);

        if(xSize+ySize > k) return answer;

        if(r>x){
            for(int i = 0; i < xSize;i++){
                sb.append("d");
            }
        }
        if(c<y){
            for(int i = 0; i < ySize; i++){
                sb.append("l");
            }
        }else{
            for(int i = 0; i < ySize; i++){
                sb.append("r");
            }
        }
        if(r<x){
            for(int i = 0; i < xSize; i++){
                sb.append("u");
            }
        }

        if(sb.length()>0){
            answer = sb.toString();
        }


        return answer;
    }
}
