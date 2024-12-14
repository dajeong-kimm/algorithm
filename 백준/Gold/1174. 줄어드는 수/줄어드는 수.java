import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
//    static Set<Long> set = new HashSet<>();
    static List<Long> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i=0;i<10;i++){
            makeNum(i, i);
        }

//        list = new ArrayList<>(set);
        Collections.sort(list);
        if (N > list.size()) {
            System.out.println(-1);
            return;
        }

        System.out.println(list.get(N-1));


    }
    static void makeNum(int lastNum, long total) {
        list.add(total);

        for (int i=0;i<10;i++){
            if (i < lastNum) {
                long newNum = total * 10 + i;
                makeNum(i, newNum);
            }
        }
    }
}