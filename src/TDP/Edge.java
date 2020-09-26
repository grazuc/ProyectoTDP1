package TDP;

public class Edge { 
	
	private int sucesor,predecesor;
	
	public Edge(int s, int p) {
		sucesor=s;
		predecesor=p;
	}

	public void setSucesor(int s) {
		sucesor=s;
	}
	
	public void setPredecesor(int p) {
		predecesor=p;
	}	
	
	public int getSucesor() {
		return sucesor;
	}
	
	public int getPredecesor() {
		return predecesor;
	}
	

}
