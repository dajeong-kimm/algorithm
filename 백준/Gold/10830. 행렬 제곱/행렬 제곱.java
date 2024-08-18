import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 크기가 N*N인 행렬 A
 * A의 B제곱을 구하는 프로그램
 * 
 * 수가 매우 커질 수 있으니 A^B의 각 원소를 1000으로 나눈 나머지를 출력
 * @author KOREA
 *
 */
public class Main {
	static int N;
	static long B;
	static int[][] arr;
	
	static int[][] answer;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());
		
		arr = new int[N][N];
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		answer = square(arr,B);
		for (int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				System.out.print(answer[i][j]+" ");
			}
			System.out.println();
		}
	}
	private static int[][] square(int[][] arr, long B) {
		if (B == 1) {
			for (int i=0;i<N;i++) {
				for (int j=0;j<N;j++) {
					arr[i][j] %= 1000;
				}
			}
			return arr;
		}
		
		int[][] tmp = square(arr,B/2);
		if (B%2 == 0) {
			return multiple(tmp,tmp);
		} else {
			return multiple(multiple(tmp,tmp),arr);
		}
		
	}
	
	private static int[][] multiple(int[][] a, int[][] b){
		int[][] result = new int[N][N];
		for (int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				for (int k=0;k<N;k++){
					result[i][j] += (a[i][k]*b[k][j])%1000;
				}
				result[i][j] %= 1000;
			}
		}
		return result;
	}

}