import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int to;
		int time;
		
		Node(int to, int time){
			this.to = to;
			this.time = time;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		//만나는 시간과 도로의 개수를 따로 저장해 줄 배열 
		int[] finishTime = new int[n+1];
		int[] inDegree = new int[n+1];
		
		List<Node> graph[] = new ArrayList[n+1];
		List<Node> reverse[] = new ArrayList[n+1];
		for (int i=0;i<=n;i++) {
			graph[i] = new ArrayList<>();
			reverse[i] = new ArrayList<>();
		}
		
		for (int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			inDegree[to]++;
			graph[from].add(new Node(to, t));
			reverse[to].add(new Node(from, t));
			
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());
		
		//시작지점 Queue에 넣기
		Queue<Integer> q = new ArrayDeque<>();
		q.add(start);
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (Node next : graph[cur]) {
				finishTime[next.to] = Math.max(finishTime[next.to], finishTime[cur]+next.time);
				inDegree[next.to]--;
				
				if (inDegree[next.to] == 0) {
					q.add(next.to);
				}
			}
		}
		
		//역방향 탐색 --> 임계경로의 간선 수 세기
		int cnt = 0;
		boolean[] visited = new boolean[n+1];
		q.add(to);
		visited[to] = true;
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (Node next : reverse[cur]) {
				//임계 경로 간선 조건
				if (finishTime[next.to] + next.time == finishTime[cur]) {
					cnt++;
					if (!visited[next.to]) {
						visited[next.to] = true;
						q.add(next.to);
					}
				}
			}
		}
		
//		System.out.println(Arrays.toString(finishTime));
		System.out.println(finishTime[to]);
		System.out.println(cnt);
		
	}

}
