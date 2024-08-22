import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 정수를 하나씩 외칠 때마다 지금까지 말한 수 중에서 중간값 말하기
 * 외친 수가 짝수개라면 중간에 있는 두 수중 작은 수 말하기
 * @author KOREA
 *
 */
public class Main {
	static int N; //N<=100_000
	
	static PriorityQueue<Integer> left;
	static PriorityQueue<Integer> right;
	
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		sb = new StringBuilder();
		
		left = new PriorityQueue<>(Collections.reverseOrder()); //최대힙
		right = new PriorityQueue<>(); //최소힙
		
		for (int i=0;i<N;i++) {
			int x = Integer.parseInt(br.readLine());
			
			if (left.size() == right.size()) {
				left.add(x);
			} else {
				right.add(x);
			}
			
			if (!right.isEmpty() && (right.peek() < left.peek())) {
				int left_value = left.poll();
				int right_value = right.poll();
				
				left.add(right_value);
				right.add(left_value);
			}
			
			sb.append(left.peek()).append("\n");
		}
		System.out.println(sb);

	}

}