import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 배열에 x를 넣는다.
 * 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거한다.
 * 절댓값이 가장 작은 값이 여러개일 때는 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.
 * @author KOREA
 *
 */
public class Main {
	public static class Num implements Comparable<Num>{
		int x;
		int check; //1이면 양수 0이면 음수
		
		Num(int x, int check) {
			this.x = x;
			this.check = check;
		}
		
		@Override
		public int compareTo(Num n) {
			if (x == n.x) {
				return check - n.check;
			}
			return x - n.x;
		}
	}
	static int N;
	
	static PriorityQueue<Num> queue;
	
	//x기 0이 아니라면 배열에 x라는 값을 넣는 연산
	//x가 0이라면 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		queue = new PriorityQueue<>();
		for (int i=0;i<N;i++) {
			int x = Integer.parseInt(br.readLine());
			if (x > 0) {
				queue.add(new Num(x,1));
			}
			else if (x < 0) {
				queue.add(new Num(-x,0));
			}
			else if (x == 0) {
				if (queue.isEmpty()) {
					System.out.println(0);
				}else {
					Num n = queue.poll();
					if (n.check == 1) {
						System.out.println(n.x);
					} else {
						System.out.println(-n.x);
					}
				}
				
			}
		}
	}

}