import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        ArrayList<Integer> xArr = new ArrayList<>();
        ArrayList<Integer> yArr = new ArrayList<>();
        xArr.add(0);
        yArr.add(0);
        xArr.add(w);
        yArr.add(h);

        int N = Integer.parseInt(br.readLine());
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (dir==0) yArr.add(num);
            else xArr.add(num);
        }

        Collections.sort(xArr);
        Collections.sort(yArr);

        int xMax = 0;
        int yMax = 0;

        for (int i=0;i<xArr.size()-1;i++){
            int dis = xArr.get(i+1)-xArr.get(i);
            if (dis>xMax) xMax = dis;
        }
        for (int i=0;i<yArr.size()-1;i++){
            int dis = yArr.get(i+1)-yArr.get(i);
            if (dis>yMax) yMax = dis;
        }

        System.out.println(xMax*yMax);

    }
}