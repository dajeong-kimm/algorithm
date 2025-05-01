import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static List<Integer> graph[]; // 연결상태확인
	static Map<Integer, int[]> map = new HashMap<>(); //구간 정보 저장
	static int index = 1; //현재 구간 순서
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		//graph 초기화
		graph = new ArrayList[N+1];
		for (int i=0;i<=N;i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			if (num == 1) { //추가
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map.put(index, new int[] {x,y});
				setGraph(x,y);
				index++;
				
			} else { //쿼리
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				sb.append(isConnected(a,b)).append("\n");
			}
		}
		System.out.println(sb);
	}
	
	static void setGraph(int x, int y) {
		for (int i=1;i<index;i++) {
			int[] xy = map.get(i);
			
			//(x,y)에서 xy로 이동가능하다면?
			if ((xy[0]<x && x<xy[1]) || (xy[0]<y && y<xy[1])) {
				graph[index].add(i);
			}
			
			//(xy)에서 (x,y)로 이동가능하다면?
			if ((x<xy[0] && xy[0]<y) || (x<xy[1] && xy[1]<y)) {
				graph[i].add(index);
			}
		}
	}
	
	static int isConnected(int a, int b) {
		boolean[] visited = new boolean[N+1];
		Queue<Integer> q = new ArrayDeque<>();
		visited[a] = true;
		q.add(a);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if (cur == b) return 1;
			
			for (int next : graph[cur]) {
				if (!visited[next]) {
					visited[next] = true;
					q.add(next);
				}
			}
		}
		return 0;
	}

}
