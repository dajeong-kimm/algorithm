import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Contact
 * 
 * x+()는 임의의 개수 x의 반복으로 이루어진 전파의 집합
 * 
 * {x|y} : x혹은 y
 * 
 * {100+1+|01}+ 의 패턴을 가진 전파를 가려내기
 * @author KOREA
 *
 */
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t=1;t<=T;t++) {
			String input = br.readLine();
			Contact(input);
		}

	}
	public static void Contact(String s) {
		String answer = "(100+1+|01)+";
		
		if (s.matches(answer)) System.out.println("YES");
		else System.out.println("NO");
	}

}