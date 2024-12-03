import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] energy;
	static List<int[]> edge[];
	static int number;
	static int[][] parents; //parents[node][j] : node의 2^j번째 부모와 해당 경로의 비용
	static int[][] costs;
	static int[] depth;
	
	static int D;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		energy = new int[n];
		for (int i=0;i<n;i++) {
			energy[i] = Integer.parseInt(br.readLine());
		}
		
		edge = new ArrayList[n+1];
		for (int i=0;i<=n;i++) {
			edge[i] = new ArrayList<>();
		}
		
		for (int i=0;i<n-1;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edge[a].add(new int[] {b,c});
			edge[b].add(new int[] {a,c});
		}
		
		D = (int) (Math.log(100_000) / Math.log(2) +1);
		parents = new int[n+1][D];
		costs = new int[n+1][D];
		depth = new int[n+1];
		
		StringBuilder sb = new StringBuilder();
		sb.append(1).append("\n");
		
		dfs(1,0); //초기 부모 관계 설정
		
		init();
		
		for (int i=2;i<=n;i++) {
			sb.append(search(i, energy[i-1])).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int node, int parent) {
		for (int[] next: edge[node]) {
			int nextNode = next[0];
			int cost = next[1];
			
			if (nextNode != parent) {
				parents[nextNode][0] = node;
				costs[nextNode][0] = cost;
				depth[nextNode] = depth[node]+1;
				dfs(nextNode, node);
			}
		}
	}
	
	//희소 테이블 초기화
	static void init() {
		for (int j=1;j<D;j++) {
			for (int i=1;i<=n;i++) {
				int midParent = parents[i][j-1];
				
				if (midParent != 0) {
					parents[i][j] = parents[midParent][j-1];
					costs[i][j] = costs[i][j-1] + costs[midParent][j-1];
				}
			}
		}
	}
	
	static int search(int node, int curEnergy) {
		for (int j=D-1;j>=0;j--) {
			if (parents[node][j] != 0 && costs[node][j] <= curEnergy) {
				curEnergy -= costs[node][j];
				node = parents[node][j];
			}
		}
		
		return node;
	}

}