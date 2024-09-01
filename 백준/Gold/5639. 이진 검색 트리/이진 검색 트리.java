import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 이진검색트리
 * 전위 순회한 결과가 주어졌을 때, 
 * 이 트리를 후위순회한 결과를 구하는 프로그램 
 * 
 * 1. 처음 값을 root로 설정
 * 2. 반복문을 돌면서 Node에 insert 함수를 구현해
 * 현재 노드의 값보다 작으면 왼쪽 자식, 크면 오른쪽 자식으로 넘어가
 * null일 경우 해당 노드를 생성해주고 아니면 재귀적으로 다시 탐색
 * @author KOREA
 *
 */
public class Main {
	static class Node {
		int num;
		Node left, right;
		
		Node(int num){
			this.num = num;
		}
		Node(int num, Node left, Node right){
			this.num = num;
			this.left = left;
			this.right = right;
		}
		
		void insert(int n) {
			if (n < this.num) {
				if (this.left == null) {
					this.left = new Node(n);
				} else {
					this.left.insert(n);
				}
			} else {
				if (this.right == null) {
					this.right = new Node(n);
				} else {
					this.right.insert(n);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Node root = new Node(Integer.parseInt(br.readLine()));
		
		String input;
		while (true) {
			input = br.readLine();
			if (input == null || input.equals("")) {
				break;
			}
			root.insert(Integer.parseInt(input));
		}
		
		postOrder(root);
	}
	public static void postOrder(Node node) {
		if (node == null) return;
		
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.num);
	}
	

}