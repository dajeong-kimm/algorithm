import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * 니가 싫어 싫어
 * 
 * 자신의 방에 모기가 가장 많이 있는 시간대가 언제인지?
 * 어떤 모기가 방에 언제 입장했고 언제 퇴장했는지를 기록
 * 
 * 모기들이 가장 많이 있는 시간대, 해당 시간대에 모기가 몇 마리?
 * 
 * 같은 값을 가지는 좌표들의 범위를 압축시켜 N의 크기 1_000_000만큼의 좌표만 사용하도록
 * --> T의 모든 값을 값이 들어오면 자동으로 오름차순 정렬과 중복 허용을 하지 않는 TreeSet에 넣고 다시 ArrayList로 변환
 * 
 * @author KOREA
 *
 */
public class Main {
	static int N;
	static int startArr[], endArr[];
	static TreeSet<Integer> set = new TreeSet<>();
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		startArr = new int[N];
		endArr = new int[N];
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			startArr[i] = Integer.parseInt(st.nextToken());
			endArr[i] = Integer.parseInt(st.nextToken());
			
			set.add(startArr[i]);
			set.add(endArr[i]);
			
		}
		
		//treeSet을 ArrayList로 변환
		ArrayList<Integer> idx = new ArrayList<>(set);
		
		//좌표압축
		int sum[] = new int[idx.size()];
		for (int i=0;i<N;i++) {
			int x = Collections.binarySearch(idx, startArr[i]);
			int y = Collections.binarySearch(idx, endArr[i]);
			
			for (int j=x;j<y;j++) {
				sum[j]++;
			}
		}
		
		int max = 0;
		int maxIndex = -1;
		int maxEndIndex = -1;
		for (int i=0;i<idx.size();i++) {
			if (sum[i] > max) {
				maxIndex = i;
				maxEndIndex = i;
				max = sum[i];
			}
			if (sum[i] == max && i-1 == maxEndIndex) {
				maxEndIndex = i;
			}
		}
		
		//모기가 가장 많이 있는 시간대의 연속 구간
		System.out.println(max);
		System.out.println(idx.get(maxIndex)+" "+idx.get(maxEndIndex+1));
	}

}