import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N,K;
	static int[] arr;
	static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
	static PriorityQueue<Integer> minHeap = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		for (int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		System.out.println(getAnswer());

	}
	
	static long getAnswer() {
		long result = 0;
		
		for (int i=0;i<N;i++) {
			int cur = arr[i];
			
			//중앙값을 기준으로 두 힙에 추가
			if (maxHeap.isEmpty() || cur <= maxHeap.peek()) {
				maxHeap.add(cur);
			}
			else {
				minHeap.add(cur);
			}
			
			balance();
			
			if (i >= K-1) {
				result += maxHeap.peek();
				
				int toRemove = arr[i-K+1];
				if (toRemove <= maxHeap.peek()) {
					maxHeap.remove(toRemove);
				}
				else {
					minHeap.remove(toRemove);
				}
				balance();
			}
			
			
		}
		return result;
		
	}
	
	static void balance() {
		if (maxHeap.size() > minHeap.size()+1) {
			minHeap.add(maxHeap.poll());
		}
		else if (minHeap.size() > maxHeap.size()) {
			maxHeap.add(minHeap.poll());
		}
	}

}
