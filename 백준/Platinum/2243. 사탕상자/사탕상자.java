import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 사탕상자
 * 맛 : 1 ~ 1_000_000 (1이 가장 맛있는 사탕)
 * 자료구조, 세그먼트 트리, 이분탐색
 * @author KOREA
 *
 */
public class Main {
	static int n;
	//A == 1 : 사탕상자에서 사탕을 꺼내는 경우 B : 사탕의 순위
	//A == 2 : 사탕을 넣는 경우 : B는 사탕의 맛, C는 그러한 사탕의 개수 (C가 음수일 경우에는 빼는 경우)
	//맨처음에는 빈 사탕상자에서 시작
	//사탕의 총 개수는 2_000_000_000 (20억)
	//A가 1인 모든 입력에 대해서, 꺼낼 사탕의 맛의 번호 출력
	
	static int MAX = 1_000_000;
	static int[] tree = new int[4*MAX]; //
	
	//트리 업데이터 (맛 C에 사탕 개수 diff만큼 추가/제거)
	static void update(int node, int start, int end, int idx, int diff) {
		if (idx < start || idx > end) return;
		
		//리프 노드에 도달하면 값 갱신
		tree[node] += diff;
		
		//리프 노드가 아니면 자식 노드를 재귀적으로 업데이트
		if (start != end) {
			int mid = (start+end)/2;
			update(node*2, start, mid, idx, diff);
			update(node*2+1, mid+1, end, idx, diff);
		}
	}
	
	//사탕의 순위에 해당하는 맛을 찾는 함수
	public static int query(int node, int start, int end, int rank) {
		//리프 노드에 도달하면 해당 맛을 반환
		if (start == end) return start;
		
		int mid = (start+end)/2;
		
		//왼쪽 자식의 합이 순위보다 크거나 같으면 왼쪽 자식에서 찾음
		if (tree[node*2] >= rank) {
			return query(node*2, start, mid, rank);
		}
		
		//그렇지 않으면 오른쪽 자식에서 남은 순위로 찾음
		else {
			return query(node*2+1, mid+1, end, rank-tree[node*2]);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			
			//사탕을 꺼내는 경우
			if (A == 1) {
				int B = Integer.parseInt(st.nextToken());
				int flavor = query(1,1,MAX,B);
				System.out.println(flavor);
				update(1,1,MAX, flavor, -1);
			}
			
			//사탕을 넣거나 빼는 경우
			else {
				int B = Integer.parseInt(st.nextToken()); //사탕의 맛
				int C = Integer.parseInt(st.nextToken()); //사탕의 개수
				update(1,1,MAX,B,C);
			}
		}
	}

}