import java.io.*;
import java.util.*;

class Main {
    static int[][] arr;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] arrSum = new int[N];
        arrSum[0] = arr[0];
        for (int i=1;i<N;i++){
            arrSum[i] = arrSum[i-1]+arr[i];
        }

        int answer = arrSum[K-1];

        for (int i=K;i<N;i++){
            int tmp = arrSum[i]-arrSum[i-K];
            answer = Math.max(answer,tmp);
        }
        System.out.println(answer);



    }
}