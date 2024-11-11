import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long answer = 0;
		Stack<int[]> stack = new Stack<>();
		
		for (int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			int count = 1; //같은 키의 사람 수
			
			while (!stack.isEmpty() && stack.peek()[0] <= num) {
				int[] top = stack.pop();
				answer += top[1];
				
				if (top[0] == num) count += top[1];
			}
			
			//남은 사람은 현재 사람보다 키가 큰 사람들만 남음
			if (!stack.isEmpty()) answer++;
			
			//현재 사람 push
			stack.push(new int[] {num,count});
		}
		System.out.println(answer);
	}

}
