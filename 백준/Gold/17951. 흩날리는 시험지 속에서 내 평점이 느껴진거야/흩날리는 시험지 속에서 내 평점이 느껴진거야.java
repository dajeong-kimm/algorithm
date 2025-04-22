import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int end = 20*N;
		
//		System.out.println(getScore(79));
		int answer = 0;
		
		while (start<=end) {
			int mid = (start+end)/2;
//			System.out.println(mid+" "+getScore(mid));
			
			if (getScore(mid)) {
				answer = mid;
				start = mid+1;
			} else {
				end = mid-1;
			}
			
		}
		
		System.out.println(answer);
	}
	
	static boolean getScore(int score) {
		int split = 1;
		int curScore = 0;
		
		for (int i=0;i<N;i++) {
			if ((curScore+arr[i]) < score) {
				curScore += arr[i];
			} else {
				split++;
				curScore = 0;
			}
		}
		
		if (curScore < score) split--;
		
//		System.out.println(split);
		if (split < K) return false;
		return true;
	}

}
