import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] dp;
    static Meet[] m;
    
    static class Meet implements Comparable<Meet> {
    	int s;
    	int e; 
    	int p;
    	
    	Meet(int s, int e, int p) {
    		this.s = s;
    		this.e = e;
    		this.p = p;
    	}
    	
    	@Override 
    	public int compareTo(Meet o) {
    		if (e != o.e) {
    			return Integer.compare(e, o.e);
    		}
    		else {
    			return Integer.compare(s, o.s);
    		}
    	}
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        m = new Meet[N];
        dp = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            m[i] = new Meet(start,end,p);
        }
        
        //종료 시간 기준으로 정렬
        Arrays.sort(m);
        
        dp[0] = m[0].p;
        
        for (int i=1;i<N;i++) {
        	int t = binarySearch(0,i,m[i].s);
        	
        	dp[i] = Math.max(dp[i-1], (t>=0 ? dp[t]:0) + m[i].p );
        }
        
        System.out.println(dp[N-1]);
       
    }
    
    //binarySearch --> 종료 시간이 시작 시간보다 작은 회의를 찾음
    public static int binarySearch(int low, int high, int key) {
    	int result = -1;
    	while (low<=high) {
    		int mid = (low+high)/2;
    		if (m[mid].e < key) {
    			result = mid;
    			low = mid+1;
    		}
    		else {
    			high = mid-1;
    		}
    	}
    	return result;
    }
}