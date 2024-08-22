import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * S M L XL XXL XXXL
 * 같은 사이즈의 T장 묶음
 * 펜은 P자루씩 묶음 or 한자루씩
 * 
 * 티셔츠는 남아도 되지만 부족해서는 안되고 신청한 사이즈대로 나눠줘야 함
 * 펜은 남거나 부족해서는 안되고 정확히 참가자 수만큼
 * @author KOREA
 *
 */
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[6];
		for (int i=0;i<6;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		int answer1 = 0;
		for (int i=0;i<6;i++) {
			if (arr[i]%T == 0) {
				answer1+= arr[i]/T;
			}else {
				answer1 += arr[i]/T + 1;
			}
		}
		System.out.println(answer1);
		
		System.out.println(N/P + " "+ N%P);

	}

}