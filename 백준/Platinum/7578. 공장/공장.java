import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 공장
 * 2N열의 기계가 2열에 거쳐 N개씩 배치
 * 
 * 기계의 위치를 바꾸지 않은 상태에서 케이블을 두 기계로 잇는 직선의 형태로 만들기로 함
 * 
 * 서로 교차하는 케이블 쌍의 개수를 정확하게 세어 출력하는 프로그램
 * 
 * 
 * 세그먼트 트리 : [i+1, N] 구간의 방문한 식별번호의 개수의 합
 * @author KOREA
 *
 */
public class Main {
	static int N;
	static long[] tree;
	
	static int[] A;
	static Map<Integer, Integer> map = new HashMap<>(); //식별번호, 인덱스

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		A = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i=1;i<=N;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i=1;i<=N;i++) {
			int val = Integer.parseInt(st.nextToken());
			map.put(val, i);
		}
		
		tree = new long[N*4];
		long ans = 0;
		
		for (int i=1;i<=N;i++) {
			int valA = A[i];
			int valB = map.get(valA); //A[i]와 같은 식별번호가 있는 인덱스
			
			//valB보다 큰 인덱스 중에 이미 방문한 적 있는 인덱스의 개수 구하기
			ans += sum(1,N,1,valB+1,N);
			
			//valB를 방문했다는 의미로 1 더해주기
			update(1,N,1,valB,1);
		}
		
		System.out.println(ans);
	}
	
	public static long sum(int start, int end, int node, int left, int right) {
		if (end < left || right < start) return 0;
		
		if (left <= start && end <= right) {
			return tree[node];
		}
		
		int mid = (start+end)/2;
		return sum(start, mid, node*2, left, right) + sum(mid+1, end, node*2+1, left, right);
	}
	
	public static void update(int start, int end, int node, int idx, int diff) {
		if (idx < start || idx > end) return ;
		
		tree[node] += diff;
		
		if (start != end) {
			int mid = (start+end)/2;
			update(start, mid, node*2, idx, diff);
			update(mid+1, end, node*2+1, idx, diff);
		}
	}

}