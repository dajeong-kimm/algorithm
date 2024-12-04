import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] parent, rank, groupSize;
	
	static class Line {
		int x1, y1, x2, y2;
		
		Line(int x1, int y1, int x2, int y2){
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		Line[] lines = new Line[N];
		
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			lines[i] = new Line(x1, y1, x2, y2);
		}
		
		parent = new int[N];
		rank = new int[N];
		groupSize = new int[N];
		for (int i=0;i<N;i++) {
			parent[i] = i;
			rank[i] = 0;
			groupSize[i] = 1;
		}
		
		//교차하면 union
		for (int i=0;i<N;i++) {
			for (int j=i+1;j<N;j++) {
				if (isIntersect(lines[i], lines[j])) {
					union(i,j);
				}
			}
		}
		
		int cnt = 0;
		int size = 0;
		
		for (int i=0;i<N;i++) {
			if (find(i) == i) {
				cnt++;
				size = Math.max(size,  groupSize[i]);
			}
		}
		
		System.out.println(cnt);
		System.out.println(size);
	}
	
	static int find(int x) {
		if (x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
	
	static void union(int a, int b) {
		int parentA = find(a);
		int parentB = find(b);
		
		if (parentA != parentB) {
			if (rank[parentA] > rank[parentB]) {
				parent[parentB] = parentA;
				groupSize[parentA] += groupSize[parentB];
			}
			else if (rank[parentA] < rank[parentB]) {
				parent[parentA] = parentB;
				groupSize[parentB] += groupSize[parentA];
			}
			else {
				parent[parentB] = parentA;
				groupSize[parentA] += groupSize[parentB];
				rank[parentA]++;
			}
		}
	}
	
	static boolean isIntersect(Line l1, Line l2) {
		int ccw1 = ccw(l1.x1, l1.y1, l1.x2, l1.y2, l2.x1, l2.y1);
		int ccw2 = ccw(l1.x1, l1.y1, l1.x2, l1.y2, l2.x2, l2.y2);
		int ccw3 = ccw(l2.x1, l2.y1, l2.x2, l2.y2, l1.x1, l1.y1);
        int ccw4 = ccw(l2.x1, l2.y1, l2.x2, l2.y2, l1.x2, l1.y2);
        
        //두 선분이 교차하는 조건 
        if (ccw1 * ccw2 <= 0 && ccw3 * ccw4 <= 0) {
        	if (ccw1 == 0 && ccw2 == 0 && ccw3 == 0 && ccw4 == 0) {
        		return isOverlapping(l1, l2);
        	}
        	return true;
        }
        return false;
       
	}
	
	static boolean isOverlapping(Line l1, Line l2) {
		 return Math.min(l1.x1, l1.x2) <= Math.max(l2.x1, l2.x2) &&
	               Math.min(l2.x1, l2.x2) <= Math.max(l1.x1, l1.x2) &&
	               Math.min(l1.y1, l1.y2) <= Math.max(l2.y1, l2.y2) &&
	               Math.min(l2.y1, l2.y2) <= Math.max(l1.y1, l1.y2);
	}
	
	static int ccw(int x1, int y1, int x2, int y2, int x3, int y3) {
		long result = (long) (x2-x1) * (y3 - y1) - (long) (y2-y1)*(x3-x1);
		return Long.compare(result, 0);
	}

}