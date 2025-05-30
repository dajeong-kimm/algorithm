import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int answer = 0;

        int[][] arr = new int[N][2];
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+1];

        for (int i = N-1; i>=0;i--){
            int time = arr[i][0];
            int value = arr[i][1];

            if (i+time<=N){
                dp[i] = Math.max(dp[i+1], dp[i+time]+value);
            } else {
                dp[i] = dp[i+1];
            }
        }

        System.out.println(dp[0]);
    }
}