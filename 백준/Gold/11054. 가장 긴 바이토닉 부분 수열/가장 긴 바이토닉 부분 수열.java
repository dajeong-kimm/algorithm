import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int[] r_arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			r_arr[N-1-i] = arr[i];
		}
		
		int[] increase = new int[N];
		int[] decrease = new int[N];
		
		Arrays.fill(increase, 1);
		Arrays.fill(decrease, 1);
		
		for (int i=1;i<N;i++) {
			for (int j=0;j<i;j++) {
				if (arr[j] < arr[i]) {
					increase[i] = Math.max(increase[i], increase[j]+1);
				}
			}
		}
		
		for (int i=1;i<N;i++) {
			for (int j=0;j<i;j++) {
				if (r_arr[j] < r_arr[i]) {
					decrease[i] = Math.max(decrease[i], decrease[j]+1);
				}
			}
		}
		
		int answer = 0;
		for (int i=0;i<N;i++) {
			int tmp = increase[i] + decrease[N-1-i] -1 ;
			answer = Math.max(answer, tmp);
		}
		System.out.println(answer);

	}
	

}