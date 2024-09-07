import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 보석줍기
 * 
 * n개의 섬이 m개의 다리로 연결되어 있다.
 * 서로 다른 두 섬은 최대 한개의 다리로만 직접 연결되어 있다.
 * 각 다리마다 견딜 수 있는 무게의 제한이 있다.
 * 
 * 섬들 중 K(1<=K<=14)개의 서로 다른 섬에 각각 한 개씩 보석이 있다.
 * 1번 섬에서 빈손으로 출발하여 최대한 많은 보석을 줍고 1번 섬에 돌아오려고 한다.
 * 보석을 너무 많이 줍다보면 다리를 건널 때 다리가 무게를 견디지 못하고 무너질 수 있다.
 * 따라서 다리가 무너지지 않는 한도 내에서 보석을 주워야 한다.
 * 
 * 한 번 지난적 있는 다리와 섬을 여러번 지날 수 있다.
 * 보석이 있는 섬을 지날 때에 그 보석을 줍지 않을 수도 있다.
 * 
 * 
 * 주울 수 있는 보석의 최대 개수 출력
 * 
 * 보석을 주웠는지 안주웠는지를 비트마스킹으로 ,,
 * @author KOREA
 *
 */
public class Main {
	static int n,m,k;
	static ArrayList<Node> graph[];
	
	static int[] jewel;
	static int[] jewelIndex;
	static final int INF = Integer.MAX_VALUE;
	
	public static class Node {
		int to;
		int cost;
		
		Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}
	
	public static class State {
		int node; //현재 위치한 섬
		int jewels; //현재까지 주운 보석 상태 (비스마스킹)
		int weight; //현재까지 주운 보석의 개수
		
		State(int node, int jewels, int weight) {
			this.node = node;
			this.jewels = jewels;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); //섬의 개수
		m = Integer.parseInt(st.nextToken()); //다리의 개수
		k = Integer.parseInt(st.nextToken()); //보석이 있는 섬의 위치
		
		graph = new ArrayList[n+1];
		for (int i=0;i<=n;i++) {
			graph[i] = new ArrayList<>();
		}
		
		jewel = new int[k]; //보석이 위치한 섬 저장
		jewelIndex = new int[n+1]; //각 섬의 보석 인덱스 저장
		Arrays.fill(jewelIndex, -1);
		for (int i=0;i<k;i++) {
			jewel[i] = Integer.parseInt(br.readLine());
			jewelIndex[jewel[i]] = i;
		}
		
		
		for (int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new Node(b,c));
			graph[b].add(new Node(a,c));
		}
		//---------------------------------------------------
		
		bfs();
		

	}
	public static void bfs() {
		Queue<State> q = new LinkedList<>();
		boolean[][] visited = new boolean[n+1][1<<k];
		q.add(new State(1,0,0));
		visited[1][0] = true;
		int maxCnt = 0; //최대로 주울 수 있는 보석 개수
		
		while (!q.isEmpty()) {
			State cur = q.poll();
			
//			System.out.println("현재 노드: " + cur.node + ", 보석 상태: " + Integer.toBinaryString(cur.jewels) + ", 보석 개수: " + cur.weight);
			//1번 섬에 도착하면 보석을 몇 개 주웠는지 확인
			if (cur.node == 1) {
				maxCnt = Math.max(maxCnt, cur.weight);
			}
			
			for (Node next : graph[cur.node]) {
				if (cur.weight > next.cost) continue;
				
				//보석 안주웠을 때 방문하지 않았으면
				if (!visited[next.to][cur.jewels]) {
					visited[next.to][cur.jewels] = true;
					q.add(new State(next.to, cur.jewels, cur.weight));
				}
				
				//보석이 있다면 보석 줍기
				if (jewelIndex[next.to] != -1) {
					int nextJewel = cur.jewels | (1<<jewelIndex[next.to]);
					if (!visited[next.to][nextJewel]) {
						visited[next.to][nextJewel] = true;
						q.add(new State(next.to, nextJewel, Integer.bitCount(nextJewel)));
					}
				}
			}
		}
//		printArr(visited);
		System.out.println(maxCnt);
	}
	
	public static void printArr(boolean[][] visited) {
		for (int i=0;i<visited.length;i++) {
			for (int j=0;j<visited[0].length;j++) {
				if (visited[i][j]) System.out.print("O");
				else System.out.print(" ");
			}
			System.out.println();
		}
	}

}