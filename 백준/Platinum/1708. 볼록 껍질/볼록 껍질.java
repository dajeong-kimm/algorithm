import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 볼록 껍질을 이루는 점의 개수?
 * @author KOREA
 *
 */
public class Main {
	static class Point implements Comparable<Point>{
		int x,y;
		
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Point o) {
			if (this.x == o.x) return Integer.compare(y, o.y);
			return Integer.compare(x, o.x);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		List<Point> points = new ArrayList<>();
		
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			points.add(new Point(x,y));
		}
		
		Collections.sort(points);
		
		//아래쪽 껍질
		List<Point> lower = new ArrayList<>();
		for (Point p : points) {
			//반시계 방향이여야 하므로 시계방향 또는 일직선이면 아래쪽 껍질을 만드는 데 불필요한 점
			while (lower.size() >= 2 && ccw(lower.get(lower.size()-2), lower.get(lower.size()-1), p) <= 0) {
				lower.remove(lower.size()-1);
			}
			lower.add(p);
		}
		
		//위쪽껍질
		List<Point> upper = new ArrayList<>();
		for (int i = points.size() - 1; i >= 0; i--) {
            Point p = points.get(i);
            //거꾸로 돌기 때문에 시계방향이거나 일직선이면 안됨 (반시계방향이어야 함)
            while (upper.size() >= 2 && ccw(upper.get(upper.size() - 2), upper.get(upper.size() - 1), p) <= 0) {
                upper.remove(upper.size() - 1);
            }
            upper.add(p);
        }
		
		//위쪽과 아래쪽 껍질의 마지막 점 중복
		lower.remove(lower.size()-1);
		upper.remove(upper.size()-1);
		
		System.out.println(lower.size()+upper.size());

	}
	
	//ccw 연산 --> 회전방향 확인
	public static int ccw(Point a, Point b, Point c) {
		long area = (long) (b.x - a.x) * (c.y - a.y) - (long) (b.y - a.y)*(c.x - a.x);
		if (area > 0) return 1; //반시계
		if (area < 0) return -1; //시계
		return 0; //일직선
	}

}