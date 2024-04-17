/**
 * Class BSTNode implements a node in a binary search tree.
 * Each node of the tree has an integer as the node's label (value).
 * @author (nxthang) 
 * @version (1.0)
 */
package DSAall.DSA_TUT10.Example2;

public class BSTNode
{
    int value;
    
    /**
     * Constructor for objects of class BSTNode
     */
    public BSTNode(int value)
    {
        this.value = value;

    }

    public void setValue(int value)
    {
        this.value = value;

    }
    
    public int getValue()
    {
        return value;

    }
    public int getKey() {
        return value;
    }
}
