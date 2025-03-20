

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static class Line implements Comparable<Line> {
		int start, end;
		
		Line(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Line o) {
			return Integer.compare(start, o.start);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		List<Line> list = new ArrayList<>();
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.add(new Line(start, end));
		}
		
		Collections.sort(list);
		int answer = 0;
		int maxValue = Integer.MIN_VALUE;
		int minValue = Integer.MAX_VALUE;
		
		for (int i=0;i<N;i++) {
			Line cur = list.get(i);
			
			if (cur.start >= maxValue) {
				minValue = cur.start;
				maxValue = cur.end;
				answer += (cur.end - cur.start);
			}
			else if (cur.end > maxValue) {
				minValue = maxValue;
				maxValue = cur.end;
				answer += (cur.end - minValue);
			}
		}
		System.out.println(answer);
	}

}
