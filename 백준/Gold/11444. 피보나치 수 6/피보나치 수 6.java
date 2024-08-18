import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * n번째 피보나치 수를 1_000_000_007로 나눈 나머지 출력
 * 
 * 행렬 곱셈과 행렬 거듭제곱을 이용하여 n번째 피보나치 수 찾기
 * 
 * @author KOREA
 *
 */
public class Main {
	static final int p = 1_000_000_007;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(br.readLine());
		
		int[][] fib_matrix = {{1,1},{1,0}};
		int[][] result = square(fib_matrix,n);
		
		System.out.println(result[0][1]);

	}
	
	public static int[][] mul (int[][] A, int[][] B){
		int n = A.length;
		int[][] Z = new int[n][n];
		
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				long e=0;
				for (int k=0;k<n;k++) {
					e += (long) A[i][k]*B[k][j];
					e %= p;
				}
				Z[i][j] = (int) e;
			}
		}
		return Z;
	}
	
	public static int[][] square(int[][] A, long n){
		if (n == 1) {
			for (int i=0;i<A.length;i++) {
				for (int j=0;j<A.length;j++) {
					A[i][j] %= p;
				}
			}
			return A;
		}
		
		int[][] tmp = square(A,n/2);
		if (n%2 == 0) {
			return mul(tmp,tmp);
		} else {
			return mul(mul(tmp,tmp),A);
		}
	}

}