import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * 시장 선거 포스터
 * 
 * 1. 모든 후보자는 오직 한개의 포스터
 * 2. 모든 포스터는 벽의 높이와 같게, 너비는 자유
 * 3. 벽의 조각은 나누어짐, 하나의 조각의 단위는 byte
 * 4. 각각의 포스터는 정해진 벽 부분에 빈틈없이
 * 
 * 100_000_000 byte의 벽
 * 
 * 주어진 정보대로 포스터를 붙인후 선거 전날에 보이는 총 포스터의 수
 * @author KOREA
 *
 */
public class Main {
	static int n;
	static int[] startArr, endArr;
	
	
	static TreeSet<Integer> set = new TreeSet<>();
	static List<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		startArr = new int[n];
		endArr = new int[n];
		
		//treeSet에 추가하여 자동 정렬 시키기 ,,
		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			startArr[i] = start;
			endArr[i] = end;
			
			set.add(start);
			set.add(end);
		}
		
		//좌표압축
		HashMap<Integer, Integer> map = new HashMap<>();
		int idx = 0;
		for (int s : set) {
			map.put(s, idx++);
			list.add(s);
		}
		
		int[] wall = new int[list.size()];
		
		//각 포스터의 덮인 영역 표시
		for (int i=0;i<n;i++) {
			int start = map.get(startArr[i]);
			int end = map.get(endArr[i]);
			
			//범위 내에 i번째 포스터 덮기
			for (int j=start; j<=end; j++) {
				wall[j] = i+1;
			}
		}
		
		//보이는 포스터 개수 세기
		HashSet<Integer> poster = new HashSet<>();
		for (int w : wall) {
			if (w != 0) poster.add(w);
		}
		System.out.println(poster.size());
	}
	
	
}