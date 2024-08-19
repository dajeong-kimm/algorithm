import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 공평하게 선거구를 나누기 위해
 * 두 선거구에 포함된 인구의 차이를 최소로 함
 * 
 * 백준시의 정보가 주어졌을 때 인구 차이의 최솟값 구하기
 * @author KOREA
 *
 */
public class Main {
	static int N;
	static int[] people;
	
	static boolean[][] graph;
	
	static int total_people;
	
	static ArrayList<Integer> a_list;
	static ArrayList<Integer> b_list;
	
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		people = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i=1;i<=N;i++) {
			people[i] = Integer.parseInt(st.nextToken());
			total_people += people[i];
		}
		
		graph = new boolean[N+1][N+1];
		
		for (int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for (int j=0;j<num;j++) {
				int tmp = Integer.parseInt(st.nextToken());
				graph[i][tmp] = true;
				graph[tmp][i] = true;
			}
		}
		
		answer = Integer.MAX_VALUE;
		
		for (int i=1;i<(1<<N)-1;i++) {
			a_list = new ArrayList<>();
			b_list = new ArrayList<>();
			for (int j=0;j<N;j++) {
				if ((i&(1<<j)) != 0) {
					a_list.add(j+1);
				} else {
					b_list.add(j+1);
				}
			}
			
			 // 최소 하나의 원소를 가져야 한다는 조건 확인
//		    if (a_list.isEmpty() || b_list.isEmpty()) {
//		        continue; // 이 경우는 무시하고 다음 경우로 넘어감
//		    }
		    
			if (is_connected()) {
				int a = get_total(a_list);
				int b = get_total(b_list);
				answer = Math.min(answer, Math.abs(a-b));
			}
		}
		
		if (answer == Integer.MAX_VALUE) answer = -1;
		System.out.println(answer);
	}
	
	private static int get_total(ArrayList<Integer> list) {
		int total = 0;
		for (int i : list) {
			total += people[i];
		}
		return total;
	}
	
	private static boolean is_connected() {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1];
		queue.add(a_list.get(0));
		visited[a_list.get(0)] = true;
		
		while (!queue.isEmpty()) {
			int node = queue.poll();
			
			for (int i : a_list) {
				if (graph[i][node] == true && !visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
		int a_count = 0;
		for (int i=0;i<=N;i++) {
			if (visited[i]) a_count++;
		}
		boolean flagA = (a_count == a_list.size()) ? true : false;
		
		queue = new ArrayDeque<>();
		visited = new boolean[N+1];
		queue.add(b_list.get(0));
		visited[b_list.get(0)] = true;
		
		while (!queue.isEmpty()) {
			int node = queue.poll();
			for (int i : b_list) {
				if (graph[i][node] == true && !visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
		int b_count = 0;
		for (int i=0;i<=N;i++) {
			if (visited[i]) b_count++;
		}
		boolean flagB = (b_count == b_list.size()) ? true : false;
		
		return (flagA && flagB);
	}

}