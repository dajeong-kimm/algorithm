import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] arr;
	static int[] tmp;
	static long cnt = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		tmp = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for (int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		mergeSort(0,n-1);
		System.out.println(cnt);

	}
	
	static void mergeSort(int start, int end) {
		if (start < end) {
			int mid = (start+end)/2;
			
			mergeSort(start, mid);
			mergeSort(mid+1, end);
			merge(start, mid, end);
		}
	}
	
	static void merge(int start, int mid, int end) {
		int i = start;
		int j = mid+1;
		int k = start;
		
		while (i <= mid && j <= end) {
			if (arr[i] <= arr[j]) {
				tmp[k++] = arr[i++];
			}
			else {
				tmp[k++] = arr[j++];
				cnt += (mid - i + 1);
			}
		}
		
		while (i<=mid) {
			tmp[k++] = arr[i++];
		}
		while (j<=end) {
			tmp[k++] = arr[j++];
		}
		
		for (int x=start;x<=end;x++) {
			arr[x] = tmp[x];
		}
	}

}