import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 히스토그램에서 가장 큰 직사각형
 * 자료구조, 세그먼트 트리, 분할정복, 스택
 * 
 * 직사각형의 수 n (1<=n<=100_000)
 * 0<=h<=1_000_000_000
 * @author KOREA
 *
 */
public class Main {
	static int n;
	static int[] height;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if (n == 0) break;
			
			height = new int[n];
			for (int i=0;i<n;i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}
			
			System.out.println(maxArea());
		}

	}
	public static long maxArea() {
		Stack<Integer> stack = new Stack<>();
		long maxArea = 0;
		int idx = 0;
		
		while (idx < n) {
			if (stack.isEmpty() || height[stack.peek()] <= height[idx]) {
				stack.push(idx++);
			}
			//현재 막대가 더 작으면 스택에서 하나를 pop하고 직사각형 면적 계산
			else {
				int h = height[stack.pop()];
				int width = stack.isEmpty() ? idx : idx - stack.peek() -1;
				maxArea = Math.max(maxArea,  (long) h*width);
			}
		}
		
		//남아있는 스택 처리
		while (!stack.isEmpty()) {
			int h = height[stack.pop()];
			int width = stack.isEmpty() ? idx : idx - stack.peek() - 1;
			maxArea = Math.max(maxArea, (long) h *width);
		}
		
		return maxArea;
	}

}