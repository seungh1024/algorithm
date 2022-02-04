package day0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1873_상호의배틀필드 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T;
		T=Integer.parseInt(br.readLine());
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        //RLDU
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
		int x=0;
        int y=0;
        int head=0;
        char tank = '0';
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
           	int W = Integer.parseInt(st.nextToken());
            char[][] map = new char[H][W];
            for(int i = 0; i < H; i++){
                map[i] = br.readLine().toCharArray();
            }
            //find tank
            for(int i = 0; i < H ; i++){
                int size = map[i].length;
                for(int j = 0; j < size; j++){
                    char point = map[i][j];
                    if(point == '^' || point == 'v' || point == '<' || point =='>'){
//                        System.out.println("######################");
//                        System.out.println(point);
                        tank = point;
                        x=i;
                        y=j;
                        break;
                    }
                }
            }//end find tank
            
            //set head
            switch(tank){
                case '>':
                    head = 0;
                    break;
                case '<':
                    head = 1;
                    break;
                case 'v':
                    head = 2;
                    break;
                case '^':
                    head = 3;
                    break;
            }//end set head
            
            int N = Integer.parseInt(br.readLine());
            char[] game = new char[N]; //input game
            game = br.readLine().toCharArray();
            for(int i = 0; i < N; i++){//start moving
                	char g = game[i];
                    if(g == 'S'){
                        int mx =x;
                        int my = y;
                        while(true){
                            mx += dx[head];
                            my += dy[head];
                            if(mx<0 || mx >=H || my<0 || my>=W || map[mx][my] == '#') {
                            	break;
                            }
                            else if(map[mx][my] == '*') {
                            	map[mx][my] = '.';
                            	break;
                            }
                        }
                    }
                    else{
                        switch(g){
                            case 'R':
                                head = 0;
                                tank = '>';
                                break;
                            case 'L':
                                head = 1;
                                tank = '<';
                                break;
                            case 'D': 
                                head = 2;
                                tank = 'v';
                                break;
                            case 'U':
                                head = 3;
                                tank = '^';
                                break;
                        }
                       
                        x += dx[head];
                        y += dy[head];
                        //if cannot move -> reset
                        if(x<0 || x >=H || y<0 || y>=W || map[x][y] != '.'){
                        	x -= dx[head];
                            y -= dy[head];
                        }else {
                        	map[x-dx[head]][y-dy[head]] = '.';
                        }
                    }
            }//end moving
            map[x][y] = tank;
    		System.out.printf("%s%d ","#",test_case);
        	for(int j = 0; j < H; j++){
                for(int k = 0; k < W; k++){
                    System.out.printf("%c",map[j][k]);
                }
                System.out.println();
            }
                            
            
		}
	}
}
