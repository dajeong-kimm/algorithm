import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String input = br.readLine();
        int[] avail = new int[input.length()];

        int answer = 0;
        for (int i=0;i<N;i++){
            if (input.charAt(i) == 'P') {
                for (int j=-K;j<=K;j++){
                    if (i+j>=0 && i+j<N) {
                        if (avail[i+j] == 0 && input.charAt(i+j)=='H') {
                            avail[i+j] = 1;
                            answer += 1;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(answer);

    }
}