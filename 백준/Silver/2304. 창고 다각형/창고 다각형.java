import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Column implements Comparable<Column> {
		int x, h;
		
		Column(int x, int h) {
			this.x =x ;
			this.h = h;
		}
		
		@Override
		public int compareTo(Column o) {
			return Integer.compare(x, o.x);
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int maxHeight = 0;
		int maxPos = 0;
		int maxIdx = 0;
		Column[] arr = new Column[N];
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			arr[i] = new Column(x,h);
		}
		
		int answer = 0;
		
		Arrays.sort(arr);
		for (int i=0;i<N;i++) {
			if (maxHeight < arr[i].h) {
				maxHeight = arr[i].h;
				maxPos = arr[i].x;
				maxIdx = i;
			}
		}
		
		int curH = arr[0].h;
		int curX = arr[0].x;
		for (int i=1;i<=maxIdx;i++) {
			if (curH <= arr[i].h) {
				answer += curH*(arr[i].x - curX);
				curH = arr[i].h;
				curX = arr[i].x;
			}
		}
		
		curH = arr[N-1].h;
		curX = arr[N-1].x;
		for (int i=N-2;i>=maxIdx;i--) {
			if (curH <= arr[i].h) {
				answer += curH * (curX - arr[i].x);
				curH = arr[i].h;
				curX = arr[i].x;
			}
		}
		
		answer += maxHeight;
		
		System.out.println(answer);

		
	}

}
