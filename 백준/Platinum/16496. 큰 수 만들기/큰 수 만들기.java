import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static class Number implements Comparable<Number> {
		String num;
		
		Number(String num) {
			this.num = num;
		}
		
		@Override
		public int compareTo(Number o) {
			String a = num + o.num;
			String b = o.num + num;
			
			return b.compareTo(a);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
//		String[] arr = new String[N];
		Number[] arr = new Number[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			arr[i] = new Number(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		String answer = "";
		for (int i=0;i<N;i++) {
			answer += arr[i].num;
		}
		
		if (answer.startsWith("0")) {
			System.out.println(0);
			return;
		}
		System.out.println(answer);
		
	}

}