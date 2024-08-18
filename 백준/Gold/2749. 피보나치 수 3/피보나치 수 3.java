import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 0 1 1 2 3 ,,,
 * n이 주어졌을 때 n번째 피보나치 수
 * n <= 1_0000_000_000_000_000_000
 * 
 * n번째 피보나치 수를 1_000_000으로 나눈 나머지
 * @author KOREA
 *
 */
public class Main {
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(br.readLine());
		
		int mod = 1_000_000;
		
		ArrayList<Integer> fibo = new ArrayList<>();
		fibo.add(0);
		fibo.add(1);
		
		//주기의 길이
		int p = mod / 10 * 15;
		
		//피보나치 수열을 주기(p)만큼 계산하여 리스트에 저장
		for (int i=2;i<p;i++) {
			fibo.add((fibo.get(i-1)+fibo.get(i-2))%mod);
		}
		System.out.println(fibo.get((int) (n%p)));
	}

}