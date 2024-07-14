import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        for (int i=0;i<N;i++){
            int[] A = new int[5];
            int[] B = new int[5];
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            for (int j=0;j<a;j++){
                A[Integer.parseInt(st.nextToken())]++;
            }
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            for (int j=0;j<b;j++){
                B[Integer.parseInt(st.nextToken())]++;
            }
            char result = round(A,B);
            System.out.println(result);
        }



    }
    private static char round(int[] A, int[] B){
        char result = ' ';
        if (A[4] != B[4]) {
            if (A[4]>B[4]) result = 'A';
            else result = 'B';
        } else if (A[3] != B[3]) {
            if (A[3]>B[3]) result = 'A';
            else result = 'B';
        } else if (A[2] != B[2]) {
            if (A[2]>B[2]) result = 'A';
            else result = 'B';
        } else if (A[1]!=B[1]) {
            if (A[1]>B[1]) result = 'A';
            else result = 'B';
        } else result = 'D';
        return result;
    }
}