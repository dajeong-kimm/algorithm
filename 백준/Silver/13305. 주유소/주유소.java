import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;

// N개의 도시
// 기름통의 크기는 무제한
// 최소의 비용 계산
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] road = new long[N-1];
        for (int i=0;i<N-1;i++){
            road[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        long[] cost = new long[N];
        for (int i=0;i<N;i++){
            cost[i] = Long.parseLong(st.nextToken());
        }

        long answer = 0;
        long min_Price = cost[0];

        for (int i=0;i<N-1;i++){
            if (min_Price>cost[i]) {
                min_Price = cost[i];
            }
            answer += road[i]*min_Price;
        }

        System.out.println(answer);
    }
}