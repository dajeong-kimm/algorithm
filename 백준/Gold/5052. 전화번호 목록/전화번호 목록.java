import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	static int t,n;
	
	
	static class TrieNode {
		HashMap<Character, TrieNode> child;
		boolean isEnd;
		
		TrieNode() {
			child = new HashMap<>();
			isEnd = false;
		}
	}
	
	static class Trie {
		TrieNode root;
		
		Trie() {
			root = new TrieNode();
		}
		
		boolean insert(String input) {
			TrieNode cur = root;
			for (int i=0;i<input.length();i++) {
				char ch = input.charAt(i);
				
				if (!cur.child.containsKey(ch)) {
					cur.child.put(ch,  new TrieNode());
				}
				
				cur = cur.child.get(ch);
				
				if (cur.isEnd) {
					return false;
				}
			}
			
			if (!cur.child.isEmpty()) return false;
			
			cur.isEnd = true;
			return true;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int T=0;T<t;T++) {
			n = Integer.parseInt(br.readLine());
			boolean flag = true;
			
			Trie trie = new Trie();
			
			for (int i=0;i<n;i++) {
				String input = br.readLine();
				
				if (!trie.insert(input)) {
					flag = false;
				}
				
			}
			if (flag) sb.append("YES").append("\n");
			else sb.append("NO").append("\n");
		}
		
		System.out.println(sb);
	}

}