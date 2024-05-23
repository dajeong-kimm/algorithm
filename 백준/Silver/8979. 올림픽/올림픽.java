import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int n,k;
    static ArrayList<Node> list = new ArrayList<Node>();
    static int end_point = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] t = br.readLine().split(" ");
        n = Integer.parseInt(t[0]);
        k = Integer.parseInt(t[1]);

        for (int i=0;i<n;i++){
            String[] tt = br.readLine().split(" ");
            int num = Integer.parseInt(tt[0]);
            int gold = Integer.parseInt(tt[1]);
            int silver = Integer.parseInt(tt[2]);
            int bronze = Integer.parseInt(tt[3]);
            list.add(new Node(num,gold,silver,bronze,0));
        }

        Collections.sort(list);

        list.get(0).rate = 1;

        for (int i=1;i<list.size();i++){
            int tmp_gold = list.get(i-1).gold;
            int tmp_silver = list.get(i-1).silver;
            int tmp_bronze = list.get(i-1).bronze;
            Node now = list.get(i);
            if (list.get(i).num == k) {
                end_point = i;
            }
            if(now.gold == tmp_gold && now.silver == tmp_silver && now.bronze==tmp_bronze) {
                list.get(i).rate = list.get(i-1).rate;
            }
            else {
                list.get(i).rate = i+1;
            }
        }

        System.out.println(list.get(end_point).rate);

    }

    static class Node implements Comparable<Node> {
        int num,gold,silver,bronze,rate;
        Node(int num, int gold, int silver, int bronze, int rate) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
            this.rate = rate;
        }
        @Override
        public int compareTo(Node o) {
            if (this.gold == o.gold){
                if (this.silver==o.silver){
                    return o.bronze-this.bronze;
                }
                else {
                    return o.silver-this.silver;
                }
            }
            else {
                return o.gold - this.gold;
            }
        }
    }
}

