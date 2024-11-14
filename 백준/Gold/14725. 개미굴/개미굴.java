import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int N;
	
	static class TrieNode {
		Map<String, TrieNode> childNode;
		TrieNode() {
			childNode = new HashMap<>();
		}
	}
	
	static class Trie {
		TrieNode root;
		
		Trie() {
			root = new TrieNode();
		}
		
		void insert(String strs) {
			TrieNode trieNode = root;
			String[] str = strs.split(",");
			for (String s : str) {
				trieNode.childNode.putIfAbsent(s, new TrieNode());
				trieNode = trieNode.childNode.get(s);
			}
		}
		
		void print(TrieNode cur, int depth) {
			if (cur.childNode != null) {
				List<String> list = new ArrayList<>(cur.childNode.keySet());
				Collections.sort(list);
				for (String str : list) {
					for (int i=0;i<depth;i++) {
						System.out.print("--");
					}
					System.out.println(str);
					print(cur.childNode.get(str), depth+1);
				}
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		Trie trie = new Trie();
		for (int i=0;i<N;i++) {
			String[] input = br.readLine().split(" ");
			int k = Integer.parseInt(input[0]);
			
			StringBuilder sb = new StringBuilder();
			for (int j=1;j<k+1;j++) {
				sb.append(input[j]).append(",");
			}
			trie.insert(sb.toString());
		}
		
		trie.print(trie.root, 0);
		
		
		
	}

}
