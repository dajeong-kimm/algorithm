import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 구간 합 구하기
 * 어떤 N개의 수
 * 중간에 수의 변경이 빈번히 일어나고, 그 중간에 어떤 부분의 합을 구하려고 함
 * 
 * 1<=N<=1_000_000
 * 1<=M<=10_000
 * 1<=K<=10_000
 * 
 * M : 변경이 일어나는 횟수
 * K : 구간의 합을 구하는 횟수
 * 
 * a == 1 : b번째 수를 c로 바꾸기
 * a == 2 : b번째 수부터 c번째 수까지의 합을 구하여 출력
 * 
 * segment tree : 이진 트리 구조
 * 왼쪽 자식노드는 부모 노드의 2배 idx , 오른쪽은 2배 idx + 1
 * 
 * 배열의 크기 (2^(h+1))
 * @author SSAFY
 *
 */
public class Main {
	static int N,M,K;
	static long[] arr;
	
	static class SegmentTree {
		long tree[]; //각 원소가 담길 트리
		int treeSize;
		
		public SegmentTree(int arrSize) {
			//트리 높이 구하기
			int h = (int) Math.ceil(Math.log(arrSize) / Math.log(2));
			this.treeSize = (int) Math.pow(2, h+1);
			tree = new long[treeSize];
		}
		
		public long init(long[] arr, int node, int start, int end) {
			//배열의 시작과 끝이 같다면 leaf 노드
			if (start == end) {
				return tree[node] = arr[start];
			}
			
			//leaf 노드가 아니면, 자식노드 합 담기
			return tree[node] = init(arr,node*2,start,(start+end)/2) + init(arr, node*2+1, (start+end)/2+1, end);
		}
		
		/**
		 * 
		 * @param node 현재 노드 idx
		 * @param start 배열의 시작
		 * @param end 배열의 끝
		 * @param idx 변경된 데이터의 idx
		 * @param diff 원래 데이터 값과 변경 데이터의 차이
		 */
		public void update(int node, int start, int end, int idx, long diff) {
			if (idx < start || end < idx) return;
			
			tree[node] += diff;
			
			//리프 노드가 아니면 아래 자식들도 확인
			if (start != end) {
				update(node*2, start, (start+end)/2, idx, diff);
				update(node*2+1, (start+end)/2+1, end, idx, diff);
			}
		}
		
		/**
		 * 
		 * @param node 현재 노드
		 * @param start 배열의 시작
		 * @param end 배열의 끝
		 * @param left 원하는 누적합의 시작
		 * @param right 원하는 누적합의 끝
		 * @return
		 */
		public long sum(int node, int start, int end, int left, int right) {
			if(left > end || right < start) return 0;
			
			//범위 내 완전히 포함시에는 더 내려가지 않고 바로 리턴
			if (left<=start && end<=right) {
				return tree[node];
			}
			
			return sum(node*2,start,(start+end)/2,left,right) + sum(node*2+1,(start+end)/2+1,end,left,right);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new long[N+1];
		for (int i=1;i<=N;i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		SegmentTree tree = new SegmentTree(N);
		
		tree.init(arr, 1, 1, N);
		
		for (int i=0;i<M+K;i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			//데이터 변경
			if (a == 1) {
				tree.update(1, 1, N, b, c-arr[b]);
				arr[b] = c;
			}
			//구간합 
			else {
				System.out.println(tree.sum(1, 1, N, b, (int)c));
			}
		}
	}
	
	

}