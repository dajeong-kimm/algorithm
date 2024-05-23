import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 왼쪽 H, 오른쪽 H 만큼 주위를 비춤
// 0~N을 밝히게 가로등을 설치해 달라고 인천광역시에 민원
// 최소한의 높이
public class Main {
    static int[] arr;
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        // 가로등의 위치
        arr = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<M;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 1;
        int right = N;
        int result = 0;

        while (left<=right) {
            int mid = (left+right)/2;

            if (possible(mid)) {
                result = mid;
                right = mid-1;
            }
            else left = mid+1;
        }

        System.out.println(result);

}
    static boolean possible(int target) {
        int prev = 0;

        for (int i=0;i<arr.length;i++){
            if (arr[i]-target<=prev) {
                prev = arr[i]+target;
            } else return false;
        }
        return N-prev<=0;
    }}
