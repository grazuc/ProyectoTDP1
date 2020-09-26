package TDP;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Graph {
	private Map<Integer,Integer> mapeoNodos;
	private Map<String,Edge> mapeoArcos;
	private static Logger logger;
	public Graph() {
		mapeoNodos= new HashMap<Integer,Integer>();
		mapeoArcos= new HashMap<String,Edge>();
		if(logger==null) {
			logger= Logger.getLogger(Graph.class.getName());
			Handler hnd=new ConsoleHandler();
			logger.addHandler(hnd);
			logger.setLevel(Level.WARNING);
			Logger rootLogger=logger.getParent();
			for(Handler h : rootLogger.getHandlers())
				h.setLevel(Level.OFF);
		}
	}
	
	public void addNode(int node) {
		boolean estaNode = mapeoNodos.containsKey(node);
		if (!estaNode) {
			mapeoNodos.put(node, node);
			logger.info("El nodo ha sido agregado correctamente");
		} else logger.warning("El nodo ya existe");
	}
	
	public void addEdge(int node1, int node2) {
		boolean estaNode1 = mapeoNodos.containsKey(node1);
		boolean estaNode2 = mapeoNodos.containsKey(node2);
		String key = node1 +"," +node2;
		boolean existeArco = mapeoArcos.containsKey(key);
		if(!estaNode1) {
			logger.warning("El primer nodo dado no existe");
		} else if (!estaNode2) {
			logger.warning("El segundo nodo dado no existe");
		} else if (existeArco) {
			logger.warning("Ya existe el arco entre los nodos dados");
		} else {
			Edge arco = new Edge (node1,node2);
			mapeoArcos.put(key, arco);
			logger.info("El arco ha sido agregado correctamente");
			}
	}
	
	
	public void removeNode(int node) {
		boolean existeNode = mapeoNodos.containsKey(node);
		if (existeNode) {
			Iterator<Edge> itArcos = mapeoArcos.values().iterator();
			if (itArcos.hasNext()) {
				Edge ArcoAux = itArcos.next();
				int Sucesor,Predecesor;
				String key;
				if (ArcoAux.getPredecesor()== node) {
					Sucesor = ArcoAux.getSucesor();
					key = Sucesor +"," +node;
					mapeoArcos.remove(key);
				} else if (ArcoAux.getSucesor()==node) {
					Predecesor= ArcoAux.getPredecesor();
					key = node +"," +Predecesor;
					mapeoArcos.remove(key);
				}
			}
			mapeoNodos.remove(node);
			logger.info("El nodo fue eliminado corrrectamente");
		} else {
			logger.warning("El nodo dado no existe");
		}
	}
	
	public void removeEdge(int node1, int node2) {
		String key = node1 +"," +node2;
		boolean estaNode1 = mapeoNodos.containsKey(node1);
		boolean estaNode2 = mapeoNodos.containsKey(node2);
		boolean existeArco = mapeoArcos.containsKey(key);
		if(!estaNode1) {
			logger.warning("El primer nodo dado no existe");
		} else if (!estaNode2) {
			logger.warning("El segundo nodo dado no existe");
		} else if (!existeArco) {
			logger.warning("No existe ningun arco entre los nodos dados");
		} else {
			mapeoArcos.remove(key);
			logger.info("El arco ha sido eliminado correctamente");
		}
	}
}
