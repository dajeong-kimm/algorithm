import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	static class descend implements Comparator<String>{
		@Override
		public int compare(String a, String b) {
			if (a.length() == b.length()) {
				return b.compareTo(a);
			}
			return b.length() - a.length();

		}
	}
	
	static class descend2 implements Comparator<String>{
		@Override
		public int compare(String a, String b) {
			String A = a+b;
			String B = b+a;
			return B.compareTo(A);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		String[] arr = new String[K];
		String[] arr2 = new String[N];
		
		for (int i=0;i<K;i++) {
			arr[i] = br.readLine();
		}
		
		//길이를 기준으로 내림차순
		Arrays.sort(arr, new descend());
		
		for (int i=0;i<K;i++) {
			arr2[i] = arr[i];
		}
		
		for (int i=K;i<N;i++) {
			arr2[i] = arr[0];
		}
		
		//붙였을 때 더 큰 순으로 내림차순
		Arrays.sort(arr2, new descend2());
		
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<N;i++) {
			sb.append(arr2[i]);
		}
		System.out.println(sb);
	}

}