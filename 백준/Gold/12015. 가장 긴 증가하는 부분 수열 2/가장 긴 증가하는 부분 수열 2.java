import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * find : 이진탐색을 사용하여 요소 e가 LIS 리스트에 들어갈 위치를 찾음
 * 만약 e가 이미 있다면 e의 인덱스 반환
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
		
		List<Integer> lis = new ArrayList<>();
		lis.add(arr[0]);
		
		for (int a : arr) {
			if (lis.get(lis.size()-1) < a) {
				lis.add(a);
			} else {
				int idx = find(lis,a);
				lis.set(idx, a);
			}
		}
		System.out.println(lis.size());
	}
	
	public static int find(List<Integer> lis, int e) {
		int start = 0;
		int end = lis.size() - 1;
		
		while (start <= end) {
			int mid = (start+end)/2;
			
			if (lis.get(mid) == e) return mid;
			
			else if (lis.get(mid) < e) start = mid + 1;
			
			else end = mid - 1;
		}
		
		return start;
	}

}