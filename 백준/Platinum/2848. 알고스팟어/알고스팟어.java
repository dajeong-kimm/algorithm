import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Main {
	static int N;
	static String[] input;
	static List<Integer> graph[] = new ArrayList[26];
	static Set<Character> set = new HashSet<>();

	//올바른 순서가 없다면 !
	//가능한 순서가 두 개 이상이라면 ?
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		input = new String[N];
		for (int i=0;i<N;i++) {
			input[i] = br.readLine();
			//사용된 모든 알파벳의 개수 저장
			for (int j=0;j<input[i].length();j++) {
				set.add(input[i].charAt(j));
			}
		}
		
		for (int i=0;i<26;i++) {
			graph[i] = new ArrayList<>();
		}
		
		int[] inDegree = new int[26];
		
		for (int i=1;i<N;i++) {
			String before = input[i-1];
			String cur = input[i];
			
			int len = Math.min(before.length(), cur.length());
			for (int l=0;l<len;l++) {
				if (before.charAt(l) != cur.charAt(l)) {
					char from = before.charAt(l);
					char to = cur.charAt(l);
					
					graph[from-'a'].add(to-'a');
					inDegree[to-'a']++;
					break;
				}
			}
			
			if (before.startsWith(cur) && before.length() > cur.length()) {
				System.out.println("!");
				return;
			}
			
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		for (int i=0;i<26;i++) {
			char ch = (char) ('a'+i);
			if (set.contains(ch) && inDegree[ch-'a'] == 0) {
				q.add(ch-'a');
			}
		}
		
		boolean flag = false;
		if (q.size()>1) flag = true;
		
		for (int i=0;i<set.size();i++) {
			if (q.isEmpty()) {
				System.out.println("!");
				return;
			}
			
			if (q.size() > 1) flag = true;
			
			int cur = q.poll();
			char ch = (char) ('a'+cur);
			sb.append(ch);
			
			for (int next : graph[cur]) {
				inDegree[next]--;
				if (inDegree[next] == 0) {
					q.add(next);
				}
			}
		}
		
		if (flag) System.out.println("?");
		else System.out.println(sb);
		
		
	}

}