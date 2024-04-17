/**
 * Class GVertex implement a simple vertex of a graph. Each vertex is assigned a character label.
 * @author (nxthang) 
 * @version (1.0)
 */
package DSAall.DSA_TUT11.Example1;
public class GVertex
{
    private char label;
    private char color;
    /**
     * Constructor for objects of class GVertex
     */
    public GVertex(char label)
    {
    	this.label = label;
    }
    
    public char getLabel()
    {
    	return label;
    }
    
    public void setLabel(char label)
    {
    	this.label = label;
    }
    
    public char getColor()
    {
    	return this.color;
    }
    
    public void setColor(char color)
    {
    	this.color = color;
    }
}
