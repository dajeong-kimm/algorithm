import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] road;
	static int[] cost;
	
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		road = new int[N-1];
		cost = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<N-1;i++) {
			road[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		answer = 0;
		int cur_cost = cost[0];
		for (int i=0;i<N-1;i++) {
			if (cost[i] < cur_cost) {
				cur_cost = cost[i];
			}
			answer += road[i]*cur_cost;
		}
		System.out.println(answer);
		

	}

}