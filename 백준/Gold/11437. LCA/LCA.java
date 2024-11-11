import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N,M,LOG;
	static List<Integer> tree[];
	static int[][] parent;
	static int[] depth;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		tree= new ArrayList[N+1];
		for (int i=0;i<=N;i++) {
			tree[i] = new ArrayList<>();
		}
		
		LOG = (int) (Math.log(N) / Math.log(2)) + 1;
		parent = new int[N+1][LOG];
		depth = new int[N+1];
		
		for (int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			tree[a].add(b);
			tree[b].add(a);
		}
		
		dfs(1,0);
		
		//binary lifting 전처리
		for (int j=1;j<LOG;j++) {
			for (int i=1;i<=N;i++) {
				if (parent[i][j-1] != 0) {
					parent[i][j] = parent[parent[i][j-1]][j-1];
				}
			}
		}
		
		M = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
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
		if (depth[u] < depth[v]) {
			int tmp = u;
			u = v;
			v = tmp;
		}
		
		for (int j=LOG-1;j>=0;j--) {
			if (depth[u] - (1<<j) >= depth[v]) {
				u = parent[u][j];
			}
		}
		
		if (u == v) return u;
		
		for (int j=LOG-1;j>=0;j--) {
			if (parent[u][j] != parent[v][j]) {
				u = parent[u][j];
				v = parent[v][j];
			}
		}
		
		return parent[u][0];
	}

}
