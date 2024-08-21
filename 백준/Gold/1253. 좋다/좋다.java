import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * N개의 수 중에서 좋은 수의 개수는?
 * (1<=N<=2000)
 * 
 * 시간복잡도 : O(N^2)
 * @author KOREA
 *
 */
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int answer = 0;
		
		for (int i=0;i<N;i++) {
			int goal = arr[i]; //현재 확인할 수 (좋은 수인지 확인할 대상)
			
			int start = 0;
			int end = N-1;
			
			//투 포인터를 이용해 두 수의 합으로 현재 수(goal)을 만들 수 있는지 ,,
			while (start<end) {
				if (arr[start]+arr[end] == goal) {
					if (start == i) start++;
					else if (end == i) end--;
					else {
						//두 포인터가 모두 다른 수를 가리킬 때
						answer++; // 좋은 수라고 인정
						break;
					}
				}
				else if (arr[start] + arr[end] > goal) end--;
				else if (arr[start] + arr[end] < goal) start++;
			}
		}
		
		System.out.println(answer);

	}

}