import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static boolean flag;
	static int[] arr, arr2;
	static int N;
	
	static int cnt;
	static boolean notuse = false;

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
		
		Arrays.sort(arr);
		
		if (N == 1) {
			System.out.println(arr[0]);
			return;
		}
		
		while (true) {
			boolean flag = false;
			
			for (int i=0;i<N-1;i++) {
				if ((arr[i] + 1) == arr[i+1]) {
					
					int end = i + 2;
			        while (end < N && arr[end] == arr[i + 1]) {
			            end++;
			        }
			        
			        //i+2부터 끝까지 탐색했는데 적절한 값이 없을 때
			        //i-1부터 다시 확인해봐야함
			        if (end == N) {
			            int start = i - 1;
			            if (start >= 0) {
			                while (start >= 0 && arr[start] == arr[i]) {
			                    start--;
			                }
			            }
			            if (start + 1 < N) {
			                arr[start + 1]++;
			                arr[i + 1]--;
			                flag = true;
			            }
			        } 
			        else {
			            int tmp = arr[end];
			            arr[end] = arr[i + 1];
			            arr[i + 1] = tmp;
			            flag = true;
			        }
				}
			}
			
			if (!flag) break;
		}
		
		if ((arr[N-2]+1) == arr[N-1]) {
			int tmp = arr[N-1];
			arr[N-1] = arr[N-2];
			arr[N-2] = tmp;
		}
		
		
		
		StringBuilder sb = new StringBuilder();
        for(int num : arr) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
	}
	
}