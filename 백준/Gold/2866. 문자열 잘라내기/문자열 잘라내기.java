import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static char[][] arr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[R][C];
		for (int i=0;i<R;i++) {
			String input = br.readLine();
			for (int j=0;j<C;j++) {
				arr[i][j] = input.charAt(j);
			}
		}
		
		int start = 0;
		int end = R-1;
		int count = 0;
		while (start<=end) {
			int mid = (start+end)/2;
			
			if (func(mid)) {
				start = mid+1;
				count = mid;
			} else {
				end = mid-1;
			}
		}
		System.out.println(count);
	}
	
	static boolean func(int deleteCnt) {
		Set<String> set = new HashSet<>();
		for (int j=0;j<C;j++) {
			StringBuilder sb = new StringBuilder();
			for (int i=deleteCnt;i<R;i++) {
				sb.append(arr[i][j]);
			}
			if (set.contains(sb.toString())) return false;
			set.add(sb.toString());
		}
		return true;
	}

}
