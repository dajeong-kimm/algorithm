import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R,C;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[R][C];
		for (int i=0;i<R;i++) {
			String input = br.readLine();
			for (int j=0;j<C;j++) {
				arr[i][j] = input.charAt(j)-'0';
			}
		}
		
		int[][] a = new int[R][C];
		int[][] b = new int[R][C];
		int[][] c = new int[R][C];
		int[][] d = new int[R][C];
		
		for (int i=0;i<R;i++) {
			for (int j=0;j<C;j++) {
				if (arr[i][j] == 1) {
					a[i][j] = (i>0 && j>0) ? a[i-1][j-1] + 1 : 1;
					b[i][j] = (i>0 && j < C-1) ? b[i-1][j+1]+1: 1;
				}
			}
		}
		
		for (int i=R-1;i>=0;i--) {
			for (int j=0;j<C;j++) {
				if (arr[i][j] == 1) {
					c[i][j] = (i<R-1 && j>0) ? c[i+1][j-1]+1:1;
					d[i][j] = (i<R-1 && j<C-1) ? d[i+1][j+1]+1:1;
				}
			}
		}
		
//		printArr(a);
//		printArr(b);
//		printArr(c);
//		printArr(d);
		
		int answer = 0;
		for (int i=0;i<R;i++) {
			for (int j=0;j<C;j++) {
				if (arr[i][j] == 1) {
					int maxPossible = Math.min(a[i][j], b[i][j]);
					
					for (int size=1;size<=maxPossible;size++) {
						if (i - 2*(size-1) >= 0 && j -(size-1) >=0 && j + (size-1) < C){
							if (c[i-2*(size-1)][j] >= size && d[i-2*(size-1)][j] >= size) {
								answer = Math.max(answer, size);
							}
						}
					}
				}
			}
		}
		
		System.out.println(answer);

	}
	
	static void printArr(int[][] arr) {
		for (int i=0;i<R;i++) {
			for (int j=0;j<C;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("------------");
	}

}