package algo_202304;

import java.io.*;
import java.util.*;

public class P_베스트앨범 {

    public static int[][] data;
    public static int N;
    public static HashMap<String,Integer> map;
    public static PriorityQueue<Song> pq;
    public static void main(String[] args) throws IOException{
//        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
//        int[] plays = {500, 600, 150, 800, 2500};
        String[] genres = {"classic","pop","classic","test","zzz","zzz","zzz"};
        int[] plays = {500,501,1,0,1000,1,2};

        data = new int[100][5];
        N = plays.length;
        map = new HashMap<>();
        int index = 0;
        for(int i = 0; i < N; i++){
            if(map.get(genres[i]) == null){
                map.put(genres[i],index);
                index++;
            }
            int genreIndex = map.get(genres[i]);
            pushData(genreIndex,i+1, plays[i]);
        }

        pq = new PriorityQueue<>();
        int cnt = 0;
        for(int i = 0; i < index; i++){
            for(int j = 1; j <= 2; j++){
                if(data[i][j]!=0){
                    pq.offer(new Song(data[i][0],data[i][j],data[i][j+2]));
                    cnt++;
                }
            }
        }

//        printdata();

        int[] answer = new int[cnt];
        index = 0;

        while(!pq.isEmpty()){
            Song s = pq.poll();
            answer[index] = s.index-1;
            index++;
        }
        System.out.println(Arrays.toString(answer));

    }

    public static void printdata(){
        for(int i = 0; i < N; i++){
            System.out.println(Arrays.toString(data[i]));
        }
    }

    public static void pushData(int idx, int playIndex, int value){
//        System.out.println("playIndex: "+playIndex +", value: "+value);
        data[idx][0] += value;
        if(value == data[idx][3]){
            if(value != data[idx][4]){
                data[idx][2] = playIndex;
                data[idx][4] = value;
            }
        }
        else if(value >data[idx][3]){
            data[idx][2] = data[idx][1];
            data[idx][1] = playIndex;
            data[idx][4] = data[idx][3];
            data[idx][3] = value;
        }else if(value < data[idx][3] && value >data[idx][4]){
            data[idx][2] = playIndex;
            data[idx][4] = value;
        }
//        printdata();
    }

    public static class Song implements Comparable<Song>{
        int total;
        int index;
        int play;

        public Song(int total, int index, int play){
            this.total= total;
            this.index = index;
            this.play = play;
        }

        @Override
        public int compareTo(Song o){
            if(this.total > o.total){
                return -1;
            }else if(this.total == o.total){
                return o.play-this.play;
            }else{
                return 1;
            }
        }
    }
}
