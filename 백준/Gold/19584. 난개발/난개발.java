import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * 난개발
 * 
 * 철거될 도로들의 통행량의 합이 가장 큰 곳에 철길 놓기
 * 
 * 외계인들이 어디에 10호선을 지을지 예상
 * 
 * y축으로 압축해서 누적합이 가장 큰 곳 구하기
 * @author KOREA
 *
 */
public class Main {
	static int N,M;
	static int[] arr;
	//특정 y에서 더해질 통행량
	static HashMap<Integer, Long> plus = new HashMap<>();
	//특정 y에서 빼야할 통행량
	static HashMap<Integer, Long> minus = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		TreeSet<Integer> set = new TreeSet<>();
		Long big = 0L; //현재 y에서 통행량 누적합
		Long ans = 0L; //통행량의 최대값을 저장
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //주요 장소 N개의 직교 좌표계상 좌표
		M = Integer.parseInt(st.nextToken()); //도로 총 M개의 정보
		
		arr = new int[N+1];
		for (int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			arr[i] = y;
			set.add(y);
		}
		
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			Long cost = Long.parseLong(st.nextToken());
			
			//선로의 시작점과 끝점을 비교하여 작은 값에서 큰 값으로 연결
			if (arr[from] <= arr[to]) {
				plus.put(arr[from], plus.getOrDefault(arr[from], 0L) + cost);
				minus.put(arr[to], minus.getOrDefault(arr[to], 0L)+cost);
			}
			else {
				minus.put(arr[from], minus.getOrDefault(arr[from], 0L) + cost);
				plus.put(arr[to], plus.getOrDefault(arr[to], 0L)+cost);
			}
		}
		
		//모든 y에 대해 계산
		for (Integer t : set) {
			big += plus.getOrDefault(t, 0L);
			if (ans <= big) {
				ans = big;
			}
			big -= minus.getOrDefault(t, 0L);
		}
		
		System.out.println(ans);
		
		
	}

}