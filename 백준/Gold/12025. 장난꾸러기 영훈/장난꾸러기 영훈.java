import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1들 중 몇개를 6
 * 6들 중 몇개를 1
 * 2들 중 몇개를 7
 * 7들 중 몇개를 2
 * 
 * 1과6을 모두 1로, 2와7을 모두 2로 바꾼 숫자와
 * 1과6을 모두 6으로, 2와7을 모두 7로 바꾼 숫자 사이에 가능한 모든 경우를
 * 모두 사전순으로 나열한 다음 그 중 k번째가 비밀번호
 * 
 * 영훈이가 장난을 쳐서 바뀐 비밀번호
 * k
 * --> 원래 비밀번호 출력
 * k번째 비밀번호가 존재하지 않으면 -1 출력
 * @author KOREA
 *
 */

/**
 * 풀이 과정
 * 16과 27을 각각 이진수처럼 생각
 * 1267이 나오는 자리수 및 개수 저장, 67은 12로 바꿈
 * 2^(1267개수)<K-1 이면 -1출력
 * @author KOREA
 *
 */
public class Main {
	static long k;
	
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		sb = new StringBuilder();
		
		char[] arr = br.readLine().toCharArray();
		int[] num = new int[arr.length];
		
		int cnt = 0;
		for (int i=arr.length-1;i>=0;i--) {
			if (arr[i]=='1' || arr[i]=='2' || arr[i]=='6' || arr[i]=='7') {
				//위치 , 개수 저장
				num[cnt++] = i;
				
				if (arr[i]=='6') arr[i] = '1';
				else if (arr[i]=='7') arr[i]='2';
			}
		}
		
		k = Long.parseLong(br.readLine());
		k--;
		//k--하는 이유?????
		
		long maximum = (long) Math.pow(2, cnt);
		
		if (k > maximum) {
			System.out.println(-1);
			return;
		}
		
		
		cnt = 0;
		while (k>0) {
			if (k%2 == 1) {
				if (arr[num[cnt]]=='1') arr[num[cnt]] = '6';
				else if (arr[num[cnt]]=='2') arr[num[cnt]]='7';
			}
			k/=2;
			cnt++;
		}
		for (char c : arr) {
			sb.append(c);
		}
		System.out.println(sb);

	}

}