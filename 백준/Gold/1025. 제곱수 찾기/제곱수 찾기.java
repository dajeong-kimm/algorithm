import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] arr;
	static int answer;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		for (int i=0;i<N;i++) {
			String input = br.readLine();
			for (int j=0;j<M;j++) {
				arr[i][j] = input.charAt(j)-'0';
			}
		}
		
		answer = -1;
		
		for (int i=0;i<N;i++) {
			for (int j=0;j<M;j++) {
				for (int di = -N;di<N;di++) {
					for (int dj = -M;dj<M;dj++) {
						if (di == 0 && dj == 0) {
							continue;
						}
						
						int num = 0;
						int newRow = i;
						int newCol = j;
						
						while (newRow>=0  && newRow<N && newCol>=0 && newCol<M) {
							num = num * 10 + arr[newRow][newCol];
							
							if (is_avail(num)) {
								answer = Math.max(answer, num);
							}
							
							newRow += di;
							newCol += dj;
						}
					}
					
				}
			}
		}
		System.out.println(answer);
		
		

	}
	public static boolean is_avail(int num) {
		int sqrt = (int) Math.sqrt(num);
		return sqrt * sqrt == num;
	}

}