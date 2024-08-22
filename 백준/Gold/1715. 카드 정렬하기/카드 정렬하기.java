import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 정렬된 두 묶음의 숫자 카드
 * 두 묶음을 합쳐서 하나로 만드려면 (A+B)번의 비교
 * 
 * N개의 숫자 카드 묶음의 각각의 크기가 주어질 때, 최소한 몇번의 비교가 필요한지?
 * @author SSAFY
 *
 */
public class Main {
	static int N;
	static int[] arr;
	
	static PriorityQueue<Integer> pq;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
//		arr = new int[N];
		pq = new PriorityQueue<>();
		for (int i=0;i<N;i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		int answer = 0;
		while (pq.size()>=2) {
			int a = pq.poll();
			int b = pq.poll();
			
			answer += (a+b);
			pq.add(a+b);
		}
//		answer += pq.poll();
		System.out.println(answer);

	}

}