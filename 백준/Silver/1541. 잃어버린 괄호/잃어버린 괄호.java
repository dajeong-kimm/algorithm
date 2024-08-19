import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * + - ( )
 * 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 함
 * 
 * @author KOREA
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		List<Integer> num = new ArrayList<>();
		
		String[] exp = input.split("-");
		
		for (String part : exp) {
			int sum = 0;
			String[] tmp = part.split("\\+");
			for (String number : tmp) {
				sum += Integer.parseInt(number);
			}
			num.add(sum);
		}
		
		int n = num.get(0);
		for (int i=1;i<num.size();i++) {
			n -= num.get(i);
		}
		System.out.println(n);
		
	}

}