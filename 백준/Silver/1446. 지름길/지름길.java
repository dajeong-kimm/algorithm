import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Road implements Comparable<Road> {
		int from, to, len;
		
		Road(int from, int to, int len) {
			this.from = from;
			this.to = to;
			this.len = len;
		}
		
		@Override
		public int compareTo(Road o) {
			return Integer.compare(to, o.to);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[D+1];
		for (int i=1;i<=D;i++) {
			dp[i] = i;
		}
		
		List<Road> list = new ArrayList<>();
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			
			if (to > D) continue;
			if ((to-from) <= len) continue;
			
			list.add(new Road(from, to, len));
		}
		
		Collections.sort(list);
		
		for (int i=1;i<=D;i++) {
			dp[i] = Math.min(dp[i], dp[i-1]+1);
			for (Road road : list) {
				if (road.from == (i-1)) {
					dp[road.to] = Math.min(dp[road.to], dp[road.from]+road.len);
				}
			}
		}
		
		System.out.println(dp[D]);
	}

}
