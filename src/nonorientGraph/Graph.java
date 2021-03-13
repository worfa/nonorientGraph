package nonorientGraph;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {

	private int maxV = 10;
	private int[][] mas;
	private Vertex[] vertexList;
	private int count;
	
	private Stack<Integer> stack = new Stack<>();
	private Deque<Integer> queue = new LinkedList();
	
	public Graph(){
		mas = new int [maxV][maxV];
		count = 0;
		vertexList = new Vertex[maxV];
	}
	
	public void addVertex(char name) {
		vertexList[count++] = new Vertex (name);
	}
	
	public void addEdge(int start, int end) {
		mas[start][end] = 1;
		mas[end][start] = 1;
	}
	
	private int check(int v) {
		for(int i = 0; i < count; i++) {
			if(mas[v][i] == 1 && vertexList[i].isVisited == false) {
				return i;
			}
		}
		return -1;
	}
	
	
	
//����� � �������
	public void passInDeap(int index) {
		System.out.println(vertexList[index].name);
		vertexList[index].isVisited = true;			//�������� ��� �� ���� � ������� ����
		stack.push(index);							//��������� ���� � ����
		
		while(!stack.isEmpty()) {
			int neigh = check(stack.peek());		//��������� ���� �� ������� � ������ ������,
													//���� ����, ��� -1 ���� �� ���
		
			if(neigh == -1) {				//������� ���
				stack.pop();						//�������� ������, ������������ ����������� ��������

			}
			else {									//������ ����
				vertexList[neigh].isVisited = true; //������ ��� �� ��� ����
				System.out.println(vertexList[neigh].name + " push");
				stack.push(neigh);					//��������� ������� �� �������� �������
			}
		}
		
		for(int i = 0; i < count; i++) {
			vertexList[i].isVisited = false;
		}
	}
	
	public void passInBreadth(int index) {
		System.out.println(vertexList[index].name);
		vertexList[index].isVisited = true;
		queue.addFirst(index);
		
		while(!queue.isEmpty()) {
			int neihg = check(queue.peekLast());
			
			if(neihg == -1) {
				queue.removeLast();
			}
			else {
				System.out.println(vertexList[neihg].name);
				vertexList[neihg].isVisited = true;
				queue.addFirst(neihg);
			}
		}
		
		for(int i = 0; i < count; i++) {
			vertexList[i].isVisited = true;
		}
	}
}
