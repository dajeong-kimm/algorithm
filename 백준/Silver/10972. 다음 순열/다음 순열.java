import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		nextPermutation();

	}
	private static void nextPermutation() {
		int i = N-1;
		while (i>0 && arr[i-1]>arr[i]) i--;
		
		if (i == 0) {
			System.out.println(-1);
			return;
		}
		
		int j = N-1;
		while (j > i && arr[i-1] > arr[j]) j--;
		
		int tmp = arr[i-1];
		arr[i-1] = arr[j];
		arr[j] = tmp;
		
		Arrays.sort(arr,i,N);
		
		for (int x=0;x<N;x++) {
			System.out.print(arr[x]+" ");
		}
	}

}