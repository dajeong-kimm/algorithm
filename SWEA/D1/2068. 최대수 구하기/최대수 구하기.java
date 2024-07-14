import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10];
        int T = Integer.parseInt(br.readLine());
        for (int t = 1 ;t<=T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i=0;i<10;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            System.out.println("#"+t+" "+arr[arr.length-1]);
        }
    }
}