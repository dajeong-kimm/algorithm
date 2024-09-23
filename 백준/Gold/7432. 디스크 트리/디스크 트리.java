import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 디스크 트리
 * 
 * 상근이의 디렉토리의 전체 경로가 모두 주어졌을 때,
 * 디렉토리 구조를 보기 좋게 출력하는 프로그램
 * @author KOREA
 *
 */
public class Main {
	static int N;
	
	static class TrieNode {
		Map<String, TrieNode> children;
		TrieNode() {
			children = new HashMap<>();
		}
		
		public void insert(String[] strs) {
			TrieNode trieNode = this;
			
			for (String s : strs) {
				trieNode.children.putIfAbsent(s, new TrieNode());
				trieNode = trieNode.children.get(s);
			}
		}
		public void print(TrieNode cur, int depth) {
			TrieNode trieNode = cur;
			if (trieNode.children != null) {
				List<String> list = new ArrayList<>(trieNode.children.keySet());
				Collections.sort(list);
				for (String str : list) {
					for (int i=0;i<depth;i++) {
						System.out.print(" ");
					}
					System.out.println(str);
					print(trieNode.children.get(str), depth+1);
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		TrieNode trieNode = new TrieNode();
		for (int i=0;i<N;i++) {
			String[] input = br.readLine().split("\\\\");
			trieNode.insert(input);
		}
		
		trieNode.print(trieNode, 0);
	}

}