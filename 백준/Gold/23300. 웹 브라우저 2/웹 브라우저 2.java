import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static Deque<Integer> back = new ArrayDeque<>();
	static int cur = 0;
	static Deque<Integer> front = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		for (int i=0;i<Q;i++) {
			st = new StringTokenizer(br.readLine());
			char cmd = st.nextToken().charAt(0);
			if (cmd == 'A') { //웹페이지 접속
				int num = Integer.parseInt(st.nextToken());
				if (front.size() > 0) { //앞으로가기 공간에 저장된 페이지 삭제
					front = new ArrayDeque<>();
				}
				if (cur > 0) { //현재 페이지가 있다면 뒤로가기에 추가
					back.addLast(cur);
				}
				cur = num;
			} else if (cmd == 'B') { //뒤로가기
				if (back.size() == 0) continue;
				front.addFirst(cur);
				cur = back.pollLast();
				
			} else if (cmd == 'F') {
				if (front.size() == 0) continue;
				back.addLast(cur);
				cur = front.pollFirst();
			} else { //압축
				Deque<Integer> newBack = new ArrayDeque<>();
				while (!back.isEmpty()) {
					int num = back.pollLast();
					if (newBack.isEmpty() || newBack.peekFirst() != num) {
						newBack.addFirst(num);
					}
				}
				back = newBack;
			}
		}
		
		System.out.println(cur);
		printBack();
		printFront();
	}
	
	static void printBack() {
		if (back.size() == 0) {
			System.out.println(-1);
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		while (!back.isEmpty()) {
			sb.append(back.pollLast()+" ");
		}
		System.out.println(sb);
	}
	
	static void printFront() {
		if (front.size() == 0) {
			System.out.println(-1);
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		while (!front.isEmpty()) {
			sb.append(front.pollFirst()+" ");
		}
		System.out.println(sb);
	}

}
