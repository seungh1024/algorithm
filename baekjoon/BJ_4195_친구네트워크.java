import java.io.*;
import java.util.*;

public class BJ_4195_친구네트워크 {
    public static int F;
    public static int[] parent;
    public static int[] count;
    public static Map<String,Integer> map;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int t = 0; t < tc; t++){
            F = Integer.parseInt(br.readLine());
            parent = new int[2*F];
            count = new int[2*F];
            map = new HashMap<>();
            init();
            int idx = 0;
            StringTokenizer st;
            for(int i = 0; i < F; i++){
                st = new StringTokenizer(br.readLine());
                String one = st.nextToken();
                String two = st.nextToken();
                if(map.get(one) == null){
                    map.put(one,idx++);
                }
                if(map.get(two) == null){
                    map.put(two, idx++);
                }
                union(map.get(one),map.get(two));
                System.out.println(count[parent[map.get(one)]]);
            }
        }
    }
    public static void init(){
        int FF = 2*F;
        for(int i = 0; i < FF; i++){
            parent[i] = i;
        }
        Arrays.fill(count,1);
    }
    public static int findParent(int a){
        if(parent[a] == a){
            return a;
        }
        return parent[a] = findParent(parent[a]);
    }
    public static void union(int a, int b){
        a = findParent(a);
        b = findParent(b);
        if(a==b){
            return;
        }
        parent[b] = a;
        count[a] += count[b];
    }
}
