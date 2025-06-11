import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] arr = br.readLine().toCharArray();
		int aCount = 0;
		for (int i=0;i<arr.length;i++) {
			if (arr[i] == 'a') aCount++;
		}
		
		int cnt = 0;
		for (int i=0;i<aCount;i++) {
			if (arr[i] == 'b') cnt++;
		}
		
		int answer = cnt;
		for (int i=1;i<arr.length;i++) {
			if (arr[i-1] == 'b') cnt--;
			if (arr[(i-1+aCount)%arr.length] == 'b') cnt++;
			answer = Math.min(answer, cnt);
		}
		
		System.out.println(answer);
	}

}
