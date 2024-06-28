import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case=1;test_case<=T;test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            int[][] arr = new int[N][N];

            for (int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for (int j=0;j<N;j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] arr90 = new int[N][N];
            int[][] arr180 = new int[N][N];
            int[][] arr270 = new int[N][N];

            arr90 = rotateArr(arr,N);
            arr180 = rotateArr(arr90,N);
            arr270 = rotateArr(arr180,N);
            System.out.println("#"+test_case);
            for (int i=0;i<N;i++){
                for (int j=0;j<N;j++){
                    System.out.print(arr90[i][j]);
                }
                System.out.print(" ");
                for (int j=0;j<N;j++){
                    System.out.print(arr180[i][j]);
                }
                System.out.print(" ");
                for (int j=0;j<N;j++){
                    System.out.print(arr270[i][j]);
                }
                System.out.println();
            }




        }
    }
    private static int[][] rotateArr (int[][] array, int N){
        int[][] rotated = new int[N][N];
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                rotated[i][j] = array[N-j-1][i];
            }
        }
        return rotated;
    }
}
