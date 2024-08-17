import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N개의 물병
 * 처음에는 모든 물병에 1L 
 * 한 번에 K개의 물병을 옮길 수 있음
 * 
 * 물병의 물을 적절히 재분배해서 K개를 넘지 않는 비어있지 않은 물병
 * 
 * 같은 양의 물이 들어 있는 물병 두 개를 고름 
 * --> 한 개의 물병에 다른 한 쪽에 있는 물을 모두 붓는다.
 * 
 * 상점에서 사야하는 물병의 최솟값
 * 정답이 없는 경우 -1 출력
 * 
 * 물병을 합치는 것 : 물병의 개수를 이진수로 표현했을 때 1의 개수를 줄이는 것
 * @author KOREA
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		// 현재 물병의 개수
		int n = Integer.parseInt(st.nextToken());
		//한 번에 합칠 수 있는 물병의 개수
		int k = Integer.parseInt(st.nextToken());
		
		int answer = buyBottle(n,k);
		System.out.println(answer);
		
		

	}
	/**
	 * 1. k-1번 반복하면서 남은 물병 중에서 가장 큰 2의 거듭제곱 값을 빼줌
	 * 	(최대한 많은 물병을 이용해 하나로 만들기)
	 * 2. 마지막에는 남은 물병보다 큰 2의 거듭제곱을 구하여 그 값에서 남은 물병 수를 빼줌
	 * @param n
	 * @param k
	 * @return
	 */
	private static int buyBottle(int n, int k) {
		if (n <= k) return 0;
		
		for (int i=0;i<k-1;i++) {
			int base = 0;
			
			while (Math.pow(2, base) < n) {
				base++;
			}
			
			n -= Math.pow(2, base-1);
			
			if (n == 0) return 0;
		}
		
		int base = 0;
		while (Math.pow(2, base)<n) {
			base++;
		}
		
		return (int) Math.pow(2, base)-n;
	}

}