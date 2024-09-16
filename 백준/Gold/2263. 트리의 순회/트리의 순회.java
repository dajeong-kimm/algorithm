import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 트리의 순회
 * n개의 정점을 갖는 이진 트리 1 ~ n 까지의 번호가 중복 없이 매겨져 있음
 * 인오더
 * 포스트오더
 * --> 프리오더?
 * @author KOREA
 *
 */
public class Main {
	static int n;
	static int[] inorder;
	static int[] postorder;
	static int[] index; //inorder에서 각 값의 인덱스 저장

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		inorder = new int[n];
		postorder = new int[n];
		index = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<n;i++) {
			inorder[i] = Integer.parseInt(st.nextToken());
			index[inorder[i]] = i;
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<n;i++) {
			postorder[i] = Integer.parseInt(st.nextToken());
		}
		
		getPreorder(0, n-1, 0, n-1);

	}
	public static void getPreorder(int inStart, int inEnd, int postStart, int postEnd) {
		if (inStart > inEnd || postStart > postEnd) return;
		
		//postorder의 끝값이 현재 서브트리의 루트 노드
		int root = postorder[postEnd];
		
		System.out.print(root+" ");
		
		//inorder 배열에서 루트 노드의 인덱스 찾기
		int rootIndex = index[root];
		
		//왼쪽 서브트리의 크기 계산
		int leftSize = rootIndex - inStart;
		
		//왼쪽 서브트리 재귀
		getPreorder(inStart, rootIndex-1, postStart, postStart + leftSize -1);
		
		//오른쪽 서브트리 재귀
		getPreorder(rootIndex+1, inEnd, postStart+leftSize, postEnd-1);
	}

}