import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr;
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            arr = new int[num];
            double total = 0;
            for (int j=0;j<num;j++){
                int tmp = Integer.parseInt(st.nextToken());
                total += tmp;
                arr[j] = tmp;
            }

            double avg = (total/num);

            int cnt = 0;

            for (int j=0;j<num;j++){
                if (arr[j]>avg) cnt += 1;
            }

            double answer = (double) cnt /num;

            System.out.printf("%.3f%%\n",answer*100);
        }
    }
}