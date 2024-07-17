import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		int[] arr = new int[9];
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i=0;i<9;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int sumValue = Arrays.stream(arr).sum();
		int a = 0;
		int b = 0;
		A: for (int i=0;i<8;i++) {
			for (int j=i+1;j<9;j++) {
				int tmp = sumValue - arr[i] - arr[j];
				if (tmp==100) {
					a = i;
					b = j;
					break A;
				}
			}
			
		}
		
		for (int i=0;i<9;i++) {
			if (i != a && i != b) {
				System.out.println(arr[i]);
			}
		}
		
	}

}
