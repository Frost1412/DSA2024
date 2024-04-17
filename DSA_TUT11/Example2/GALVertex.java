/**
 * Class GALVertex implement a simple vertex of a graph. Each vertex is assigned a character label.
 * @author (nxthang) 
 * @version (1.0)
 */
package DSAall.DSA_TUT11.Example2;
public class GALVertex
{
    private char label;
    private char color;
    private SLList adjList;
    /**
     * Constructor for objects of class GVertex
     */
    public GALVertex(char label)
    {
    	this.label = label;
    	adjList = new SLList();
    }
    
    public char getLabel()
    {
    	return this.label;
    }
    
    public void setLabel(char label)
    {
    	this.label=label;
    }
    
    public char getColor()
    {
    	return this.color;
    }
    
    public void setColor(char color)
    {
    	this.color = color;
    }
    
    public void addToAdjList(int vertex)
    {
    	SLNode v = new SLNode(vertex);
    	adjList.add(v);
    }
    
    public SLList getAdjList()
    {
    	return adjList;
    }
}
