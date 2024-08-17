import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * 길이 L의 시작 이진수 -> 길이 K의 목표 이진수
 * 최소 동작 횟수 구하기
 * 
 * 1. 한 자리 숫자를 보수로 바꾸기 (맨 앞 숫자는 바꿀 수 없음)
 * 2. 현재 수에 1 더하기
 * 3. 현재 수에서 1 빼기
 * 
 * 이진수의 길이는 최대 10 --> 2^10 = 1024
 * 이를 정점으로 생각해서 그래프 탐색 알고리즘 사용
 * @author KOREA
 *
 */
public class Main {
	static String start, end;
	static int s,e;
	
	static int answer;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		start = br.readLine();
		end = br.readLine();
		
		s = Integer.parseInt(start,2);
		e = Integer.parseInt(end,2);
		
		answer = bfs(s,e);
		System.out.println(answer);
		

	}
	private static int bfs(int s, int e) {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.add(s);
		int[] dist = new int[1024];
		Arrays.fill(dist, -1);
		dist[s] = 0;
		
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			int range = 9;
			
			//가장 높은 비트가 1인 위치 찾기
			while (range-1>=0 && (cur&(1<<range))==0) range--;
			
			// 0부터 range까지 모든 비트를 하나씩 뒤집어가며 다음 노드 탐색
			for (int i=0;i<range;i++) {
				int new_num = cur ^ (1<<i);
				if (dist[new_num] == -1) {
					queue.add(new_num);
					dist[new_num] = dist[cur]+1;
				}
			}
			
			if (cur+1<1024 && dist[cur+1]==-1) {
				queue.add(cur+1);
				dist[cur+1] = dist[cur]+1;
			}
			
			if (cur-1>=0 && dist[cur-1]==-1) {
				queue.add(cur-1);
				dist[cur-1] = dist[cur]+1;
			}
		}
		
		return dist[e];
	}
	

}