import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int count = 1;
	static int[] answer = new int[10];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int A = 1;
		
		while (A<=N) {
			while (N%10 != 9 && A<=N) {
				cal(N);
				N--;
			}
			
			while (A %10 != 0 && A<=N) {
				cal(A);
				A++;
			}
			
			if (A > N) break;
			
			A /= 10;
			N /= 10;
			
			for (int i=0;i<10;i++) {
				answer[i] += (N-A+1)*count;
			}
			
			count *= 10;
		}
		for (int i=0;i<10;i++) {
			System.out.print(answer[i]+" ");
		}
		
		
	}
	public static void cal(int cur) {
		while (0<cur) {
			answer[cur%10] += count;
			cur /= 10;
		}
	}

}