import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
	static Trie trie;
	static char[][] board;
	static boolean[][] visited;
	static Set<String> resultSet;
	
	static int[] dx = {-1,-1,-1,0,1,1,1,0};
	static int[] dy = {-1,0,1,1,1,0,-1,-1};
	
	static class TrieNode {
		Map<Character, TrieNode> child = new HashMap<>();
		boolean isEnd;
		
		TrieNode() {
			child = new HashMap<>();
			isEnd = false;
		}
	}
	
	static class Trie {
		TrieNode root;
		
		Trie(){
			root = new TrieNode();
		}
		
		void insert(String word) {
			TrieNode cur = root;
			for (char c : word.toCharArray()) {
				cur.child.putIfAbsent(c, new TrieNode());
				cur = cur.child.get(c);
			}
			cur.isEnd = true;
		}
		
		boolean startsWith(String prefix) {
			TrieNode cur = root;
			for (char c : prefix.toCharArray()) {
				if (!cur.child.containsKey(c)) return false;
				cur = cur.child.get(c);
			}
			return true;
		}
		
		boolean contains(String word) {
			TrieNode cur = root;
			for (char c : word.toCharArray()) {
				if (!cur.child.containsKey(c)) return false;
				cur = cur.child.get(c);
			}
			return cur.isEnd;
		}
		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		trie = new Trie();
		
		int w = Integer.parseInt(br.readLine());
		String[] words = new String[w];
		for (int i=0;i<w;i++) {
			words[i] = br.readLine();
			trie.insert(words[i]);
		}
		
		br.readLine();
		
		StringBuilder sb = new StringBuilder();
		
		int b = Integer.parseInt(br.readLine());
		for (int i=0;i<b;i++) {
			board = new char[4][4];
			resultSet = new HashSet<>();
			
			for (int j=0;j<4;j++) {
				String input = br.readLine();
				for (int k=0;k<4;k++) {
					board[j][k] = input.charAt(k);
				}
			}
			
			for (int x=0;x<4;x++) {
				for (int y=0;y<4;y++) {
					visited = new boolean[4][4];
					dfs(x,y,"");
				}
			}
			
			List<String> resultList = new ArrayList<>(resultSet);
			Collections.sort(resultList);
			
			int score = 0;
			int maxLen = 0;
			String longWord = "";
			
			for (String word : resultList) {
				score += getScore(word);
				if (word.length()>maxLen) {
					maxLen = word.length();
					longWord = word;
				}
			}
			
			sb.append(score).append(" ").append(longWord).append(" ").append(resultList.size()).append("\n");
			
			if (i != b-1) br.readLine();
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int x, int y, String str) {
		if (x <0 || y<0 || x>=4 || y>=4 || visited[x][y]) {
			return;
		}
		
		str += board[x][y];
		if (!trie.startsWith(str)) return;
		
		if (trie.contains(str)) {
			resultSet.add(str);
		}
		
		visited[x][y] = true;
		for (int d=0;d<8;d++) {
			dfs(x+dx[d], y+dy[d], str);
		}
		visited[x][y] = false;
		
	}
	
	static int getScore(String word) {
		int len = word.length();
		if (len <=2) return 0;
		if(len <=4) return 1;
		if (len == 5) return 2;
		if (len == 6) return 3;
		if (len == 7) return 5;
		return 11;
	}

}