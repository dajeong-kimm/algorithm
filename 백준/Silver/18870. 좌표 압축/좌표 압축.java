import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 좌표 압축 (coordinate compression)
 * 
 * @author KOREA
 *
 */
public class Main {
	static int N;
	static int[] arr;
	static int[] sorted;
	
	static HashMap<Integer, Integer> rankMap = new HashMap<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		sorted = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			arr[i] = sorted[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(sorted);
		int rank = 0;
		for (int s : sorted) {
			if (!rankMap.containsKey(s)) {
				rankMap.put(s, rank);
				rank++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int a : arr) {
			int ranking = rankMap.get(a);
			sb.append(ranking).append(' ');
		}
		System.out.println(sb);
	}

}