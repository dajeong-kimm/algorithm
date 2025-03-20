import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] candy = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i=1;i<=N;i++) {
			candy[i] = Integer.parseInt(st.nextToken());
		}
		
		parent = new int[N+1];
		for (int i=1;i<=N;i++) {
			parent[i] = i;
		}
		
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a,b);
		}
		
		Map<Integer, Integer> mapCandy = new HashMap<>();
		Map<Integer, Integer> mapPeople = new HashMap<>();
		for (int i=1;i<=N;i++) {
			int p = find(i);
			if (!mapCandy.containsKey(p)) {
				mapCandy.put(p, 0);
				mapPeople.put(p, 0);
				
			}
			mapCandy.put(p, mapCandy.get(p)+candy[i]);
			mapPeople.put(p, mapPeople.get(p)+1);
		}
		
		int size = mapCandy.size();
		List<int[]> list = new ArrayList<>();
		for (int p : mapCandy.keySet()) {
			int candyCnt = mapCandy.get(p);
			int peopleCnt = mapPeople.get(p);
//			System.out.println(peopleCnt+" "+candyCnt);
			list.add(new int[]{candyCnt, peopleCnt});
		}
		
		int[][] dp = new int[size+1][K];
		for (int i=1;i<=size;i++) {
			int[] cur = list.get(i-1);
			int curCandy = cur[0];
			int curPeople = cur[1];
			
			for (int j=1;j<K;j++) {
				dp[i][j] = dp[i-1][j];
				if ((j-curPeople >= 0)) {
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-curPeople]+curCandy);
				}
			}
		}
		System.out.println(dp[size][K-1]);

	}
	
	static int find(int x) {
		if (x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
	
	static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if (pa == pb) return false; 
		
		if(pa < pb) {
			parent[pb] = pa;
		} else {
			parent[pa] = pb;
		}

		return true;
	}
}
