import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 개미굴
 * 
 * 같은 층에 여러 개의 방이 있을 때는 사전 순서가 앞서는 먹이 정보가 먼저
 * 
 * 트라이 : 한 노드에 한 문자열 넣기
 * @author KOREA
 *
 */
public class Main {
	static int N;
	
	static class TrieNode {
		Map<String, TrieNode> childNode;
		TrieNode() {
			childNode = new HashMap<>();
		}
		
		public void insert(String strs) {
			TrieNode trieNode = this;
			String[] str = strs.split(",");
			for (String s : str) {
				trieNode.childNode.putIfAbsent(s, new TrieNode());
				trieNode = trieNode.childNode.get(s);
			}
		}
		
		public void print(TrieNode cur, int depth) {
			TrieNode trieNode = cur;
			if (trieNode.childNode != null) {
				List<String> list = new ArrayList<>(trieNode.childNode.keySet());
				Collections.sort(list);
				for (String str : list) {
					for (int i=0;i<depth;i++) {
						System.out.print("--");
					}
					System.out.println(str);
					print(trieNode.childNode.get(str),depth+1);
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		TrieNode trie = new TrieNode();
		for (int i=0;i<N;i++) {
			String[] input = br.readLine().split(" ");
			int k = Integer.parseInt(input[0]);
			
			StringBuilder sb = new StringBuilder();
			for (int j=1;j<k+1;j++) {
				sb.append(input[j]+",");
			}
			
			trie.insert(sb.toString());
		}
		
		trie.print(trie, 0);
	}

}