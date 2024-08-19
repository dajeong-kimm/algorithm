import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 알몸이 아닌 상태로 며칠동안 밖에 돌아다닐 수 있는지?
 * @author KOREA
 *
 */
public class Main {
	static int N;
	
	static HashMap<String, HashSet<String>> map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t=0;t<T;t++) {
			N = Integer.parseInt(br.readLine());
			map = new HashMap<>();
			for (int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();
				
				if (!map.containsKey(b)) {
					map.put(b, new HashSet<>());
				}
				map.get(b).add(a);
			}
			
			int answer = 1;
			
			for (HashSet<String> new_st : map.values()) {
				answer *= (new_st.size()+1);
			}
			System.out.println(answer-1);
		}
	}

}