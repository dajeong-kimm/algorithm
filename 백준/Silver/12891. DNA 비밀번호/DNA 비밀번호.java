import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 메모리 : 
 * 시간 : 
 * 
 * 슬라이딩 윈도우
 */
public class Main {
	static int S, P;
	static String str;
	static int A, C, G, T;
	
	//각 문자 (A,C,G,T)의 현재 개수를 저장할 해시맵
	static HashMap<Character, Integer> map;
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		str = br.readLine();
		
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new HashMap<>();
		
		map.put('A', 0);
		map.put('C', 0);
		map.put('G', 0);
		map.put('T', 0);
		
		int left = 0;
		int right = P-1;
		
		//첫번째 윈도우에 포함되는 문자의 빈도수 업데이트
		for (int i=left;i<right;i++) {
			map.put(str.charAt(i), map.get(str.charAt(i))+1);
		}
		
		int answer = 0;
		
		//슬라이딩 윈도우를 사용하여 문자열 탐색
		while (right<S) {
			map.put(str.charAt(right), map.get(str.charAt(right))+1);
			
			if (map.get('A')>=A && map.get('C')>=C && map.get('G')>=G && map.get('T')>=T) {
				answer++;
			}
			
			//현재 left 위치의 문자를 윈도우에서 제거
			map.put(str.charAt(left), map.get(str.charAt(left))-1);
			
			left++;
			right++;
		}
		System.out.println(answer);

	}

}