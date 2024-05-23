import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        int answer = 0;
        if (n==1) answer = 1;
        else if (n<=7) answer = 2;
        else {
            n -= 1;
            answer = 1;
            long tmp = 6;
            while (n>0) {
                answer += 1;
                n -= tmp;
                tmp += 6;
            }
        }
        System.out.println(answer);

//        System.out.println(n);
    }
}