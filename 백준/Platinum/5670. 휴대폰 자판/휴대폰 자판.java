import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	static class TrieNode {
		Map<Character, TrieNode> children = new HashMap<>();
		boolean isLastChar;
		
		TrieNode() {
			this.isLastChar = false;
		}
	}
	
	static class Trie {
		TrieNode root;
		
		Trie() {
			root = new TrieNode();
		}
		
		void insert(String word) {
			TrieNode node = root;
			
			for (char ch : word.toCharArray()) {
				if (!node.children.containsKey(ch)) {
					node.children.put(ch, new TrieNode());
				}
				node = node.children.get(ch);
				
			}
			node.isLastChar = true;
		}
		
		int countPress(String word) {
			TrieNode node = root;
			int press = 1; //첫글자는 반드시 입력해야함
			
			node = node.children.get(word.charAt(0));
			
			for (int i=1;i<word.length();i++) {
				char ch = word.charAt(i);
				
				if (node.children.size() > 1 || node.isLastChar) {
					press++;
				}
				
				node = node.children.get(ch);
			}
			return press;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		String input;
		while ((input=br.readLine()) != null && !input.trim().isEmpty()) {
			int N = Integer.parseInt(input);
			Trie trie = new Trie();
			
			String[] words = new String[N];
			for (int i=0;i<N;i++) {
				words[i] = br.readLine();
				trie.insert(words[i]);
			}
			
			int totalPress = 0;
			for (String word : words) {
				totalPress += trie.countPress(word);
			}
			
			double average = (double) totalPress/N;
			sb.append(String.format("%.2f", average)).append("\n");
		}
		System.out.println(sb);

	}
	
	

}