import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 현수막 걸기
 * 
 * 구매할 수 있는 현수막의 최대 넓이 R
 * 주어진 말뚝과 깃대를 활용해서 현수막을 걸때 -> 현수막 넓이의 최댓값?
 * @author KOREA
 *
 */
public class Main {
	static int N,M,R;
	static int[] point;
	static int[] height;
	static HashSet<Integer> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		point = new int[N];
		height = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			point[i] = Integer.parseInt(st.nextToken());
		}
		
		List<Integer> numList = new ArrayList<>();
		for (int i=0;i<N-1;i++) {
			for (int j=i+1;j<N;j++) {
				int num = Math.abs(point[i] - point[j]);
				if (!set.contains(num)) {
					set.add(num);
					numList.add(num);
				} 
			}
		}
		
		
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<M;i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(height);
		
		Collections.sort(numList);
		
		double area = -1;
		for (int i=0;i<numList.size();i++) {
			int start = 0;
			int end = M-1;
			int w = numList.get(i);
			
			while (start<=end) {
				int mid = (start+end)/2;
				int h = height[mid];
				
				double tmp_area = w*h*0.5;
				if (tmp_area > R) {
					end = mid-1;
				}
				else {
					area = Math.max(area, tmp_area);
					start = mid+1;
				}
			}
		}
		
		if (area == -1) System.out.println(-1);
		else System.out.printf("%.1f\n", area);

	}

}