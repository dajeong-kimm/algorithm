import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static char[] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new char[N - 1];  // 연산자 배열 (N-1개의 연산자)
            dfs(1);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int idx) {
        if (idx == N) {
            String result = calculate();
            if (result != null) {
                sb.append(result).append("\n");
            }
            return;
        }
        
        arr[idx - 1] = ' ';  // 공백 (숫자 이어붙이기)
        dfs(idx + 1);
        
        arr[idx - 1] = '+';  // + 연산자
        dfs(idx + 1);

        arr[idx - 1] = '-';  // - 연산자
        dfs(idx + 1);

        
    }

    public static String calculate() {
        StringBuilder expression = new StringBuilder();
        expression.append(1);  // 첫 번째 숫자는 무조건 1로 시작

        for (int i = 0; i < N - 1; i++) {
            expression.append(arr[i]).append(i + 2);  // 숫자와 연산자 추가
        }

        String result = expression.toString().replace(" ", "");  // 공백 제거
        int answer = eval(result);

        if (answer == 0) {
            return expression.toString();
        }
        return null;
    }

    // 문자열 수식계산
    public static int eval(String expression) {
        int sum = 0;
        int num = 0;
        int sign = 1;  // 양수는 1, 음수는 -1

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');  // 숫자 형성
            } else {
                sum += sign * num;  // 이전 숫자까지 더하거나 뺀다
                num = 0;  // 다음 숫자를 처리하기 위해 초기화

                if (ch == '+') {
                    sign = 1;  // 양수
                } else if (ch == '-') {
                    sign = -1;  // 음수
                }
            }
        }
        sum += sign * num;  // 마지막 숫자 더하기

        return sum;
    }
}