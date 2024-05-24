import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// X일 동안 가장 많이 들어온 방문자 수와 그 기간들
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr_sum = new int[N];
        int tmp = 0;
        for (int i=0;i<N;i++){
            tmp += arr[i];
            arr_sum[i] = tmp;
        }

        int answer = arr_sum[X-1];
        int count = 1;

        for (int i=0;i<N-X;i++){
            tmp = arr_sum[i+X]-arr_sum[i];
            if (tmp>answer) {
                answer = tmp;
                count = 1;
            } else if (tmp == answer) {
                count += 1;
            }
        }
        if (answer==0) System.out.println("SAD");
        else {
            System.out.println(answer);
            System.out.println(count);
        }



    }
}