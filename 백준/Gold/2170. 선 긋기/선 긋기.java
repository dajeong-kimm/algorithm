import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 선 긋기
 * 
 * 그려진 선들의 총 길이를 구하는 프로그램
 * 선이 여러 번 그려진 곳은 한번씩만 계산
 * @author KOREA
 *
 */
public class Main {
	static int N;
	static Node[] nodeArr;
	
	static class Node implements Comparable<Node> {
		int start;
		int end;
		
		Node(int start, int end){
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(start, o.start);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		nodeArr = new Node[N];
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			nodeArr[i] = new Node(start,end);
		}
		
		Arrays.sort(nodeArr);
		
		int answer = 0;
		int start = Integer.MIN_VALUE;
		int end = Integer.MIN_VALUE ;
		
		for (int i=0;i<N;i++) {
			Node cur = nodeArr[i];
			
			//이미 그려진 선분 내 포함
			if (cur.end <= end && cur.start >= start) {
				
			}
			
			//선분 연장
			else if (cur.start <= end && cur.end > end) {
				end = cur.end;
			}
			
			//새출발
			else if (cur.start > end) {
				answer += (end-start);
				start = cur.start;
				end = cur.end;
				
				
			}
			
			
		}
		answer += (end-start);
		System.out.println(answer);
	}

}
