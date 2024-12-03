import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static boolean[] isSelected;
	static List<Node> busList = new ArrayList<>();
	
	static class Node implements Comparable<Node>{
		int start;
		int end;
		int idx;
		
		Node (int start, int end, int idx) {
			this.start = start;
			this.end = end;
			this.idx = idx;
		}
		
		//출발시간 작은순 ,, 도착시간 큰순
		@Override
		public int compareTo(Node o) {
			if (start == o.start) {
				return Integer.compare(o.end, end);
			}
			return Integer.compare(start, o.start);
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		isSelected = new boolean[M];
		
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (b < a) {
				busList.add(new Node(a, b+N, i));
			}
			else {
				busList.add(new Node(a, b, i));
				busList.add(new Node(a+N, b+N, i));
			}
		}
		
		Collections.sort(busList);
		
		
		int lastEnd = -1;
		
		for (int i=0;i<busList.size();i++) {
			Node cur = busList.get(i);
			
//			System.out.println(cur.start+" "+cur.end+" "+cur.idx);
			
			if (cur.end <= lastEnd) {
				isSelected[cur.idx] = true;
			}
			else {
				lastEnd = cur.end;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<M;i++) {
			if (!isSelected[i]) {
				sb.append(i+1).append(" ");
			}
		}
		System.out.println(sb);
	}

}