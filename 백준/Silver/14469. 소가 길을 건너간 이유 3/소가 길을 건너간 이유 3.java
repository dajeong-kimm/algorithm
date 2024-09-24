import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 소가 길을 건너간 이유3
 * @author KOREA
 *
 */
public class Main {
	static int N;
	
	static Node[] arr;
	
	static class Node implements Comparable<Node>{
		int start;
		int s;
		Node (int start, int s){
			this.start = start;
			this.s = s;
		}
		
		@Override
		public int compareTo(Node o) {
			if (start != o.start) {
				return Integer.compare(start, o.start);
			}
			else {
				return Integer.compare(s,o.s);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new Node[N];
		
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			arr[i] = new Node(start,s);
		}
		
		Arrays.sort(arr);
		
		int answer = arr[0].start;
		for (int i=0;i<N;i++) {
			int start = arr[i].start;
			int s = arr[i].s;
			
			if (answer >= start) {
				answer += s;
			}
			else {
				answer = start+s;
			}
		}
		System.out.println(answer);

	}

}
