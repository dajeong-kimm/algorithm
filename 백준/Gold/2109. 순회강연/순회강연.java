import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static int N;
	static List<Info> list = new ArrayList<>();
	
	static class Info implements Comparable<Info> {
		int p, d;
		
		Info(int p, int d) {
			this.p = p;
			this.d = d;
		}
		
		//강의료 높은 순서대로 (같으면 날짜도 높은거부터)
		@Override
		public int compareTo(Info o) {
			if (p == o.p) {
				return Integer.compare(o.d, d);
			}
			return Integer.compare(o.p, p);
		}
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			list.add(new Info(p, d));
		}
		
		Collections.sort(list);
		
		visited = new boolean[10001];
		int answer = 0;
		
		for (Info info : list) {
			int money = info.p;
			int day = info.d;
			
			for (int i=day;i>=1;i--) {
				if (!visited[i]) {
					visited[i] = true;
					answer += money;
					break;
				}
			}
			
		}
		System.out.println(answer);

	}

}