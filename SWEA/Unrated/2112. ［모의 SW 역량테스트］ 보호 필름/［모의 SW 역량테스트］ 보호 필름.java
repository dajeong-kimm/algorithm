import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 메모리 : 28372 kb
 * 시간 : 293 ms
 * 
 * D 보호 필름의 두께
 * W 가로 크기
 * K 합격기준
 * 
 * 특성A 0 , 특성B 1
 * 
 * 약품 투입 횟수를 최소로 하여 성능검사를 통과할 수 있는 방법 --> 이때의 약품 투입 횟수 출력
 * 투입하지 않고도 성능검사 통과 ---> 0
 * 
 * ## answer = x; 하면 (테케 4개 틀림)
 * int x --> 해서 x바로 출력하면 정답 ,, ???
 * 
 * @author SSAFY
 *
 */
public class Solution {
	static int D,W,K;
	
	static int[][] arr;
	
	static int[] A = new int[20];
	static int[] B = {1,1,1,1,1, 1,1,1,1,1, 1,1,1,1,1, 1,1,1,1,1};
	
	static int answer;
	
	static boolean flag;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken()); //보호 필름의 두께
			W = Integer.parseInt(st.nextToken()); // 가로크기
			K = Integer.parseInt(st.nextToken()); // 합격기준
			
			arr = new int[13][20];
			for (int i=0;i<D;i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0;j<W;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			if (K == 1) {
				System.out.println("#"+t+" "+0);
			}
			
			else{
				int x;
				flag = false;
				for (x=0;x<=K-1;x++) {
					combination(0,0,x);
					if (flag) break;
				}
				
				System.out.println("#"+t+" "+x);
				}
			}
			
		}

	
	private static void combination(int start, int cnt, int want_cnt) {
		if (cnt == want_cnt) {
			if (!pass()) return;
			
			flag = true;
			return;
		}
		for (int i=start;i<D;i++) {
			int[] tmp = arr[i];
			
			arr[i] = A;//A약품 투입
			combination(i+1, cnt+1, want_cnt);
			if (flag) return;
			
			arr[i] = B; //B약품 투입
			combination(i+1,cnt+1,want_cnt);
			if (flag) return;
			
			arr[i] = tmp; //원본 배열 되돌리기
		}
	}
	

	private static boolean pass() {
		A : for (int j=0;j<W;j++) {
			int len = 1;
			for (int i=1;i<D;i++) {
				if (arr[i][j] == arr[i-1][j]) {
					if (++len == K) continue A;
				}
				else len = 1;
			}
			return false;
		}
		return true;
	}


	
	private static void printArr(int[][] arr) {
		for (int i=0;i<arr.length;i++) {
			for (int j=0;j<arr[0].length;j++) {
				System.out.println(arr[i][j]+" ");
			}
		}
		System.out.println();
	}

}