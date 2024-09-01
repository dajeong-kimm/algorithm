import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 정점들의 거리
 * 2<=N<=40_000개의 정점으로 이루어진 트리
 * M(1<=M<=10000)개의 두 노드 쌍을 입력 받을 때
 * 두 노드 사이의 거리를 출력
 * 
 * 알고리즘 : 트리, 최소 공통 조상
 * 1. 트리 정보 저장
 * 2. 트리 형성 및 부모 노드(DP)와 깊이를 따로 저장
 * 3. LCA로 최소 공통 조상 노드를 이용해서 M개의 두 노드를 출력
 * 
 * 두 정점이 n,m이고 최소 공통 조상 노드가 k일때
 * dis[n] + dis[m] - (dis[k]*2)
 * BFS -> 시간 초과
 * @author KOREA
 *
 */
public class Main {
	static class Node {
		int next, width;
		public Node(int next, int width) {
			this.next = next;
			this.width = width;
		}
	}
	
	static int N, M, maxDepth = -1;
	static ArrayList<ArrayList<Node>> tree = new ArrayList<>();
	
	static int[] depth, width;
	static int[][] parent;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		maxDepth = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
		
		parent = new int[N+1][maxDepth+1];
		width = new int[N+1];
		depth = new int[N+1];
		
		for (int i=0;i<=N;i++) {
			tree.add(new ArrayList<>());
		}
		
		for (int i=1;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			tree.get(a).add(new Node(b,cost));
			tree.get(b).add(new Node(a,cost));
		}
		
		//트리 형태 설정
		setTree(1,1,0,0);
		
		//점화식을 통한 부모 노드 설정
		fillParent();
		
		M = Integer.parseInt(br.readLine());
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int result = width[a] + width[b] - (width[LCA(a,b)]*2);
			System.out.println(result);
		}
	}
	
	public static void setTree(int c, int d, int p, int w) {
		depth[c] = d;
		width[c] = w;
		for (Node next : tree.get(c)) {
			if (next.next == p) continue;
			parent[next.next][0] = c;
			setTree(next.next, d+1, c, w+next.width);
		}
	}
	
	public static void fillParent() {
		for (int i=1;i<=maxDepth;i++) {
			for (int j=1;j<=N;j++) {
				parent[j][i] = parent[parent[j][i-1]][i-1];
			}
		}
	}
	
	//이분 탐색으로 최소 공통 조상 구하기
	public static int LCA(int a, int b) {
		int ah = depth[a];
		int bh = depth[b];
		
		if (ah<bh) {
			int tmp = b;
			b = a;
			a = tmp;
		}
		
		//깊이 동일하게 맞추기
		for (int i=maxDepth-1;i>=0;i--) {
			if (Math.pow(2, i) <= depth[a]-depth[b]) {
				a = parent[a][i];
			}
		}
		
		if (a==b) return a;
		
		for (int i=maxDepth-1;i>=0;i--) {
			if (parent[a][i] != parent[b][i]) {
				a = parent[a][i];
				b = parent[b][i];
			}
		}
		
		return parent[a][0];
	}

}