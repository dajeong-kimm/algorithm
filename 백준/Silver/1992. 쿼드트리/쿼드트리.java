import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Quad Tree
 * 흰점 : 0 , 검은점 : 1
 * @author KOREA
 *
 */
public class Main {
	static int N;
	static char[][] arr;
	static String answer;
	
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		for (int i=0;i<N;i++) {
			String input = br.readLine();
			for (int j=0;j<N;j++) {
				arr[i][j] = input.charAt(j);
			}
		}
		
		quadTree(0,0,N);
		System.out.println(sb.toString());

	}
	private static void quadTree(int x, int y, int n) {
		char cur = arr[x][y];
		for (int i=x;i<x+n;i++) {
			for (int j=y;j<y+n;j++) {
				if (arr[i][j] != cur) {
					sb.append("(");
					quadTree(x,y,n/2);
					quadTree(x,y+n/2,n/2);
					quadTree(x+n/2,y,n/2);
					quadTree(x+n/2,y+n/2,n/2);
					sb.append(")");
					return;
				}
			}
		}
		sb.append(cur);
		
	}

}