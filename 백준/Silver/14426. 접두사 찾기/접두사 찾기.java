import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 접두사 찾기
 * 문자열 S의 접두사란 S의 가장 앞에서부터 부분 문자열을 의미
 * coudeplus의 접두사는 code, co, codepl 등
 * 
 * 트라이 : 문자열을 저장하고 검색하는 자료구조
 * retrieval - 검색 연산에 특히 유용한 자료구조
 * 
 * @author KOREA
 *
 */
public class Main {
	static int N,M;
	
	public static class TrieNode {
		HashMap<Character, TrieNode> children;
		boolean isEndOfWord;
		
		TrieNode() {
			children = new HashMap<>();
			isEndOfWord = false;
		}
	}
	
	static TrieNode root;
	
	static void insert (String word) {
		TrieNode currentNode = root;
		for (char c : word.toCharArray()) {
			currentNode.children.putIfAbsent(c, new TrieNode());
			currentNode = currentNode.children.get(c);
		}
		currentNode.isEndOfWord = true;
	}
	
	static boolean searchPrefix(String prefix) {
		TrieNode currentNode = root;
		for (char c : prefix.toCharArray()) {
			if (!currentNode.children.containsKey(c)) {
				return false;
			}
			currentNode = currentNode.children.get(c);
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		root = new TrieNode();
		for (int i=0;i<N;i++) {
			String input = br.readLine();
			insert(input);
		}
		
		int cnt = 0;
		for (int i=0;i<M;i++) {
			String query = br.readLine();
			if (searchPrefix(query)) cnt++;
		}
		System.out.println(cnt);
		
		

	}

}