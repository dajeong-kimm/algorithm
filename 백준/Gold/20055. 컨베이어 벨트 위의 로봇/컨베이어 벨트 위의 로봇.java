import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] durability = new int[2*N];
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<2*N;i++) {
			durability[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean[] robot = new boolean[2*N];
		int step = 0;
		while (true) {
			step++;
			
			//벨트 + 로봇과 함께 한칸 회전
			rotateRight(durability);
			rotateRight(robot);
			
			//내리는 위치 로봇 내리기
			robot[N-1] = false;
			
			//로봇 이동
			for (int i=N-1;i>=0;i--) {
				if (robot[i] && !robot[i+1] && durability[i+1] > 0) {
					robot[i] = false;
					robot[i+1] = true;
					durability[i+1]--;
				}
			}
			
			robot[N-1] = false;
			
			if (durability[0] > 0) {
				robot[0] = true;
				durability[0]--;
			}
			
			int zero = 0;
			for (int d : durability) {
				if (d == 0) zero++;
			}
			
			if (zero >= K) break;
		}
		
		System.out.println(step);
	}
	
	static void rotateRight(int[] arr) {
		int last = arr[arr.length-1];
		for (int i=arr.length-1;i>0;i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = last;
	}
	
	static void rotateRight(boolean[] arr) {
		boolean last = arr[arr.length-1];
		for (int i=arr.length-1;i>0;i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = last;
	}

}
