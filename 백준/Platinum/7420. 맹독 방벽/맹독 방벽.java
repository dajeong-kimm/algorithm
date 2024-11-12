import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N,L;
	
	static class Point implements Comparable<Point>{
		int x,y;
		
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			if (x == o.x) return Integer.compare(y, o.y);
			return Integer.compare(x, o.x);
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		List<Point> points = new ArrayList<>();
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			points.add(new Point(x,y));
		}
		
		List<Point> list = new ArrayList<>();
		
		Collections.sort(points);
		List<Point> lower = new ArrayList<>();
		for (int i=0;i<N;i++) {
			Point cur = points.get(i);
			while (lower.size()>=2 && ccw(lower.get(lower.size()-2), lower.get(lower.size()-1), cur) <= 0) {
				lower.remove(lower.size()-1);
			}
			lower.add(cur);
		}
		
		List<Point> upper = new ArrayList<>();
		for (int i=N-1;i>=0;i--) {
			Point cur = points.get(i);
			while (upper.size()>=2 && ccw(upper.get(upper.size()-2), upper.get(upper.size()-1), cur) <= 0) {
				upper.remove(upper.size()-1);
			}
			upper.add(cur);
		}
		
		//중복점 제거
		lower.remove(lower.size()-1);
		upper.remove(upper.size()-1);
		
		lower.addAll(upper);
		double peri = perimeter(lower);
		
		//최소 거리 조건 : 바깥쪽으로 L만큼 확장
		peri += (2*Math.PI*L);
		
		System.out.println(Math.round(peri));
	}
	
	//볼록껍질의 둘레 계산
	static double perimeter(List<Point> list) {
		double result = 0.0;
		for (int i=0;i<list.size();i++) {
			Point a = list.get(i);
			Point b = list.get((i+1)%list.size());
			
			result += distance(a,b);
		}
		return result;
	}
	
	//두 점 사이의 거리
	static double distance(Point a, Point b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }
	
	static int ccw (Point a, Point b, Point c) {
		long area = (long) (b.x - a.x)*(c.y - a.y) - (long) (b.y - a.y)*(c.x - a.x);
		if (area > 0) return 1; //반시계
		if (area < 0) return -1; //시계
		return 0;
	}
	

}
