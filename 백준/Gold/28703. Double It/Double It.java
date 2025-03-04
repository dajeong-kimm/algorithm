import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static PriorityQueue<Long> pq = new PriorityQueue<>();
	static PriorityQueue<Long> reversePQ = new PriorityQueue<>(Collections.reverseOrder());
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		long maxValue = 0;
		for (int i=0;i<N;i++) {
			long num = Long.parseLong(st.nextToken());
			pq.add(num);
			reversePQ.add(num);
			maxValue = Math.max(maxValue, num);
		}
		
		
		
		long answer = Long.MAX_VALUE;
		
		while (true) {
			long now = reversePQ.peek() - pq.peek();
			answer = Math.min(answer, now);
//			System.out.println(now+" max: "+reversePQ.peek()+" min: "+pq.peek());
//			if (before < now) {
//				System.out.println(before);
//				return;
//			}
			
			if (pq.peek() > maxValue) break;
			long num = pq.poll() *2 ;
			reversePQ.add(num);
			pq.add(num);
		}
		
		System.out.println(answer);
		
		
	}

}
