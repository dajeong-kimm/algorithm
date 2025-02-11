import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, L;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		arr = new int[M+1];
		for (int i=1;i<=M;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			
		}
		
		for (int i=0;i<N;i++) {
			int cur = Integer.parseInt(br.readLine());
			
			int answer = 0;
			int start = 1;
			int end = L;
			while (start<=end) {
				int mid = (start+end)/2;
				
				int tmp = cur(mid);
//				System.out.println(mid+" "+tmp);
				if (tmp >= cur) {
					answer = mid;
					start = mid+1;
				}
				else {
					end = mid-1;
				}
			}
			System.out.println(answer);
		}

	}
	
	static int cur (int len) {
		int count = 0;
		int curLen = 0;
		int lastCut = 0;
		for (int i=1;i<=M;i++) {
			curLen += (arr[i] - arr[i-1]);
			if (curLen < len) continue;
			count++;
			lastCut = arr[i];
			curLen = 0;
		}
		
		if (L - lastCut <  len) count--;
		return count;
	}

}
