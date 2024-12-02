import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
	
	static class TrieNode {
		TrieNode[] child;
		
		TrieNode() {
			child = new TrieNode[26];
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		int n = s.length();
		
		String goodStr = br.readLine();
		boolean[] isGood = new boolean[26];
		for (int i=0;i<26;i++) {
			if (goodStr.charAt(i) == '1') {
				isGood[i] = true;
			}
		}
		
		int k = Integer.parseInt(br.readLine());
		
		TrieNode root = new TrieNode();
		int uniqueCnt = 0;
		
		for (int i=0;i<n;i++) {
			TrieNode cur = root;
			int badCount = 0;
			
			for (int j=i;j<n;j++) {
				char c = s.charAt(j);
				
				if (!isGood[c - 'a']) badCount++;
				
				if (badCount > k) break;
				
				int idx = c - 'a';
				if (cur.child[idx] == null) {
					cur.child[idx] = new TrieNode();
					uniqueCnt++;
				}
				
				cur = cur.child[idx];
			}
		}
		
		System.out.println(uniqueCnt);
		
	}
	

}
