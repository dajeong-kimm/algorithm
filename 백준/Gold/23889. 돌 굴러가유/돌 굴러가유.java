import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static int[] X;
	static int[] rock;
	
	static class Rock implements Comparable<Rock> {
		int where;
		long broken;
		
		Rock(int where, long broken) {
			this.where = where;
			this.broken = broken;
		}
		
		@Override
		public int compareTo(Rock o) {
			if (broken == o.broken) {
				return Integer.compare(where, o.where);
			}
			return Long.compare(o.broken, broken);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		X = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i=1;i<=N;i++) {
			X[i] = Integer.parseInt(st.nextToken());
		}
		
		long[] sumX = new long[N+1];
		for (int i=1;i<=N;i++) {
			sumX[i] = sumX[i-1]+X[i];
		}
		
		rock = new int[K];
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<K;i++) {
			rock[i] = Integer.parseInt(st.nextToken());
		}
		
		List<Rock> list = new ArrayList<>();
		long demage;
		//중간지점
		for (int i=0;i<K-1;i++) {
			demage = sumX[rock[i+1]-1] - sumX[rock[i]-1];
			list.add(new Rock(rock[i], demage));
		}
		
		//끝지점 (rock[K-1] ~ N)
		demage = sumX[N] - sumX[rock[K-1]-1];
		list.add(new Rock(rock[K-1], demage));
		
		Collections.sort(list);
		List<Integer> answer = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<M;i++) {
			answer.add(list.get(i).where);
		}
		Collections.sort(answer);
		for (int i=0;i<M;i++) {
			sb.append(answer.get(i)).append("\n");
		}
		System.out.println(sb);
	}

}
