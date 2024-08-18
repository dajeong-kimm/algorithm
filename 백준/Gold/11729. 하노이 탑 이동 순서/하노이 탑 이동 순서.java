import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 하노이탑 이동 순서를 출력하는 프로그램
 * @author KOREA
 *
 */
public class Main {
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		sb = new StringBuilder();
		
		double cnt = Math.pow(2,N)-1;
		
		System.out.println((int) cnt);
		hanoi(N,1,2,3);
		
		System.out.println(sb.toString());
	}
	/**
	 * 
	 * @param n 이동해야 할 원판의 개수
	 * @param start 원판이 현재 위치한 기둥 번호
	 * @param middle 원판을 이동하는 과정에서 사용할 보조 기둥
	 * @param end 원판을 최종적으로 이동할 기둥 번호
	 */
	private static void hanoi(int n, int start, int middle, int end) {
		if (n == 1) {
			sb.append(start+" "+end);
			sb.append("\n");
			return;
		}
		// 1. n-1개의 원판을 start에서 middle로 이동 (end 기둥을 보조로 사용)
		hanoi(n-1,start,end,middle);
		// 2. 1개의 원판을 start에서 end로 이동
		hanoi(1,start,middle,end);
		// 3. n-1개의 원판을 middle에서 end로 이동 (start 기둥을 보조로 사용)
		hanoi(n-1,middle,start,end);
	}

}