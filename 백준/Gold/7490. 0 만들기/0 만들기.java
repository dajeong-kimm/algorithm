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
    	StringBuilder exp = new StringBuilder();
    	exp.append(1);
    	for (int i=0;i<N-1;i++) {
    		exp.append(arr[i]).append(i+2);
    	}
    	
    	String result = exp.toString().replace(" ", "");
    	
    	int answer = eval(result);
    	
    	if (answer == 0) {
    		return exp.toString();
    	}
    	return null;
    }
    
    public static int eval(String result) {
    	int sum = 0;
    	int num = 0;
    	int sign = 1;
    	
    	for (int i=0;i<result.length();i++) {
    		char ch  = result.charAt(i);
    		//숫자면
    		if (ch>='0' && ch<='9') {
    			num = num * 10 + (ch-'0');
    		}
    		//연산자면 
    		else {
    			sum += (num*sign);
    			num = 0;
    			
    			if (ch == '+') {
    				sign = 1;
    			} else if (ch == '-') {
    				sign = -1;
    			}
    		}
    	}
    	sum += sign*num;
    	
    	return sum;
    }
}