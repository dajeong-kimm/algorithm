import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[1001][1001];
        int min_x = 0;
        int min_y = 0;
        int max_x = 1000;
        int max_y = 1000;
        for (int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            min_x = Math.min(min_x,a);
            max_x = Math.max(max_x,a+c-1);
            min_y = Math.min(min_y,c);
            max_y = Math.max(max_y, b+d-1);
            for (int x=a;x<a+c;x++){
                for (int y=b;y<b+d;y++){
                    arr[x][y] = i;
                }
            }
        }

        for (int i=1;i<=N;i++){
            int count = 0;
            for (int x=min_x;x<=max_x;x++){
                for (int y=min_y;y<=max_y;y++){
                    if (arr[x][y] == i) count++;
                }
            }
            System.out.println(count);
        }




    }
}