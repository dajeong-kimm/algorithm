import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1이면 blue, 0이면 white
 * 
 * 잘라진 하얀색 색종이 개수 출력
 * 파란색 색종이 개수 출력
 * @author KOREA
 *
 */
public class Main {
	static int blue, white;
	static int N;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		white = 0;
		blue = 0;
		
		blue_or_white(0,0,N);
		System.out.println(white);
		System.out.println(blue);

	}
	private static void blue_or_white(int x, int y, int n) {
		 int color = arr[x][y];
		 for (int i=x;i<x+n;i++) {
			 for (int j=y;j<y+n;j++) {
				 if (color != arr[i][j]) {
					 blue_or_white(x,y,n/2);
					 blue_or_white(x,y+n/2,n/2);
					 blue_or_white(x+n/2,y,n/2);
					 blue_or_white(x+n/2,y+n/2,n/2);
					 return;
				 }
			 }
		 }
		 
		 if (color == 0) {
			 white++;
		 } else {
			 blue++;
		 }
	}

}