import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	static class TrieNode {
		TrieNode[] children;
		
		TrieNode() {
			children = new TrieNode[2];
		}
	}
	
	static void insert(TrieNode root, int num) {
		TrieNode node = root;
		
		for (int i=29; i>=0; i--) {
			int bit = (num >> i) & 1;
			if (node.children[bit] == null) {
				node.children[bit] = new TrieNode();
			}
			node = node.children[bit];
		}
	}
	
	static int findMax(TrieNode root, int num) {
		TrieNode node = root;
		int maxXOR = 0;
		
		for (int i=29;i>=0;i--) {
			int bit = (num >> i) & 1;
			int opposite = 1 - bit;
			
			if (node.children[opposite] != null) {
				maxXOR |= (1<<i);
				node = node.children[opposite];
			}
			else {
				node = node.children[bit];
			}
		}
		return maxXOR;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		TrieNode root = new TrieNode();
		insert(root, arr[0]);
		
		int maxXOR = 0;
		for (int i=1;i<N;i++) {
			int cur = arr[i];
			
			int curMax = findMax(root, cur);
			if (curMax > maxXOR) maxXOR = curMax;
			
			insert(root, cur);
		}
		
		System.out.println(maxXOR);
	}

}