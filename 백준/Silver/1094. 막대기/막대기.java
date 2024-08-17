import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 64cm 막대
 * 가지고 있는 막대의 길이를 모두 더함 ,, 합이 X보다 크다면 아래의 과정 반복
 * 1. 가지고 있는 막대 중 길이가 가장 짧은 것을 절반으로 자름
 * 2. 위에서 자른 막대의 절반 중 하나를 버리고 남아있는 막대의 길이의 합이
 * X보다 크거나 같다면, 위에서 자른 막대의 절반 중 하나를 버림
 * 
 * --> 남아있는 모든 막대를 풀로 붙여서 Xcm로 만듦
 * 
 * 몇 개의 막대를 풀로 붙여서 Xcm를 만들 수 있는지?
 * @author KOREA
 *
 */
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 64 = 2^6
		
		int answer = 0;
		for (int i=0;i<=6;i++) {
			if ((N&(1<<i)) != 0) {
				answer++;
			}
		}
		
		System.out.println(answer);

	}

}