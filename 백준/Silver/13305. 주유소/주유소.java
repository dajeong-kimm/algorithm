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
        int[] road = new int[N-1];
        for (int i=0;i<N-1;i++){
            road[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] cost = new int[N];
        for (int i=0;i<N;i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        for (int i=0;i<N-1;i++){
            int min_cost = Integer.MAX_VALUE;
            for (int j=i;j<N-1;j++){
                min_cost = Math.min(min_cost,cost[j]);
            }

            if(cost[i]>min_cost) {
                answer += cost[i]*road[i];
            }
            else {
                for (int k=i;k<N-1;k++){
                    answer += min_cost*road[k];
                }
                break;
            }
        }

        System.out.println(answer);
    }
}