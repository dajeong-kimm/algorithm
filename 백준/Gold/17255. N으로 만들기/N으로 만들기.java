import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	static Set<String> set = new HashSet<>();
	static int len;
	static char[] arr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = br.readLine().toCharArray();
		len = arr.length;
		
		for (int i=0;i<len;i++) {
			dfs(i, i, ""+arr[i], ""+arr[i]);
		}
		System.out.println(set.size());

	}
	
	static void dfs(int curL, int curR, String cur, String total) {
//		System.out.println("cur: "+cur);
		if (curL == 0 && curR == len-1) {
//			System.out.println("add cur: "+cur);
			set.add(total);
			return;
		}
		
		String newCur;
		String newTotal;
		
		if (curR < len-1) {
			newCur = cur+arr[curR+1];
			newTotal = total+newCur;
			dfs(curL, curR+1, newCur, newTotal);
		}
		if (curL > 0) {
			newCur = arr[curL-1]+cur;
			newTotal = total+newCur;
			dfs(curL-1, curR, newCur, newTotal);
		}
	}

}
