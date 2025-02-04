import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int T;
	static int NA, NB;
	static int MAX = 60*23 + 59;
	
	static PriorityQueue<Integer> trainA;
	static PriorityQueue<Integer> trainB;
	
	static PriorityQueue<Train> pqA;
	static PriorityQueue<Train> pqB;
	
	static class Train implements Comparable<Train> {
		int from, to;
		
		Train(int from, int to) {
			this.from = from;
			this.to = to;
		}
		
		@Override
		public int compareTo(Train o) {
			if (from == o.from) {
				return Integer.compare(o.to, to);
			}
			return Integer.compare(from, o.from);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine());
		for (int test=1;test<=testCase;test++) {
			T = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			NA = Integer.parseInt(st.nextToken());
			NB = Integer.parseInt(st.nextToken());
			
			pqA = new PriorityQueue<>();
			pqB = new PriorityQueue<>();
			
			for (int i=0;i<NA;i++) {
				st = new StringTokenizer(br.readLine());
				String from = st.nextToken();
				String to = st.nextToken();
				pqA.add(new Train(timeToMin(from), timeToMin(to)));
			}
			for (int i=0;i<NB;i++) {
				st = new StringTokenizer(br.readLine());
				String from = st.nextToken();
				String to = st.nextToken();
				pqB.add(new Train(timeToMin(from), timeToMin(to)));
			}
			
			int curTime = 0;
			trainA = new PriorityQueue<>();
			trainB = new PriorityQueue<>();
			
			int answerA = 0;
			int answerB = 0;
			while (true) {
				if (pqA.isEmpty() && pqB.isEmpty()) break;
				
				Train A = pqA.peek();
				Train B = pqB.peek();
				//B에서 출발시키기
				if (A == null) {
					if (trainB.isEmpty()) {
						answerB++;
						trainA.add(B.to + T);
					}
					else if (trainB.peek() <= B.from) {
						trainB.poll();
						trainA.add(B.to+T);
					}
					else {
						answerB++;
						trainA.add(B.to + T);
					}
					pqB.poll();
				}
				//A에서 출발시키기
				else if (B == null) {
					if (trainA.isEmpty()) {
						answerA++;
						trainB.add(A.to + T);
					}
					else if (trainA.peek() <= A.from) {
						trainA.poll();
						trainB.add(A.to+T);
					}
					else {
						answerA++;
						trainB.add(A.to+T);
					}
					pqA.poll();
				}
				//A에서 기차출발시키기
				else if (A.from <= B.from) {
					if (trainA.isEmpty()) {
						answerA++;
						trainB.add(A.to + T);
					}
					else if (trainA.peek() <= A.from) {
						trainA.poll();
						trainB.add(A.to+T);
					}
					else {
						answerA++;
						trainB.add(A.to+T);
					}
					pqA.poll();
					
				}
				//B에서 기차출발시키기
				else {
					if (trainB.isEmpty()) {
						answerB++;
						trainA.add(B.to + T);
					}
					else if (trainB.peek() <= B.from) {
						trainB.poll();
						trainA.add(B.to+T);
					}
					else {
						answerB++;
						trainA.add(B.to + T);
					}
					pqB.poll();
				}
			}
			
			sb.append("Case #").append(test).append(": ").append(answerA).append(" ").append(answerB).append("\n");
		}
		System.out.println(sb);

	}
	
	static int timeToMin(String input) {
		int result = 0;
		int hour = Integer.parseInt((String) input.subSequence(0, 2));
		int min = Integer.parseInt((String) input.substring(3,5));
		
		return hour*60 + min;
	}

}