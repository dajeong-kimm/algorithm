import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static int answer = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		//그래프가 끝나고 난 뒤 한칸더 까지 봐야함
		int[] arr = new int[N+2];
		for (int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Stack<Integer> stack = new Stack<>();
		stack.add(0);
		
		for (int i=1;i<=N+1;i++) {
			while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
				int y = arr[stack.peek()];
				stack.pop();
				int x = i - stack.peek() -1;
				
				answer = Math.max(answer, x*y);
			}
			stack.add(i);
		}
		System.out.println(answer);
		
		
	}

}