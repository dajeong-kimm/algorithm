import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Set<String> set = new HashSet<>();
		for (int i=0;i<N;i++) {
			String keyword = br.readLine();
			set.add(keyword);
		}
		
		for (int i=0;i<M;i++) {
			String[] arr = br.readLine().split(",");
			for (int j=0;j<arr.length;j++) {
				if (set.contains(arr[j])) {
					set.remove(arr[j]);
				}
			}
			sb.append(set.size()).append("\n");
		}
		
		System.out.println(sb);

	}

}
