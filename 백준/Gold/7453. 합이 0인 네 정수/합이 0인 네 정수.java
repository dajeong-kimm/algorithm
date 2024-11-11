import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

     // A와 B의 합
        int[] listAB = new int[n * n];
        int[] listCD = new int[n * n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                listAB[idx] = A[i] + B[j];
                listCD[idx] = C[i] + D[j];
                idx++;
            }
        }

        Arrays.sort(listAB);
        Arrays.sort(listCD);
        
        long answer = 0;
        int left = 0;
        int right = listCD.length - 1;
        
        while (left < listAB.length && right >= 0) {
            int sum = listAB[left] + listCD[right];

            if (sum == 0) {
                long countAB = 1;
                long countCD = 1;

                while (left + 1 < listAB.length && listAB[left] == listAB[left + 1]) {
                    countAB++;
                    left++;
                }

                while (right - 1 >= 0 && listCD[right] == listCD[right - 1]) {
                    countCD++;
                    right--;
                }

                answer += countAB * countCD;
                left++;
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(answer);
    }
}