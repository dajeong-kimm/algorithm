import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	
	static boolean answer = true;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> list[] = new ArrayList[N];
		for (int i=0;i<N;i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<num;j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		//길이가 짧은 순으로 
		Arrays.sort(list, Comparator.comparingInt(ArrayList::size));
		
		ArrayList<Integer> start = list[0];
		
		if (start.size() < K) {
			System.out.println("NO");
			return;
		}
		
		for (int i=0;i<start.size()-K+1;i++) {
			int[] arr = new int[K];
			for (int j=0;j<K;j++) {
				arr[j] = start.get(i+j);
			}
			int[] table = makeTable(arr);
			answer = true;
			
			for (int j=1;j<N;j++) {
				ArrayList<Integer> tmp = list[j];
				int[] text = new int[tmp.size()];
				for (int k=0;k<tmp.size();k++) {
					text[k] = tmp.get(k);
				}
				boolean result = kmp(table, arr, text);
				if (result) continue;
				
				Collections.reverse(tmp);
				for (int k=0;k<tmp.size();k++) {
					text[k] = tmp.get(k);
				}
				result = kmp(table, arr, text);
				
				if (!result) {
					answer = false;
					break;
				}
				
			}
			if (answer) {
				System.out.println("YES");
				return;
			}
			
		}
		
		System.out.println("NO");
		
	}
	static boolean kmp (int[] table, int[] arr, int[] text) {
		int i=0;
		int j=0;
		
		
		while (i<text.length) {
			if (arr[j] == text[i]) {
				i++;
				j++;
				
				if (j == arr.length) {
					return true;
				}
			}
			else {
				if (j>0) {
					j = table[j-1];
				}
				else {
					i++;
				}
			}
		}
		return false;
	}
	
	static int[] makeTable(int[] arr) {
		int n = arr.length;
		int[] table = new int[n];
		int len = 0;
		int i = 1;
		
		while (i < n) {
			if (arr[i] == arr[len]) {
				len++;
				table[i] = len;
				i++;
			}
			else {
				if (len > 0) {
					len = table[len-1];
				}
				else {
					table[i] = 0;
					i++;
				}
			}
		}
		return table;
	}

}