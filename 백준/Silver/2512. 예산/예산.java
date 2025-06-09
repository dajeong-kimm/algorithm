import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		int start = 0;
		int end = 0;
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			end = Math.max(end, arr[i]);
		}
		M = Integer.parseInt(br.readLine());
		
		int answer = 0;
		while (start <= end) {
			int mid = (start+end)/2;
			
			if (isAvail(mid)) {
				answer = mid;
				start = mid+1;
			} else {
				end = mid-1;
			}
		}
		System.out.println(answer);
	}
	
	static boolean isAvail(int money) {
		int curMoney = 0;
		for (int i=0;i<N;i++) {
			if (arr[i] <= money) {
				curMoney += arr[i];
			} else {
				curMoney += money;
			}
			if (curMoney > M) return false;
		}
		return true;
	}

}
