import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());
		
		int result = (int) (max - min + 1);
		int sqrt = (int) Math.sqrt(max);
		
		boolean[] check = new boolean[result];
		
		
		for (long i=2;i<=sqrt;i++) {
			long square = i*i; //현재 숫자의 제곱
			//제곱으로 나누어 떨어지는 모든 수를 체크
			long start = min % square == 0 ? min / square : (min / square)+1;
			for (long j = start;j*square<=max;j++) {
				//제곱으로 나누어 떨어지는 수는 제곱ㄴㄴ수가 아님
				check[(int) (j*square - min)] = true;
			}
		}
		
		int count = 0;
		for (int i=0;i<result;i++) {
			if (!check[i]) count++;
		}
		
		System.out.println(count);
	}

}