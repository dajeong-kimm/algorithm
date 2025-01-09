import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        int len = 1;
        // 4 7 44 47 74 77  444 447 474 477 744 747 774 777

        while (true) {
            K -= (int) Math.pow(2, len);
            if (K <= 0) {
                K += (int) Math.pow(2, len);
                break;
            }
            len++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=len-1;i>=0;i--){
            if (K <= (int) Math.pow(2, i)){
                sb.append(4);
            }
            else{
                sb.append(7);
                K -= (int) Math.pow(2 , i);
            }
        }

        System.out.println(sb);



    }


}