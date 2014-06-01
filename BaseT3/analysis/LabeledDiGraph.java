package analysis;
import java.util.Stack;
import java.util.ArrayList;

public class LabeledDiGraph
{
    private int[][] matrix;
    private ArrayList<String> labels;

    public LabeledDiGraph(ArrayList<String> labels)
    {
	matrix = new int[labels.size()][labels.size()];
	this.labels = labels;
	for(int i = 0;i<labels.size();i++) {
	    for(int j=0;j<labels.size();j++) {
		matrix[i][j] = 0;
	    }
	}
    }

    public void addEdge(String from, String to) 
    {
	int idx1 = labels.indexOf(from);
	int idx2 = labels.indexOf(to);
	if(idx1 < 0 || idx2 < 0) {
	    return;
	}
	matrix[idx1][idx2] = 1;
    }

    public void remEdge(String from, String to) 
    {
	int idx1 = labels.indexOf(from);
	int idx2 = labels.indexOf(to);
	if(idx1 < 0 || idx2 < 0) {
	    return;
	}
	matrix[idx1][idx2] = 0;
    }

    public int getEdge(String from, String to) 
    {
	int idx1 = labels.indexOf(from);
	int idx2 = labels.indexOf(to);
	if(idx1 < 0 || idx2 < 0) {
	    return -1;
	}
	return matrix[idx1][idx2];
    }

    public void transitiveClosure()
    {
	int n = labels.size();
	for(int i=0;i<n;i++) {
	    matrix[i][i] = 1;
	}
	for(int k=0;k<n;k++) {
	    for(int i=0;i<n;i++) {
		for(int j=0;j<n;j++) {
		    if(matrix[i][k] * matrix[k][j] == 1) {
			matrix[i][j] = 1;
		    }
		}
	    }
	}
    }

    public ArrayList<String> invTopologicalSort()
    {
	/*
	 * orden topológico invertido. Retorna null
	 * si el grafo es cíclico.
	 */
	ArrayList<String> ret = new ArrayList<String>();
	Stack<String> inDZ = new Stack<String>();
	int size = labels.size();
	for(int i=0;i<size;i++){
	    matrix[i][i] = 0;
	}
	for(String lb : labels) {
	    if(inDegree(lb) == 0) {
		inDZ.push(lb);
	    }
	}
	while(! inDZ.empty()) {
	    String lb = inDZ.pop();
	    ret.add(0,lb);
	    for(String lb2 : labels) {
		if(getEdge(lb,lb2) == 1) {
		    remEdge(lb,lb2);
		    if(inDegree(lb2) == 0) {
			inDZ.push(lb2);
		    }
		}
	    }
	}
	for(int i=0;i<size;i++) {
	    for(int j=0;j<size;j++) {
		if(matrix[i][j]==1 && i!=j) {
		    return null;
		}
	    }
	}
	return ret;
    }

    private int inDegree(String label)
    {
	int idx = labels.indexOf(label);
	if(idx < 0) {
	    return -1;
	}
	int ret = 0;
	for(String lb : labels) {
	    if(!labels.equals(label) && getEdge(lb, label) == 1) {
		ret++;
	    }
	}
	return ret;
    }

    public LabeledDiGraph copy ()
    {
	LabeledDiGraph newGraph = new LabeledDiGraph(labels);
	int size = labels.size();
	for(int i=0;i<size;i++) {
	    for(int j=0;j<size;j++) {
		newGraph.matrix[i][j]=this.matrix[i][j];
	    }
	}
	return newGraph;
    }

    public void print()
    {
	for(int i=0;i<labels.size();i++) {
	    for(int j=0;j<labels.size();j++) {
		System.out.printf("%d", matrix[i][j]);
	    }
	    System.out.printf("\n");
	}
    }
}
