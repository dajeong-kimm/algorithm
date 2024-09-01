import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 철로
 * 집과 사무실을 통근하는 n명의 사람들
 * 임의의 두 사람 A,B에 대하여 A의 집 혹은 사무실의 위치가 B의 집 혹은 사무실의 위치와 같을 수 있음
 * 일직선 상의 어떤 두 점을 잇는 철로 건설
 * 철로의 길이 d
 * 집과 사무실의 위치 모두 철로 선분에 포함되는 사람들의 수가 최대가 되도록 철로 선분을 정하고자 함
 * 
 * (hi, oi) : 사람 i의 집과 사무실의 위치
 * 길이 d의 모든 선분 L에 대하여, 집과 사무실의 위치가 모두 L에 포함되는 사람들의 최대 수
 * 
 * 끝점을 기준으로 오름차순 정렬 
 * --> 집과 회사 중 더 작은 값을 기준으로 정렬
 * @author KOREA
 *
 */
public class Main {
	static class Pair implements Comparable<Pair>{
		int start, end;
		Pair(int a, int b){
			start = a;
			end = b;
		}
		
		@Override
		public int compareTo(Pair other) {
			return Integer.compare(this.end, other.end);
		}
	}
	
	static int N, length;
	static ArrayList<Pair> pairs = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (a>b) {
				int tmp = a;
				a = b;
				b = tmp;
			}
			pairs.add(new Pair(a,b));
			
		}
		
		length = Integer.parseInt(br.readLine());
		
		Collections.sort(pairs);
//		for (int i=0;i<N;i++) {
//			System.out.println(pairs.get(i).start + " "+ pairs.get(i).end);
//		}
		
//		System.out.println(Arrays.toString(pairs.toArray()));
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int count = 0;
		int maximum = 0;
		for (Pair pair : pairs) {
			while (!pq.isEmpty() && pq.peek() < pair.end - length) {
				pq.poll();
				count--;
			}
			
			if (pair.start >= pair.end - length) {
				count++;
				pq.add(pair.start);
			}
			
			maximum = Math.max(maximum, count);
		}
		
		System.out.println(maximum);
	}

}