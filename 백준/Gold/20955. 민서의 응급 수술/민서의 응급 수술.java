import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		for (int i=1;i<=N;i++) {
			parent[i] = i;
		}
		
		int answer = 0;
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (!union(a,b)) answer++; //이미 연결되어 있으면 끊기
		}
		
		//덩어리 -1 개 만큼 연결해야함
		Set<Integer> set = new HashSet<>();
		for (int i=1;i<=N;i++) {
			set.add(find(i));
		}
		answer += (set.size()-1);
		System.out.println(answer);
	}
	
	static int find(int x) {
		if (x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
	
	static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if (pa == pb) return false;
		
		if (pa<pb) {
			parent[pb] = pa;
		} else {
			parent[pa] = pb;
		}
		return true;
	}

}
