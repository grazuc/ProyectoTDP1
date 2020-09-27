package TDP;

public class Tester {
	
	public static void main (String args[]) {
		
		//Creamos el grafo
		Graph grafo = new Graph();
		
		//Agregamos los nodos
		grafo.addNode(1);
		grafo.addNode(2);
		grafo.addNode(3);
		grafo.addNode(4);
		grafo.addNode(5);
		grafo.addNode(5);
		
		System.out.println("--------------------------------------------------------------");
		
		//Agregamos los arcos 
		grafo.addEdge(1, 2);
		grafo.addEdge(1, 3);
		grafo.addEdge(5,3);
		grafo.addEdge(5,4);
		grafo.addEdge(4,2);
		grafo.addEdge(4,2);
		
		System.out.println("--------------------------------------------------------------");
		
		grafo.RecorroArcos();
		System.out.println("--------------------------------------------------------------");
		grafo.removeNode(5);
		System.out.println("--------------------------------------------------------------");
		grafo.RecorroArcos();
		
//		grafo.removeNode(1);
//		grafo.removeNode(2);
//		grafo.addNode(7);
//		grafo.addEdge(7,2);
//		System.out.println("--------------------------------------------------------------");
//		
//		grafo.removeEdge(0,1);
//		grafo.removeEdge(0,1);
//		grafo.removeEdge(3,5);
//		grafo.removeEdge(5,3);
//		grafo.removeEdge(5,4);
//		grafo.addEdge(5,3);
//		grafo.addEdge(5,4); 
	
	}

}
