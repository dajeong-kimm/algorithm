import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N,M,LOG;
	static List<Integer> tree[];
	//parent[node][j] : node의 2^j번째 부모
	static int[][] parent; 
	static int[] depth;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		LOG = (int) (Math.log(N) / Math.log(2)) + 1;
		
		tree = new ArrayList[N+1];
		parent = new int[N+1][LOG];
		depth = new int[N+1];
		
		for (int i=1;i<=N;i++) {
			tree[i] = new ArrayList<>();
		}
		
		for (int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			tree[a].add(b);
			tree[b].add(a);
		}
		
		//DFS로 depth와 직속 부모 설정
		dfs(1,0);
		
		//Binary Lifting 전처리
		for (int j=1;j<LOG;j++) {
			for (int i=1;i<=N;i++) {
				if (parent[i][j-1] != 0) {
					parent[i][j] = parent[parent[i][j-1]][j-1];
				}
			}
		}
		
		M = Integer.parseInt(br.readLine());
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(lca(a,b)).append("\n");
		}
		System.out.println(sb);
	}
	static void dfs(int node, int par) {
		depth[node] = depth[par]+1;
		parent[node][0] = par;
		
		for (int next : tree[node]) {
			if (next != par) {
				dfs(next, node);
			}
		}
		
		
	}
	
	static int lca(int u, int v) {
		//깊이가 더 깊은 쪽을 u로 설정
		if (depth[u] < depth[v]) {
			int tmp = u;
			u = v;
			v = tmp;
		}
		
		//u와 v의 깊이 맞추기
		for (int j=LOG-1;j>=0;j--) {
			if (depth[u] - (1<<j) >= depth[v]) {
				u = parent[u][j];
			}
		}
		
		if (u == v) return u;
		
		//공통 조상을 찾기 직전까지 끌어올리기
		for (int j=LOG-1;j>=0;j--) {
			if (parent[u][j] != parent[v][j]) {
				u = parent[u][j];
				v = parent[v][j];
			}
		}
		
		return parent[u][0];
	}
		
}
