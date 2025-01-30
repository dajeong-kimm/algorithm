import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static int N;
	static int cnt;
	
	static int answer;
	static Point[] points;
	
	static class Point implements Comparable<Point>{
		int x, y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Point o) {
			if (y == o.y) {
				return Integer.compare(x, o.x);
			}
			return Integer.compare(y, o.y);
		}
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		N = Integer.parseInt(br.readLine());
		cnt = Integer.parseInt(br.readLine());
		
		points = new Point[cnt];
		int maxHeight = 0;
		for (int i=0;i<cnt;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			maxHeight = Math.max(maxHeight, x);
			points[i] = new Point(x,y);
		}
		
		Arrays.sort(points);
		
		answer = maxHeight;
		int start = maxHeight;
		int end = Math.max(R, C);
		while (start<=end) {
			int mid = (start+end)/2;
			
			if (block(mid)) {
				answer = mid;
				end = mid-1;
			}
			else {
				start = mid+1;
			}
		}
		
		System.out.println(answer);

	}
	
	static boolean block(int len) {
		
		int count = 0;
		int avail = 0;
		
		for (Point point : points) {
			if (point.y > avail) {
				count++;
				avail = point.y + len -1 ;
			}
			if (count > N) return false;
		}
		return true;
	}

}
