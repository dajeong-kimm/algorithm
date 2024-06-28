import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] n_arr = new int[N];
            int[] m_arr = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                n_arr[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                m_arr[i] = Integer.parseInt(st.nextToken());
            }

            int answer = Integer.MIN_VALUE;
            //A가 B보다 짧을 경우
            if (N<M){
                for (int i=0;i<=M-N;i++){
                    int sum = 0;
                    for(int j=0;j<N;j++){
                        sum += n_arr[j]*m_arr[i+j];
                    }
                    if (sum>answer) answer = sum;

            }
            // B가 A보다 짧을 경우
            } else {
                for (int i=0;i<=N-M;i++){
                    int sum = 0;
                    for (int j=0;j<M;j++){
                        sum += m_arr[j]*n_arr[i+j];
                    }
                    if(sum>answer) answer = sum;
                }
            }
            System.out.println("#"+test_case+" "+answer);
        }
    }
}
