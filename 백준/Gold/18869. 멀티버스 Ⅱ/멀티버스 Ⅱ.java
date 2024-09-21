import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 멀티버스 2
 * 
 * M개의 우주가 있고, 각 우주에는 1~N까지 번호가 매겨진 행성이 N개
 * 행성의 크기를 알고 있을때, 균등한 우주의 쌍이 몇 개인지 구하기
 * 구성이 같은데 순서만 다른 우주의 쌍은 한 번만 세기
 * 
 * 우주의 개수 M, 우주에 있는 행성의 개수 N
 * @author KOREA
 *
 */
public class Main {
	static int M,N;
	static int answer;
	static List<List<Integer>> spaces = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			List<Integer> space = new ArrayList<>();
			Set<Integer> set = new HashSet<>();
			
			for (int j=0;j<N;j++) {
				int planet = Integer.parseInt(st.nextToken());
				set.add(planet);
				space.add(planet);
			}
			
			List<Integer> clone = new ArrayList<>(set);
			Collections.sort(clone);
			
			for (int j=0;j<N;j++) {
				int idx = Collections.binarySearch(clone, space.get(j));
				
				space.set(j, idx);
			}
			
			spaces.add(space);
		}
		
		answer = 0;
		
		for (int i=0;i<M;i++) {
			for (int j=i+1;j<M;j++) {
				if (Arrays.equals(spaces.get(i).toArray(), spaces.get(j).toArray())) {
					answer++;
				}
			}
		}
		
		System.out.println(answer);
	}

}