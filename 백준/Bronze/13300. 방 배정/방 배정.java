import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] arr = new int[6][2];

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());//성별
            int Y = Integer.parseInt(st.nextToken());//학년
            arr[Y-1][S]++;
        }
        int answer = 0;
        for (int i=0;i<6;i++){
            for (int j=0;j<2;j++){
                if (arr[i][j] == 0) continue;
                else if (arr[i][j]%K == 0) answer += arr[i][j]/K;
                else answer += arr[i][j]/K+1;
            }
        }
        System.out.println(answer);



    }
}