import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 휴먼 파이프라인
 * 
 * K개의 상자를 적절한 곳으로 옮기기
 * N명의 참가자
 * 두 팀으로 나눠져 작업 진행 ,, 두 팀 모두 적어도 한명 포함
 * (가장 느린 작업속도) * (팀에 속한 사람의 수)
 * --> K/v분
 * 
 * 모든 상자를 최대한 빠르게 옮길 수 있도록 N명을 적절히 두 팀으로 나누어 옮길때
 * 제일 빨리 끝나는 경우의 시간
 * @author KOREA
 *
 */
public class Main {
	static int N;
	static long K;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Long.parseLong(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		long total = 0;
		for (int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			total += arr[i];
		}
		
		Arrays.sort(arr);
		
		//좌 : 0 우 : 0빼고 나머지 전부
		long left_cnt = 1;
		long right_cnt = N-1;
		
		long totalV = arr[0] + arr[1]*(N-1);
		
		for (int i=1;i<N-1;i++) {
			left_cnt++;
			right_cnt--;
			
			long curV = arr[0]*left_cnt + arr[i+1]*right_cnt;
//			System.out.println("i: "+i+" curV: "+curV);
			totalV = Math.max(totalV, curV);
		}
		
//		System.out.println("totalV: "+totalV);
		
		if ((K%totalV) == 0) {
			System.out.println(K/totalV);
		}
		else {
			System.out.println(K/totalV + 1);
		}
		
		
	}

}