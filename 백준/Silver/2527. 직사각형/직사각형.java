import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i=0;i<4;i++){
            st = new StringTokenizer(br.readLine());
            int a,b,c,d,A,B,C,D;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            if (c<A || C<a || b>D || B>d) {
                System.out.println('d');
            } else if (a == C || A==c){
                if (d==B || D ==b) System.out.println('c');
                else System.out.println('b');
            } else if (d==B || D==b){
                System.out.println('b');
            } else System.out.println('a');
        }
    }
}