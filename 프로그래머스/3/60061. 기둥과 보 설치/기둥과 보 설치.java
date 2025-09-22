import java.util.*;

class Solution {
    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};
        
        boolean[][][] data = new boolean[2][n+1][n+1];
        
        
        for(int[] bf : build_frame){
            int x = bf[0];
            int y = bf[1];
            int a = bf[2];
            int b = bf[3];
            
            if(b == 0){ // 삭제
                
                data[a][x][y] = false;
                if(a == 0){
                    boolean flag = true;
                    if(data[0][x][y+1]){
                        flag &= check(data,n,x,y+1,0);
                    }
                    if(data[1][x][y+1]){
                        flag &= check(data,n,x,y+1,1);
                    }
                    if(x-1>= 0 && data[1][x-1][y+1]){
                        flag &= check(data,n,x-1,y+1,1);
                    }
                    if(!flag){
                        data[a][x][y] = true;
                    }
                }else{
                    // System.out.println("x = "+x + ", y = "+y + ", a = "+ a + ", b = "+b);
                    // System.out.println(check(data,n,x,y,a));
                    // System.out.println(check(data,n,x-1,y,a));
                    // System.out.println(check(data,n,x+1,y,a));
                    
                    boolean flag = true;
                    if(data[0][x][y]){
                        flag &= check(data,n,x,y,0);
                    }
                    if(x+1 <= n && data[0][x+1][y]){
                        flag &= check(data,n,x+1,y,0);
                    }
                    if(x-1>= 0 && data[1][x-1][y]){
                        flag &= check(data,n,x-1,y,1);
                    }
                    if(x+1<=n && data[1][x+1][y]){
                        flag &= check(data,n,x+1,y,1);
                    }
                    if(!flag){
                        data[a][x][y] = true;
                    }    
                }
                
            }else{ // 생성
                if(check(data,n,x,y,a)){
                    data[a][x][y] = true;
                }
            }
        }
        
        List<int[]> list = new ArrayList<>();
        
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= n; j++){
                if(data[0][i][j]){
                    list.add(new int[]{i,j,0});
                }
                if(data[1][i][j]){
                    list.add(new int[]{i,j,1});
                }
            }
        }
        
        
        Collections.sort(list,Comparator.comparingInt((int[] o)->o[0]).thenComparingInt((int[] o)->o[1]).thenComparingInt(o->o[2]));
        
        answer = new int[list.size()][3];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    public boolean check(boolean[][][]data, int N, int x, int y, int a){
        if(a == 0){
            if(y == 0 || (y-1>=0 &&  data[0][x][y-1]) || data[1][x][y] || (x-1>=0 && data[1][x-1][y])){
                return true;
            }
        }else{
            if((y-1>= 0 && data[0][x][y-1]) || (y-1>=0 && x+1<=N && data[0][x+1][y-1]) || (x-1>=0&&data[1][x-1][y] && x+1<=N && data[1][x+1][y])){
                return true;
            }
        }
        
        return false;
    }
}