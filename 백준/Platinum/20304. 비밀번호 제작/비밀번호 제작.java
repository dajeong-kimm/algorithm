import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 비밀전호 제작
 * 0~N 이하의 정수 중 하나를 사용 
 * 두 비밀번호의 안전 거리 : 이진법으로 표현한 두 비밀번호의 서로 다른 자리의 개수
 * 
 * 어떤 비밀번호의 안전도 : 지금까지 로그인 시도에 사용된 모든 비밀번호와의 안전 거리중 최솟값
 * 
 * 안전도가 제일 높은 비밀번호의 안전도 구하기
 * @author KOREA
 *
 */
public class Main {
	static int N,M;
	static int[] arr;
	static boolean[] visited;
	static int[] distance; //각 비밀번호의 안전도 (최소 거리)

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		visited = new boolean[N+1];
		distance = new int[N+1]; //각 비밀번호의 최소 안전 거리
		
		Queue<Integer> q = new LinkedList<>(); //해커가 사용한 비밀번호 리스트
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<M;i++) {
			int num = Integer.parseInt(st.nextToken());
			q.add(num);
			visited[num] = true;
		}
		
		//BFS
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			//현재 비밀번호와 비트가 1만큼 다른 비밀번호를 탐색
			for (int i=0;i<20;i++) { //최대 2^20까지 비밀번호 가능
				int next = cur ^ (1<<i); //XOR 연산을 통해 비트가 1 다른 비밀번호 생성
				if (next <= N && !visited[next]) {
					visited[next] = true;
					distance[next] = distance[cur] + 1; //안전거리 갱신
					q.add(next);
				}
			}
		}
		
		//가장 큰 안전도 찾기
		int max = 0;
		for (int i=0;i<=N;i++) {
			max = Math.max(max, distance[i]);
		}
		System.out.println(max);
		
		
	}

}