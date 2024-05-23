import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = br.readLine();
            if (line.equals("end")) break;
            boolean answer = true;
            char before = ' ';
            int a_count = 0; //모음 개수
            int b_count = 0; //자음 개수
            int cnt = 0; //전체 모음 개수
            String tmp = "aeiou";
            char[] t = tmp.toCharArray();
            for (char c : line.toCharArray()){
                boolean flag = false;
                for (char tt : t) {
                    if (c == tt) {
                        cnt += 1;
                        b_count = 0;
                        a_count += 1;
                        flag = true;
                    }
                }  if (!flag) {
                    b_count += 1;
                    a_count = 0;
                }
                if (a_count>=3 || b_count>=3) {
                    answer = false;
                    break;
                }
                if (before == c) {
                    if (c == 'e' || c=='o') continue;
                    else {
                        answer = false;
                        break;
                    }
                }
                before = c;

            }
            if (cnt<1) answer = false;

            if (answer) System.out.println("<"+line+"> is acceptable.");
            else System.out.println("<"+line+"> is not acceptable.");
        }
    }
}