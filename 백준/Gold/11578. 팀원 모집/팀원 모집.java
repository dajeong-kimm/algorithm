import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 모든 문제를 풀 수 있는 팀
 * 최소한의 팀원으로 대회 우승
 * 
 * 모든 문제를 풀 수 있으면서 팀원의 수가 가장 적은 팀 --> 팀원의 수 출력
 * 모든 문제를 풀 수 있는 팀을 만들 수 없다면 -1 출력
 * @author KOREA
 *
 */
public class Main {
	static int N,M;
	static ArrayList<ArrayList<Integer>> list;
	
	static boolean[] problem;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //문제의 수
		M = Integer.parseInt(st.nextToken()); // 학생들의 수
		
		problem = new boolean[N+1];
		
		list = new ArrayList<>();
		for (int i=0;i<=M;i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i=1;i<=M;i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for (int j=0;j<num;j++) {
				list.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}
		int answer = Integer.MAX_VALUE;
		
		for (int i=1;i<(1<<M);i++) {
			problem = new boolean[N+1];
			int team_cnt = 0;
			// j : 포함하려는 팀원의 번호
			for (int j=1;j<=M;j++) {
				if ((i&(1<<j-1)) != 0) {
					team_cnt++;
					ArrayList<Integer> tmp_list = list.get(j);
					for (int x=0;x<tmp_list.size();x++) {
						int tmp = tmp_list.get(x);
						problem[tmp] = true;
					}
				}
			}
			boolean flag = true;
			for (int x=1;x<=N;x++) {
				if (!problem[x]) {
					flag = false;
					break;
				}
			}
			if (flag) {
				answer = Math.min(answer, team_cnt);
			}
			
		}
		
		if (answer == Integer.MAX_VALUE) answer = -1;
		System.out.println(answer);
	}
	

}