import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N];
		Arrays.fill(dp, 1);
		
		List<List<Integer>> list = new ArrayList<>();
		
		for (int i=0;i<N;i++) {
			List<Integer> tmp = new ArrayList<>();
			tmp.add(arr[i]);
			list.add(tmp);
		}
		
		for (int i=1;i<N;i++) {
			for (int j=0;j<i;j++) {
				if (arr[i] > arr[j]) {
					if (dp[i] < dp[j]+1) {
						dp[i] = dp[j]+1;
						list.set(i, new ArrayList<>(list.get(j)));
						list.get(i).add(arr[i]);
					}
				}
			}
		}
		
		int max_value = 0;
		int max_idx = -1;
		
		for (int i=0;i<N;i++) {
			if (dp[i] > max_value) {
				max_value = dp[i];
				max_idx = i;
			}
		}
		
		System.out.println(max_value);
		for (int num : list.get(max_idx)) {
			System.out.print(num+" ");
		}

	}

}