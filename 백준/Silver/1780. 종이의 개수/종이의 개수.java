import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * -1,0,1
 * 
 * 1. 모두 같은 수면 그대로 사용
 * 2. 종이를 같은 크기의 9개로 자르고 각각 (1)의 과정 반복
 * 
 * -1로만 채워진 개수, 0 , 1로만 채워진 개수 구하는 프로그램
 * @author KOREA
 *
 */
public class Main {
	static int N;
	
	static int[][] arr;
	
	static int a,b,c;

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
		a=b=c=0;
		paper(0,0,N);
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
	private static void paper(int x, int y, int n) {
		int cur_num = arr[x][y];
		for (int i=x;i<x+n;i++) {
			for (int j=y;j<y+n;j++) {
				if (arr[i][j] != cur_num) {
					paper(x,y,n/3);
					paper(x,y+n/3,n/3);
					paper(x,y+n/3+n/3,n/3);
					paper(x+n/3,y,n/3);
					paper(x+n/3,y+n/3,n/3);
					paper(x+n/3,y+n/3+n/3,n/3);
					paper(x+n/3+n/3,y,n/3);
					paper(x+n/3+n/3,y+n/3,n/3);
					paper(x+n/3+n/3,y+n/3+n/3,n/3);
					return;
				}
			}
		}
		if (cur_num == -1) a++;
		else if (cur_num == 0) b++;
		else if (cur_num == 1) c++;
	}

}