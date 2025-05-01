import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String S = br.readLine();
		String T = br.readLine();
		int[] sPos = new int[M];
		int[] tPos = new int[M];
		
		int curS = 0;
		int curT = 0;
		for (int i=0;i<N+M;i++) {
			if (S.charAt(i) == '1') {
				sPos[curS++] = i;
			}
			if (T.charAt(i) == '1') {
				tPos[curT++] = i;
			}
		}
//		System.out.println(Arrays.toString(sPos));
//		System.out.println(Arrays.toString(tPos));
		
		long totalCnt = 0;
		int point = 0;
		for (int idx : sPos) {
//			System.out.println("idx: "+idx);
			if (T.charAt(idx) == '1') continue;
			while (true) {
				if (S.charAt(tPos[point]) == '1') {
					point++;
				} else {
					totalCnt += Math.abs(tPos[point]-idx);
//					System.out.println("point: "+point);
//					System.out.println("totalCnt: "+totalCnt);
					point++;
					break;
				}
			}
		}
		
		
//		System.out.println(totalCnt);
		
		long answer = 0;
		long X = totalCnt / 2;
		long Y = totalCnt - X;
		answer = X * X + Y * Y;
		System.out.println(answer);

	}

}
