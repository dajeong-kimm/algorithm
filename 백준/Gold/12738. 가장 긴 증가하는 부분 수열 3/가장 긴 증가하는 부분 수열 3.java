import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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
		
		List<Integer> list = new ArrayList<>();
		list.add(arr[0]);
		
		for (int a : arr) {
			if (list.get(list.size()-1) < a) {
				list.add(a);
			}
			else {
				int idx = find_idx(list,a);
				list.set(idx, a);
			}
		}
		System.out.println(list.size());
	}
	public static int find_idx(List<Integer> list, int a) {
		int start = 0;
		int end = list.size()-1;
		
		while (start<=end) {
			int mid = (start+end)/2;
			
			if (list.get(mid) == a) return mid;
			
			else if (list.get(mid) > a) end = mid-1;
			
			else start = mid+1;
		}
		
		return start;
	}

}