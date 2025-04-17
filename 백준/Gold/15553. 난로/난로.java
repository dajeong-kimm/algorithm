import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static List<Integer> interval = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for (int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int start = arr[0];
		int end = arr[N-1];
		long answer = end+1-start;
		if (K == 1) {
			System.out.println(answer);
			return;
		}
		
		int availCnt = K-1;
		for (int i=1;i<N;i++) {
			interval.add(arr[i]-arr[i-1]-1);
		}
		
		Collections.sort(interval, Collections.reverseOrder());
//		for (int i=0;i<interval.size();i++) {
//			System.out.print(interval.get(i)+" ");
//		}
//		System.out.println();
		for (int i=0;i<availCnt;i++) {
			answer -= interval.get(i);
//			System.out.println(answer+" "+interval.get(i));
		}
		System.out.println(answer);
	}

}
