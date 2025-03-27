import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Main {
	static char[][] arr = new char[5][5];
	static Set<Integer> set = new HashSet<>();
	static Set<Integer> visited;
	
	static int[] dist = {5, -5, 1, -1};
	
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i=0;i<5;i++) {
			String input = br.readLine();
			for (int j=0;j<5;j++) {
				arr[i][j] = input.charAt(j);
			}
		}
		
		visited = new HashSet<>();
		combiSeven(0, 0);
		System.out.println(answer);
		
	}
	
	static void combiSeven(int cur, int cnt) {
		if (cnt == 7) {
			if (moreFour() && isConnected()) {
//				for (int num : visited) {
//					System.out.print(num+" ");
//				}
//				System.out.println();
				answer++;
			}
			return;
		}
		
		for (int i=cur;i<25;i++) {
			visited.add(i);
			combiSeven(i+1, cnt+1);
			visited.remove(i);
		}
	}
	static boolean isConnected() {
		Queue<Integer> q = new ArrayDeque<>();
		Set<Integer> visit = new HashSet<>();
		for (int i=0;i<25;i++) { //BFS의 시작점 정하기
			if (visited.contains(i)) {
				q.add(i);
				visit.add(i);
				break;
			}
		}
		
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			int x = cur/5;
			int y = cur%5;
			
			for (int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx<0 || nx>=5 || ny<0 || ny>=5) continue;
				
				int newCur = nx*5 + ny;
				if (visited.contains(newCur) && !visit.contains(newCur)) {
					q.add(newCur);
					visit.add(newCur);
				}
			}
		}
		if (visit.size() == 7) return true;
		return false;
	}
	
	static boolean moreFour() {
		int S = 0;
		int Y = 0;
		for (int num : visited) {
			int x = num/5;
			int y = num%5;
			if (arr[x][y] == 'S') S++;
			else Y++;
		}
		
		if (S >= 4) return true;
		return false;
	}
	

}
