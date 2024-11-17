import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	static Map<String, Integer> cntMap;
	
	static class TrieNode {
		Map<Character, TrieNode> child = new HashMap<>();
		boolean isEnd;
		int count;
	}
	
	static class Trie {
		TrieNode root;
		
		Trie() {
			root = new TrieNode();
		}
		
		void insert(String str) {
			TrieNode cur = root;
			
			
			for (char ch : str.toCharArray()) {
				if (!cur.child.containsKey(ch)) {
					cur.child.put(ch, new TrieNode());
				}
				cur = cur.child.get(ch);
				cur.count++;
			}
			
			cur.isEnd = true;
		}
		
		String search (String str) {
			TrieNode cur = root;
			
			StringBuilder sb = new StringBuilder();
			for (char ch : str.toCharArray()) {
				sb.append(ch);
				
				cur = cur.child.get(ch);
				
				if (cur.count == 1) {
					return sb.toString();
				}
			}
			
			int num = cntMap.get(str);
			if (num == 1) {
				return str;
			}
			else {
				return str + num;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Trie trie = new Trie();
		StringBuilder answer = new StringBuilder();
		cntMap = new HashMap<>();
		int N = Integer.parseInt(br.readLine());
		for (int i=0;i<N;i++) {
			String input = br.readLine();
			cntMap.putIfAbsent(input, 0);
			cntMap.put(input, cntMap.get(input)+1);
			trie.insert(input);
			answer.append(trie.search(input)).append("\n");
//			System.out.println(trie.search(input));
		}
		System.out.println(answer);

	}

}