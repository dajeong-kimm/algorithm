import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		boolean[] sum = new boolean[800001];
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for (int i=0;i<n;i++) {
			for (int j=i+1;j<n;j++) {
				int cur = arr[i]+arr[j];
				int target = w - cur;
				
				if (cur >= w) continue;
				
				if (sum[target]) {
					System.out.println("YES");
					return;
				}
				
			}
			for (int j=0;j<i;j++) {
				sum[arr[i]+arr[j]] = true;
			}
		}
		
		System.out.println("NO");
	}

}