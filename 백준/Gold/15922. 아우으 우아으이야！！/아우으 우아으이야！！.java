import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 수직선 위에 선분을 여러개
 * 겹치게 그리는 것도 가능
 * 선분을 모두 그렸을 때, 수직선 위에 그려진 선분 길이의 총합
 * @author KOREA
 *
 */
public class Main {
	static int N;
	
	static Node[] arr;
	
	public static class Node {
		int start;
		int end;
		Node(int start, int end){
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new Node[N];
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			arr[i] = new Node(s,e);
		}
		
		int answer = 0;
		int start = Integer.MIN_VALUE;
		int end = Integer.MIN_VALUE;
		for (int i=0;i<N;i++) {
			Node cur = arr[i];
			if (cur.start > end) {
				answer += (end-start);
				start = cur.start;
				end = cur.end;
				
			}
			
			else if (cur.end > end) {
				end = cur.end;
			}
		}
		answer += (end-start);
		System.out.println(answer);
	}

}