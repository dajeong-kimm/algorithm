import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Point implements Comparable<Point>{
		int x,y;
		
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Point o) {
			if (y == o.y) return Integer.compare(x, o.x);
			return Integer.compare(o.y,y);
		}
		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		int P = Integer.parseInt(br.readLine());
		for (int p=0;p<P;p++) {
			int N = Integer.parseInt(br.readLine());
			
			List<Point> points = new ArrayList<>();
			
			int row = (int) Math.ceil(N/5.0);
			int cnt = 0;
			A: for (int i=0;i<row;i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0;j<5;j++) {
					cnt++;
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					points.add(new Point(x,y));
					if (cnt == N) break A;
				}
			}
			
			Collections.sort(points);
			
			//오른쪽 껍질
			List<Point> right = new ArrayList<>();
			for (int i=0;i<points.size();i++) {
				Point cur = points.get(i);
				
				while (right.size()>=2 && ccw (right.get(right.size()-2), right.get(right.size()-1), cur) >=0) {
					right.remove(right.size()-1);
				}
				right.add(cur);
			}
			
			//왼쪽 껍질
			List<Point> left = new ArrayList<>();
			for (int i=points.size()-1;i>=0;i--) {
				Point cur = points.get(i);
				
				while (left.size()>=2 && ccw (left.get(left.size()-2), left.get(left.size()-1), cur) >=0 ) {
					left.remove(left.size()-1);
				}
				left.add(cur);
			}
			
			
			
			//겹치는 점 빼주기
			left.remove(left.size()-1);
			right.remove(right.size()-1);

			
			sb.append(left.size() + right.size()).append("\n");
			for (Point poi : right) {
				sb.append(poi.x + " "+poi.y).append("\n");
			}
			for (Point poi : left) {
				sb.append(poi.x +" "+ poi.y).append("\n");
			}
			
		}
		System.out.println(sb);

	}
	static int ccw(Point a, Point b, Point c) {
		long area = (long) (b.x - a.x) * (c.y - a.y) - (long) (b.y - a.y)*(c.x - a.x);
		if (area > 0) return 1; //반시계
		if (area < 0) return -1; //시계
		return 0; //일직선
	}

}
