import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * 백조의 호수
 * 
 * X는 빙판 .은 물 L은 백조
 * 며칠이 지나야 백조들이 만날 수 있는지
 * 
 * 1. 다음 큐와 현재 큐 사이즈만큼만 BFS를 수행
 * (매번 처음부터 탐색을 수행하는 것이 아니라 이전에 탐색을 중지한 시점에서 이어서 진행)
 * 2. 백조의 탐색을 위한 탐색 큐
 * 다음 탐색 지점을 저장하였다가 탐색 큐와 순환시킬 다음 큐
 * 얼음에 인접한 물을 담고 있는 원터 큐
 * @author KOREA
 *
 */
public class Main {
	static class Node {
		int x, y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static ArrayDeque<Node> queue;
	static ArrayDeque<Node> waterQueue;
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	
	static char[][] map;
	static boolean[][] visited;
	static Node[] swan;
	static int N,M;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		waterQueue = new ArrayDeque<>();
		queue = new ArrayDeque<>();
		swan = new Node[2];
		map = new char[N][M];
		visited = new boolean[N][M];
		
		int idx = 0;
		for (int i=0;i<N;i++) {
			char[] line = br.readLine().toCharArray();
			for (int j=0;j<M;j++) {
				map[i][j] = line[j];
				if (map[i][j] == 'L') swan[idx++] = new Node(i,j);
				if (map[i][j] != 'X') waterQueue.add(new Node(i,j));
			}
		}
		
		//출발점이 되는 백조
		queue.add(swan[0]);
		visited[swan[0].x][swan[0].y] = true;
		
		int day = 0;
		boolean meet = false;
		
		while (true) {
			ArrayDeque<Node> nextQueue = new ArrayDeque<>();
			while (!queue.isEmpty()) {
				Node now = queue.poll();
				
				if (now.x == swan[1].x && now.y == swan[1].y) {
					meet = true;
					break;
				}
				
				for (int i=0;i<4;i++) {
					int nx = now.x + dx[i];
					int ny = now.y + dy[i];
					
					if (nx<0 || nx>=N || ny<0 || ny>=M || visited[nx][ny]) continue;
					
					visited[nx][ny] = true;
					if (map[nx][ny] == 'X') {
						nextQueue.add(new Node(nx,ny));
						continue;
					}
					queue.add(new Node(nx,ny));
				}
			}
			
			if (meet) break;
			
			//Queue를 다음 날 탐색할 지역이 담긴 nextQueue로 바꾼다.
			queue = nextQueue;
			
			int size = waterQueue.size();
			
			for (int i=0;i<size;i++) {
				Node now = waterQueue.poll();
				
				for (int d=0;d<4;d++) {
					int nx = now.x + dx[d];
					int ny = now.y + dy[d];
					
					if (nx<0 || nx>=N || ny<0 || ny>=M) continue;
					
					if (map[nx][ny] == 'X') {
						map[nx][ny] = '.';
						waterQueue.add(new Node(nx,ny));
					}
				}
			}
			day++;
		}
		
		System.out.println(day);

	}

}