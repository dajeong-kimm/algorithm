import java.io.*;
import java.util.*;

class Main {
    static int[][] arr;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());

        }
        Arrays.sort(arr,Comparator.comparingInt(a -> a[0]));

        int maxHeight = 0 ;
        int maxIndex = 0;
        for (int i=0;i<N;i++){
            if (maxHeight<arr[i][1]) {
                maxHeight = arr[i][1];
                maxIndex = i;
            }
        }

        int answer = maxHeight;
        int height = arr[0][1];
        int cur = arr[0][0];

        for (int i=1;i<maxIndex;i++){
            if (height<arr[i][1]) {
                answer += height*(arr[i][0]-cur);
                height = arr[i][1];
                cur = arr[i][0];
            }
        }
        answer += (height)*(arr[maxIndex][0]-cur);
        height = arr[N-1][1];
        cur = arr[N-1][0];
        for (int i=N-2;i>maxIndex;i--){
            if (height < arr[i][1]) {
                answer += height*Math.abs(arr[i][0]-cur);
                height = arr[i][1];
                cur = arr[i][0];
            }
        }
        answer += (height)*Math.abs(cur-arr[maxIndex][0]);

        System.out.println(answer);



    }
}