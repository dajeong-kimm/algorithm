import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 최소 회의실 개수
 * 
 * N개의 회의를 모두 진행할 수 있는 최소 회의실 개수?
 * 
 * 회의가 시작될 때마다 현재 사용 중인 회의실 개수를 증가,
 * 회의가 끝날 때마다 감소
 * @author KOREA
 *
 */
public class Main {
	static int N;
	
	static int[] startTime;
	static int[] endTime;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		startTime = new int[N];
		endTime = new int[N];
		
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			startTime[i] = s;
			endTime[i] = e;
		}
		
		Arrays.sort(startTime);
		Arrays.sort(endTime);
		
		int rooms = 0;
		int maxRooms = 0;
		int start = 0;
		int end = 0;
		
		while (start < N) {
			//시작 시간이 종료 시간보다 빠르면 새로운 회의실 필요
			if (startTime[start] < endTime[end]) {
				rooms++;
				start++;
			}
			//종료 시간이 시작 시간보다 빠르면 회의가 끝났으므로 rooms 감소
			else {
				rooms--;
				end++;
			}
			
			//현재 사용 중인 회의실의 최대 개수 기록
			maxRooms = Math.max(maxRooms, rooms);
			
		}
		
		System.out.println(maxRooms);
	}

}