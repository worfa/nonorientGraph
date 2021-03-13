package nonorientGraph;

public class Runner {

	public static void main(String[] args) {
		
		Graph graph = new Graph();
		
		graph.addVertex('A'); //0
		graph.addVertex('B'); //1
		graph.addVertex('C'); //2
		graph.addVertex('D'); //3
		graph.addVertex('E'); //4
		graph.addVertex('F'); //5
		graph.addVertex('G'); //6
		
		graph.addEdge(0, 1); 	//AB
		graph.addEdge(1, 2); 	//BC
		graph.addEdge(0, 3); 	//AD
		graph.addEdge(3, 4);	//DE
		graph.addEdge(6, 1);	//BG
		graph.addEdge(5, 3);	//DF
		
		//graph.passInDeap(5);
		
		graph.passInBreadth(4);
	}
}
