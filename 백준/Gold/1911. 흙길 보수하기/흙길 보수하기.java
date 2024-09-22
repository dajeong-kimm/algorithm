import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 흙길 보수하기
 * 물 웅덩이들의 위치와 크기에 대한 정보가 주어질때,
 * 모든 웅덩이들을 덮기 위해 필요한 널빤지들의 최소 개수
 * @author KOREA
 *
 */
public class Main {
	static int N,L;
	static Node[] arr;
	
	public static class Node implements Comparable<Node> {
		int start,end;
		
		Node(int start, int end){
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(start, o.start);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		arr = new Node[N];
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			arr[i] = new Node(s,e);
		}
		
		Arrays.sort(arr);
		
		int answer = 0;
		int fill = 0;
		for (int i=0;i<N;i++) {
			Node cur = arr[i];
			
			//현재 웅덩이가 이미 채워진 경우
			if (cur.end < fill) continue;
			
			//현재 웅덩이 시작 위치 기준 최대 위치로 변경
			if (fill < cur.start) {
				fill = cur.start;
			}
			
			int remain = (cur.end - fill) % L;
			answer += (cur.end - fill) / L;
			fill = cur.end;
			
			if (remain != 0) {
				answer++;
				fill += L - remain;
			}
		}
		
		System.out.println(answer);
	}

}