import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 긴 막대에 N개의 과일
 * 1 ~ 9
 * 
 * 과일을 두 종류 이하로 사용
 * 
 * 앞과 뒤에서 몇개의 과일을 빼서 두 종류 이하의 과일만 남기기로 ,,
 * 앞에서 a개 뒤에서 b개의 과일 빼기
 * 
 * 과일의 개수가 가장 많은?
 * @author KOREA
 *
 */
public class Main {
	static int N;
	static int[] arr;
	static int[] num = new int[10];

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
		
		int answer = twoPointer(0,0,0,0,0);
		System.out.println(answer);

	}
	private static int twoPointer(int left, int right, int cnt, int kind, int max) {
		if (right >= N) return max;
		
		if (num[arr[right]] == 0) kind++;
		
		cnt++;
		num[arr[right]]++;
		
		if (kind>2) {
			if (--num[arr[left]] == 0) kind--;
			
			cnt--;
			left++;
			
		}
		
		max = Math.max(max, cnt);
		
		return twoPointer(left, right+1, cnt, kind, max);
		
	}

}