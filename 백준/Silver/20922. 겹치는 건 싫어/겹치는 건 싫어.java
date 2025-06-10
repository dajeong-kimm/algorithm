import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 0;
		Map<Integer, Integer> map = new HashMap<>();
		int answer = 0;
		while (end<N) {
			if (!map.containsKey(arr[end])) {
				map.put(arr[end], 0);
			}
			if (map.get(arr[end]) >= K) {
				map.put(arr[start], map.get(arr[start])-1);
				start++;
			} else {
				map.put(arr[end], map.get(arr[end])+1);
				end++;
				answer = Math.max(answer, (end-start));
			}
		}
		System.out.println(answer);

	}

}
