import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if (N%2 == 1) {
			System.out.println("Bob");
			return;
		}
		
		Arrays.sort(arr);
		Deque<Integer> q = new ArrayDeque<>();
		for (int i=0;i<N;i++) {
			q.add(arr[i]);
		}
		
		long alice = 0;
		long bob = 0;
		while (!q.isEmpty()) {
			if (q.size()%2 == 0) {
				alice += q.pollLast();
			} else {
				bob += q.pollFirst();
			}
			if (bob >= alice) {
				System.out.println("Bob");
				return;
			}
		}
		System.out.println("Alice");
		
	}

}
