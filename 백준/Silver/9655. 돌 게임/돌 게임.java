import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String answer = "";
        if (n == 1) answer = "SK";
        else if (n==2) answer = "CY";
        else if (n == 3) answer = "SK";
        else if (n == 4) answer = "CY";
        else {
            int[] dp = new int[n+1];

            dp[1] = 0;
            dp[2] = 1;
            dp[3] = 0;
            dp[4] = 1;

            for (int i=5;i<=n;i++){
                if (dp[i-1]==1 || dp[i-3]==1) dp[i] = 0;
                else dp[i] = 1;
            }
            if (dp[n] == 0) answer = "SK";
            else answer = "CY";

        }
        System.out.println(answer);

    }
}
