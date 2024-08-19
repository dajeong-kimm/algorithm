import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1차 서류심사 + 2차 면접시험
 * 
 * 서류심사 성적과 면접시험 성적 중 적어도 하나가 다른 지원자보다 떨어지지 않는 자
 * (둘중에 하나는 무조건 1등?)
 * 
 * 신규 사원 채용에서 선발할 수 있는 신입사원의 최대 인원 수
 * @author KOREA
 *
 */
public class Main {
	static int N;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t=0;t<T;t++) {
			N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][2];
			for (int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr, (a,b) -> {
				if (a[0] != b[0]) {
					return Integer.compare(a[0],b[0]);
				} else {
					return Integer.compare(a[1],b[1]);
				}
			});
			
			int top = 0;
			int result = 1;
			
			for (int i=1;i<N;i++) {
				if (arr[i][1] < arr[top][1]) {
					top = i;
					result++;
				}
			}
			
			System.out.println(result);
		}
		
		

	}

}