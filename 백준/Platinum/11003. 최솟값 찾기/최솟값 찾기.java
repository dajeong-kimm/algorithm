import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Deque<Integer> deque = new ArrayDeque<>();
		
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<N;i++) {
			while (!deque.isEmpty() && arr[i] <= arr[deque.getLast()]) {
				deque.removeLast();
			}
			
			deque.add(i);
			
			while (!deque.isEmpty() && deque.peek() < (i-L+1)) {
				deque.poll();
			}
			
			int minValue = arr[deque.peek()];
			sb.append(minValue).append(" ");
		}
		
		System.out.println(sb);

	}

}