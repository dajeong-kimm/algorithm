import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static int[] minsu;
	static int M;
	
	static int[] parent;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		minsu = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            minsu[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(minsu);
        
        parent = new int[M+1];
        for (int i=0;i<=M;i++) {
        	parent[i] = i;
        }
		
		StringBuilder sb = new StringBuilder();
		
		int[] card = new int[K];
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<K;i++) {
			card[i] = Integer.parseInt(st.nextToken());
			
			int index = binarySearch(card[i]);
			index = find(index);
			sb.append(minsu[index]).append("\n");
			union(index, index+1);
		}
		
		System.out.println(sb);
		

	}
	
	static int binarySearch(int num) {
		int idx = 0;
		
		int start =0;
		int end = M-1;
		
		while (start <= end) {
			int mid = (start+end)/2;
			
			if (minsu[mid] > num) {
				idx = mid;
				end = mid-1;
			}
			else {
				start = mid+1;
			}
		}
		
		return idx;
	}
	
	static int find(int x) {
		if (x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
	
	static void union(int a, int b) {
		int parentA = find(a);
		int parentB = find(b);
		
		if (parentA != parentB) {
			parent[parentA] = parentB;
		}
	}
	
}