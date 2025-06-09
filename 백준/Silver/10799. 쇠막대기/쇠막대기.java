import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Character> stack = new Stack<>();
		
		int answer = 0;
		
		String input = br.readLine();
		for (int i=0;i<input.length();i++) {
			char cur = input.charAt(i);
			
			if (cur == '(') {
				stack.add(cur);
			} else {
				stack.pop();
				if (input.charAt(i-1) == '(') {
					answer += stack.size();
				} else {
					answer++;
				}
			}
		}
		System.out.println(answer);

	}

}
